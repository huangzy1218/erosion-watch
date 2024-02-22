package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.Member;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Huang Z.Y.
 */
public interface MemberService {
    void register(String username, String password, String email, String authCode);

    String login(String username, String password);

    Member getCurrentMember();

    String generateAuthCode(String telephone);

    void updatePassword(String telephone, String password, String authCode);

    String refreshToken(String token);

    UserDetails loadUserByUsername(String username);
}
