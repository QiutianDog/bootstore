package fun.qiutiandog.bookstore.domain;

import javax.persistence.*;

/**
 * 管理员账户
 * @author QiutianDog
 * @date 2021/5/24
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id()
    @Column(name = "id", length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "password", length = 32)
    private String password;

    public Admin() {
    }

    public Admin(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
