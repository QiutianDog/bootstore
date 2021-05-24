package fun.qiutiandog.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author QiutianDog
 * @date 2021/5/19
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * 注册拦截器，拦截直接访问后台的请求。未登录会被跳转到登录页面。
     * @param registry 注册机
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptors())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/user/login", "/static/**");
    }


}
