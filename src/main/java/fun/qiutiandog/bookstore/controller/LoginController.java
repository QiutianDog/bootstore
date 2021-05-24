package fun.qiutiandog.bookstore.controller;

import fun.qiutiandog.bookstore.domain.Admin;
import fun.qiutiandog.bookstore.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author QiutianDog
 * @date 2021/5/20
 */
@Controller
public class LoginController {

    private AdminServiceImpl adminService;

    @Autowired
    public void setAdminServiceImpl(AdminServiceImpl adminService){
        this.adminService = adminService;
    }

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
        // 管理员登录
        if ("admin".equals(username)) {
            setAdminServiceImpl(adminService);
            Admin login = adminService.login(username, password);
            if (login != null){
                // 登录成功
                session.setAttribute("user", login);
                return "redirect:/dashboard";
            } else {
                model.addAttribute("msg", "用户名或密码错误！");
                return "login";
            }
        }

        // 普通用户登录 TODO
        return "login";
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }
}
