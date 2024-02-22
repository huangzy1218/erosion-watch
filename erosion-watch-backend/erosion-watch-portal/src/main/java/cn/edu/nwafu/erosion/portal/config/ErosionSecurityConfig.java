package cn.edu.nwafu.erosion.portal.config;

import cn.edu.nwafu.erosion.portal.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * erosion-watch-security 模块相关配置。
 *
 * @author Huang Z.Y.
 */
@Configuration
public class ErosionSecurityConfig {
    @Autowired
    private MemberService memberService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> memberService.loadUserByUsername(username);
    }
}
    