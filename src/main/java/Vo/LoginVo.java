package Vo;

import lombok.Data;

/**
 * @author kuangfeng
 * @date 2019-12-17 20:44
 */
@Data
public class LoginVo {
    private String mobile;
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
