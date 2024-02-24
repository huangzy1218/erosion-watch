package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.Member;

/**
 * 用户信息缓存业务类。
 *
 * @author Huang Z.Y.
 */
public interface MemberCacheService {
    /**
     * 删除会员用户缓存
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     */
    Member getMember(String username);

    /**
     * 设置会员用户缓存
     */
    void setMember(Member member);

    /**
     * 设置验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);
}
