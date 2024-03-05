package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.exception.Asserts;
import cn.edu.nwafu.erosion.mapper.MemberMapper;
import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.model.MemberExample;
import cn.edu.nwafu.erosion.portal.domain.MemberDetails;
import cn.edu.nwafu.erosion.portal.service.MemberCacheService;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import cn.edu.nwafu.erosion.security.util.JwtTokenUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * {@link MemberService} 的实现类。
 *
 * @author Huang Z.Y.
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Value("${redis.key.auth-code}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.expire.auth-code}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Autowired
    private MemberCacheService memberCacheService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member getByUsername(String username) {
        Member member = memberCacheService.getMember(username);
        if (member != null) {
            return member;
        }
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(example);
        if (!CollUtil.isEmpty(members)) {
            member = members.get(0);
            memberCacheService.setMember(member);
            return member;
        }
        return null;
    }

    @Override
    public Member getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public void register(String username, String password, String telephone, String authCode) {
        // 验证验证码
        if (verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        // 查询是否已有该用户
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneNumberEqualTo(telephone));
        List<Member> members = memberMapper.selectByExample(example);
        if (!CollUtil.isEmpty(members)) {
            Asserts.fail("该用户已存在");
        }
        // 没有该用户进行添加操作
        Member member = new Member();
        member.setUsername(username);
        member.setPhoneNumber(telephone);
        member.setPassword(passwordEncoder.encode(password));
        member.setRegistrationDate(new Date());
        memberMapper.insert(member);
        member.setPassword(null);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Member getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication authentication = ctx.getAuthentication();
        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();
        return memberDetails.getMember();
    }

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(telephone, sb.toString());
        return sb.toString();
    }

    @Override
    public int updatePassword(String telephone, String password, String authCode) {
        MemberExample example = new MemberExample();
        example.createCriteria().andPhoneNumberEqualTo(telephone);
        List<Member> members = memberMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(members)) {
            Asserts.fail("该账号不存在");
        }
        // 验证验证码
        if (verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        Member member = members.get(0);
        member.setPassword(passwordEncoder.encode(password));
        int count = memberMapper.updateByPrimaryKey(member);
        memberCacheService.delMember(member.getId());
        return count;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = getByUsername(username);
        if (member != null) {
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public int completeProfile(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    private boolean verifyAuthCode(String authCode, String telephone) {
        if (StrUtil.isEmpty(authCode)) {
            return true;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        // return authCode.equals(realAuthCode);todo
        return false;
    }
}
    