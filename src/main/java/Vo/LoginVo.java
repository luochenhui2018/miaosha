package Vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

/**
 * @author kuangfeng
 * @date 2019-12-17 20:44
 */
@Data
public class LoginVo {
    @NonNull
    private String mobile;
    @NonNull
    @Length(min = 32)
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
