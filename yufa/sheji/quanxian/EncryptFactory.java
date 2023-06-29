package sheji.quanxian;

public class EncryptFactory {

    public static PasswordEncrypt create(String clazz){
        try {
            Class cls = Class.forName(clazz);
            Object obj = cls.newInstance();
            if(obj instanceof PasswordEncrypt){
                return (PasswordEncrypt)obj;
            }else{
                throw new RuntimeException("class not found:" + clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException("class not found:" + clazz);
        }
    }
}
