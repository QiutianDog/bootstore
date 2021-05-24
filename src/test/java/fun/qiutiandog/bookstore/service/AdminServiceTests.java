package fun.qiutiandog.bookstore.service;

import fun.qiutiandog.bookstore.domain.Admin;
import fun.qiutiandog.bookstore.service.Impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author QiutianDog
 * @date 2021/5/24
 */
@SpringBootTest
public class AdminServiceTests {

    @Autowired
    AdminServiceImpl adminService;

    @Test
    public void loginTest(){
        Admin login = adminService.login("admin", "root");
        System.out.println(login);
    }

    @Test
    public void updateTest(){
        Admin admin = new Admin();
        admin.setId(1);
        admin.setPassword("root");
        Admin update = adminService.update(admin);
        System.out.println(update);
    }
}
