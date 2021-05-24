package fun.qiutiandog.bookstore.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author QiutianDog
 * @date 2021/5/20
 */
public class LoginHandleInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            // 登录失败
            request.setAttribute("msg", "请先登录！");
            request.getRequestDispatcher("/user/login").forward(request, response);
            return false;
        }
        return true;
    }
}
