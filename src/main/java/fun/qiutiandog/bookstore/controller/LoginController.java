package fun.qiutiandog.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author QiutianDog
 * @date 2021/5/20
 */
@Controller
public class LoginController {
    @GetMapping("/user/login")
    public String login(){
        return "login";
    }

    @PostMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ){
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            // 登录成功
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }
}
