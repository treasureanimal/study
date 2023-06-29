package sheji.quanxian;

public class Subject implements Auth{

    private AuthToken token;
    @Override
    public boolean login(AuthToken token) {

        //调用密码加密策略
        String password = (new EncryptContext()).encrypt(token.getPassword());
        token.setPassword(password);
        //调用auth方法，即触发责任链
        if(AuthManager.getInstance().auth(token)){
            System.out.println("登录成功");
            this.token = token;
            return true;
        }
        return false;
    }

    @Override
    public boolean isLogin() {
        return token != null;
    }

    @Override
    public boolean isPermitted(String permission) {
        PermissionInfo info =  AuthManager.getInstance().getPermissionInfo(this.token);
        return info != null && info.isPermitted(permission);
    }

    public String getUsername(){
        return token.getUsername();
    }
}
