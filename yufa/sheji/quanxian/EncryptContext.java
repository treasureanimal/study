package sheji.quanxian;

public class EncryptContext {

    private PasswordEncrypt pe;

    public EncryptContext() {
        String cls = Config.get("encryptType","com.study.sheji.shizhan.quanxian.Md5Encrypt");
        this.pe = EncryptFactory.create(cls);;
    }

    public String encrypt(String password){
        return this.pe.encrypt(password);
    }
}
