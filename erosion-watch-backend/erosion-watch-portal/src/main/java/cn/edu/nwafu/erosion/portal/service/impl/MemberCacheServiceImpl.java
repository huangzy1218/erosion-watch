package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.erosion.mapper.MemberMapper;
import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.portal.service.MemberCacheService;
import cn.edu.nwafu.erosion.security.annoation.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * {@link MemberCacheService} 的实现类。
 *
 * @author Huang Z.Y.
 */
@Service
public class MemberCacheServiceImpl implements MemberCacheService {
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.expire.auth-code}")
    private Long REDIS_EXPIRE_AUTH_CODE;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${redis.key.auth-code}")
    private String REDIS_KEY_AUTH_CODE;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void delMember(Long memberId) {
        Member member = memberMapper.selectByPrimaryKey(memberId);
        if (member != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public Member getMember(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
        return (Member) redisService.get(key);
    }

    @Override
    public void setMember(Member member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
        redisService.set(key, member, REDIS_EXPIRE);
    }

    @Override
    @CacheException
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
    }

    @Override
    @CacheException
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        return (String) redisService.get(key);
    }
}
    