package sheji.quanxian;

/**
 * 用户认证信息
 */
public class AuthToken {

    private String username;
    private String password;

    public AuthToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthToken() {
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
}
