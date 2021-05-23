package fun.qiutiandog.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台界面管理
 * @author QiutianDog
 * @date 2021/5/23
 */
@Controller
public class DashBoardController {
    @GetMapping("/dashboard")
    public String dashBoard(){
        return "dashboard/dashboard";
    }
}
