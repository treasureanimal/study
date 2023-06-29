package sheji.quanxian;

public class MyEncrypt implements PasswordEncrypt {
    @Override
    public String encrypt(String password) {
        return password + " encrypted pwd";
    }
}
