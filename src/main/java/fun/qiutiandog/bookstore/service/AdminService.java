package fun.qiutiandog.bookstore.service;

import fun.qiutiandog.bookstore.domain.Admin;

/**
 * @author QiutianDog
 * @date 2021/5/24
 */
public interface AdminService {
    /**
     * 超级管理员的登录接口
     * @param username 用户名，强制为admin
     * @param password 密码，可以更改
     * @return 管理员对象，里面存储各种信息
     */
    Admin login(String username, String password);

    /**
     * 超级管理更新接口，不允许更新用户名。
     * @param admin 新的用户对象，不需要更改的属性为 null，需要更改的属性设置对应的属性即可
     * @return 更新后的管理员对象，里面存储各种信息
     */
    Admin update(Admin admin);
}
