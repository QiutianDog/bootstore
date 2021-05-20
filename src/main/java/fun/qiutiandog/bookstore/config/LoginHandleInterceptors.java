package fun.qiutiandog.bookstore.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author QiutianDog
 * @date 2021/5/20
 */
public class LoginHandleInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            // 登录失败
            request.setAttribute("msg", "请先登录。");
            request.getRequestDispatcher("/user/login").forward(request, response);
        }
        return true;
    }
}
