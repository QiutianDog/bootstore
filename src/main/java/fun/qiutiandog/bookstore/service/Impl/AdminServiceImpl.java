package fun.qiutiandog.bookstore.service.Impl;

import fun.qiutiandog.bookstore.domain.Admin;
import fun.qiutiandog.bookstore.repository.AdminRepository;
import fun.qiutiandog.bookstore.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @date 2021/5/24
 */
@Service
public class AdminServiceImpl implements AdminService {
    
    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin login(String username, String password) {
        return repository.findAdminByUsernameAndPassword(username, password);
    }

    @Override
    public Admin update(Admin admin) {
        // 根据id获取原数据
        Integer id = admin.getId();
        Admin old = repository.findById(id).orElse(null);

        // 获取新用户的信息(不包含username)。 TODO 持续更新中...
        String password = admin.getPassword();

        // 构造新的用户对象
        Admin update = new Admin();
        update.setId(id);
        assert old != null;
        update.setUsername(old.getUsername());

        if (password == null) {
            update.setPassword(old.getPassword());
        } else {
            update.setPassword(password);
        }

        // 更新
        return repository.saveAndFlush(update);
    }
}
