package sheji.quanxian;

public abstract class AuthRealm {

    private AuthRealm successor;

    public void setSuccessor(AuthRealm successor) {
        this.successor = successor;
    }

    public final boolean auth(AuthToken token){
        if(token == null) return false;
        //如果验证成功，就返回成功
        if(this.loginAuth(token)){
            return true;
        }
        //失败就将请求传给下一个责任处理器
        return successor != null && successor.auth(token);
    }

    /**
     * 登录验证
     * @return
     */
    protected abstract boolean loginAuth(AuthToken token);

    /**
     * 权限验证
     * @return
     */
    protected abstract PermissionInfo doGetPermissionInfo(AuthToken token);
}
