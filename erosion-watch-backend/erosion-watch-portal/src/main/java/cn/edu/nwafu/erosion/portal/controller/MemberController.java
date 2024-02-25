package cn.edu.nwafu.erosion.portal.controller;

import cn.edu.nwafu.common.api.CommonResult;
import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.portal.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Huang Z.Y.
 */
@Controller
@Api(tags = "MemberController")
@Tag(name = "MemberController", description = "用户登录注册管理")
@RequestMapping("/auth")
public class MemberController {
    @Value("${jwt.token-header}")
    private String tokenHeader;
    @Value("${jwt.token-head}")
    private String tokenHead;

    @Autowired
    private MemberService memberService;

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> register(@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String telephone,
                                    @RequestParam String authCode) {
        memberService.register(username, password, telephone, authCode);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> login(@RequestParam String username,
                                 @RequestParam String password) {
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> info(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        Member member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiOperation("用户修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> updatePassword(@RequestParam String telephone,
                                          @RequestParam String password,
                                          @RequestParam String authCode) {
        memberService.updatePassword(telephone, password, authCode);
        return CommonResult.success(null, "密码修改成功");
    }


    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("完善用户资料")
    @RequestMapping(value = "/completeProfile", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<?> completeProfile(@RequestParam Long userId,
                                           @RequestParam(required = false) String nickname,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName,
                                           @RequestParam(required = false) String gender,
                                           @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                                           @RequestParam(required = false) String address,
                                           @RequestParam(required = false) String profilePicture,
                                           @RequestParam(required = false) String biography,
                                           @RequestParam(required = false) String organization,
                                           @RequestParam(required = false) String realName) {
        Member member = Member.builder()
                .id(userId)
                .nickname(nickname)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .dateOfBirth(dateOfBirth)
                .address(address)
                .profilePicture(profilePicture)
                .biography(biography)
                .organization(organization)
                .realName(realName).build();
        memberService.completeProfile(member);
        return CommonResult.success(null, "用户资料已完善");
    }
}
    