package sheji.quanxian;

import java.util.HashMap;
import java.util.Map;

public class SecurityUtils {

    private static Map<String, Subject> subjectList = new HashMap<>();

    /**
     * 获取当前请求的用户
     * @return
     */
    public static Subject getSubject(){
        //此处应借用 Session 等方式获取当前请求用户
        String name = "123";
        Subject subject = subjectList.get(name);
        return subject == null ? new Subject() : subject;
    }

    public static void addSubject(Subject subject){
        subjectList.put("123",subject);
    }
}
