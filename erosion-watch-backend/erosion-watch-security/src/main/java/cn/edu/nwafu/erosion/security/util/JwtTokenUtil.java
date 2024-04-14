package cn.edu.nwafu.erosion.security.util;

import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.erosion.security.dto.UserToken;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * JwtToken生成的工具类，JWT token的格式：{@code header.payload.signature}。<br/>
 * <ul>
 *  <li>header 的格式（算法、token的类型）： {"alg": "HS512","typ": "JWT"}</li>
 *  <li>payload 的格式（用户名、创建时间、生成时间）： {"sub":"wang","created":1489079981393,"exp":1489684781}</li>
 *  <li>signature 的生成算法： HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)</li>
 * </ul>
 *
 * @author Huang Z.Y.
 */
@Slf4j
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.blacklist}")
    public String tokenBlackListPrefix;
    @Value("${jwt.expire.access-token}")
    private Long accessTokenExpire;
    @Value("${jwt.expire.refresh-token}")
    private Long refreshTokenExpire;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.token-head}")
    private String tokenHead;
    @Autowired
    private RedisService redisService;

    /**
     * 根据负责生成 JWT 的 token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从 token 中获取 JWT 中的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 生成 token 的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从 token 中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证 token 是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断 token 是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成 token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 当原来的 token 没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    public String refreshHeadToken(String oldToken) {
        if (StrUtil.isEmpty(oldToken)) {
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        // token 校验不通过
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return null;
        }
        // 如果token已经过期，不支持刷新
        if (isTokenExpired(token)) {
            return null;
        }
        // 如果token在30分钟之内刚刷新过，返回原token
        if (tokenRefreshJustBefore(token, 30 * 60)) {
            return token;
        } else {
            claims.put(CLAIM_KEY_CREATED, new Date());
            addBlacklist(oldToken, getExpirationDate(oldToken));
            return generateToken(claims);
        }
    }

    /**
     * 判断 token 在指定时间内是否刚刚刷新过
     *
     * @param token 原 token
     * @param time  指定时间（秒）
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        // 刷新时间在创建时间的指定时间内
        return refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created, time));
    }

    /**
     * 保存 刷新令牌 与 访问令牌 关联关系 到redis
     *
     * @param userToken              用户令牌
     * @param refreshTokenExpireDate 刷新令牌过期日期
     */
    public void tokenAssociation(UserToken userToken, Date refreshTokenExpireDate) {
        long time = (refreshTokenExpireDate.getTime() - System.currentTimeMillis()) / 1000 + 100;
        redisService.set(userToken.getRefreshToken(), userToken.getAccessToken(), time, TimeUnit.SECONDS);
    }

    /**
     * 根据 刷新令牌 获取 访问令牌
     *
     * @param refreshToken 刷新令牌
     */
    public String getAccessTokenByRefresh(String refreshToken) {
        Object value = redisService.get(refreshToken);
        return value == null ? null : String.valueOf(value);
    }

    public void addBlacklist(String token, Date expireTime) {
        long expireTimeLong = (expireTime.getTime() - System.currentTimeMillis()) / 1000 + 100;
        redisService.set(getBlacklistPrefix(token), "1", expireTimeLong, TimeUnit.SECONDS);
    }

    public String getBlacklistPrefix(String token) {
        return tokenBlackListPrefix + token;
    }

    public boolean checkBlackList(String token) {
        return redisService.hasKey(getBlacklistPrefix(token));
    }

    /**
     * 生成双令牌
     */

    public UserToken generateTokens(UserDetails userDetails) {
        Date nowDate = new Date();
        Date accessTokenExpireDate = new Date(nowDate.getTime() + accessTokenExpire * 1000);
        Date refreshTokenExpireDate = new Date(nowDate.getTime() + refreshTokenExpire * 1000);
        UserToken userToken = new UserToken();
        String username = userDetails.getUsername();
        userToken.setUsername(username);
        userToken.setAccessToken(createToken(userDetails, nowDate, accessTokenExpireDate));
        userToken.setRefreshToken(createToken(userDetails, nowDate, refreshTokenExpireDate));
        // 创建 刷新令牌 与 访问令牌 关联关系
        tokenAssociation(userToken, refreshTokenExpireDate);
        return userToken;
    }

    public String createToken(UserDetails userDetails, Date date, Date expireDate) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(JSONObject.toJSONString(userDetails))
                .setIssuedAt(date)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取 token 中的注册信息
     */
    public Claims getTokenClaim(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    /**
     * 获取 token 的发布时间
     */
    public Date getIssudedDate(String token) {
        return getTokenClaim(token).getIssuedAt();
    }

    public Date getExpirationDate(String token) {
        return getTokenClaim(token).getExpiration();
    }
}
