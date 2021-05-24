package fun.qiutiandog.bookstore.repository;

import fun.qiutiandog.bookstore.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QiutianDog
 * @date 2021/5/24
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    /**
     * 超级管理员的登录接口
     * @param username 用户名，强制为admin
     * @param password 密码，可以更改
     * @return 管理员对象，里面存储各种信息
     */
    Admin findAdminByUsernameAndPassword(String username, String password);
}
