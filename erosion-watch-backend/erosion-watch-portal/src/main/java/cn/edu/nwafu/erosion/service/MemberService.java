package cn.edu.nwafu.erosion.service;

/**
 * @author Huang Z.Y.
 */
public interface MemberService {

    void register(String username, String password, String telephone, String authCode);

    String login(String username, String password);
}
