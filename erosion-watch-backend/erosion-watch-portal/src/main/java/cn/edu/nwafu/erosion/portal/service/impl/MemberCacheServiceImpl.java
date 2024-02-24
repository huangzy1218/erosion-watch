package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.portal.service.MemberCacheService;
import org.springframework.stereotype.Service;

/**
 * @author Huang Z.Y.
 */
@Service
public class MemberCacheServiceImpl implements MemberCacheService {
    @Override
    public void delMember(Long memberId) {
        
    }

    @Override
    public Member getMember(String username) {
        return null;
    }

    @Override
    public void setMember(Member member) {

    }

    @Override
    public void setAuthCode(String telephone, String authCode) {

    }

    @Override
    public String getAuthCode(String telephone) {
        return null;
    }
}
    