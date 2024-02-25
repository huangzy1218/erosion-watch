package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.Member;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Huang Z.Y.
 */
public interface MemberService {
    Member getByUsername(String username);

    Member getById(Long id);

    void register(String username, String password, String telephone, String authCode);

    String login(String username, String password);

    Member getCurrentMember();

    String generateAuthCode(String telephone);

    int updatePassword(String telephone, String password, String authCode);

    String refreshToken(String token);

    UserDetails loadUserByUsername(String username);

    int completeProfile(Member member);
}
