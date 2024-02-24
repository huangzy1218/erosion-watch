package cn.edu.nwafu.erosion.security.component;

import cn.edu.nwafu.common.api.CommonResult;
import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义未登录或者 token 失效时的返回结果。
 *
 * @author Huang Z.Y.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * 处理未认证的请求，返回未授权的响应结果。
     *
     * @param request       HTTP 请求
     * @param response      HTTP 响应
     * @param authException 认证异常
     * @throws IOException      如果发生 I/O 错误
     * @throws ServletException 如果发生 Servlet 错误
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
