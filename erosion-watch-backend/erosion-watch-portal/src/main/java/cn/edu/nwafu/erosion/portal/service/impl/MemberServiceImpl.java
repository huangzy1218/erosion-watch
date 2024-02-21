package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Huang Z.Y.
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {


    @Override
    public void register(String username, String password, String email, String authCode) {

    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public Member getCurrentMember() {
        return null;
    }

    @Override
    public String generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {

    }

    @Override
    public String refreshToken(String token) {
        return null;
    }
}
    