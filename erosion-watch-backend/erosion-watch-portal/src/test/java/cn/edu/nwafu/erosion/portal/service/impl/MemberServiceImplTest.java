package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Huang Z.Y.
 */
@SpringBootTest
class MemberServiceImplTest {
    @Autowired
    private MemberService memberService;

    @Test
    void sendAuthCode() {
        memberService.sendAuthCode("huangzy@nwafu.edu.cn");
    }
}