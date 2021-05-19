package fun.qiutiandog.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author QiutianDog
 * @date 2021/5/19
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("common/index");
    }
}
