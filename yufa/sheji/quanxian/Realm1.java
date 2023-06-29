package sheji.quanxian;

import java.util.HashSet;
import java.util.Set;

public class Realm1 extends AuthRealm{

    @Override
    protected boolean loginAuth(AuthToken token) {
        System.out.println("===Realm1 loginAuth===");
        String username = token.getUsername();
        String pwd = token.getPassword();
        //传进来的密码是加密过的密码，直接和数据库中的密码比对
        System.out.println("pwd:"+pwd);
        //查询数据库操作略过
        return false;
    }

    @Override
    protected PermissionInfo doGetPermissionInfo(AuthToken token) {

        String username = token.getUsername();
        System.out.println("doGetPermissionInfo1");
        //从数据库读取该用户的权限信息
        PermissionInfo info = new PermissionInfo();
        Set<String> s = new HashSet<String>();
        s.add("permission1");
        s.add("permission2");
        info.setPermissions(s);
        //角色
        Set<String> r = new HashSet<String>();
        r.add("role1");
        info.setRoles(r);
        return info;

    }
}
