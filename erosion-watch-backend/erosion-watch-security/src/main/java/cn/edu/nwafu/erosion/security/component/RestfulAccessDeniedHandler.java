package cn.edu.nwafu.erosion.security.component;

import cn.edu.nwafu.common.api.CommonResult;
import cn.hutool.json.JSONUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义无权限访问的返回结果。
 *
 * @author Huang Z.Y.
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 处理访问被拒绝的情况，返回禁止访问的响应结果。
     *
     * @param request  HTTP 请求
     * @param response HTTP 响应
     * @param e        访问被拒绝的异常
     * @throws IOException      如果发生 I/O 错误
     * @throws ServletException 如果发生 Servlet 错误
     */
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
