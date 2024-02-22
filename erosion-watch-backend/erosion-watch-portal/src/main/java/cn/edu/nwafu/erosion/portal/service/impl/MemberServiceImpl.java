package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.MemberMapper;
import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import cn.edu.nwafu.erosion.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Huang Z.Y.
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private MemberMapper memberMapper;

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

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
    