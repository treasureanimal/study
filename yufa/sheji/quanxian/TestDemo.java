package sheji.quanxian;

import java.io.IOException;

public class TestDemo {
    public static void main(String[] args) throws IOException {
        //测试密码加密
        String encryptedPwd = (new EncryptContext()).encrypt("123");
        System.out.println("加密后："+encryptedPwd);
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        //是否登录
        System.out.println("是否已登录："+currentUser.isLogin());
        //执行登录操作
        currentUser.login(new AuthToken("admin","123"));
        //是否登录
        System.out.println("是否已登录："+currentUser.isLogin());
        //是否有权限，权限用字符串表示
        System.out.println("是否有权限："+currentUser.isPermitted("permission1"));
    }
}
