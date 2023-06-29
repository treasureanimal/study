package threadloacldemo;


import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ThreadLocal1 {
    static ThreadLocal<Person> t1 = new ThreadLocal<>();
    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> weakp = new WeakReference<>(person);
        HashMap<String,String> s = new HashMap<>();
        SoftReference<Person> p = new SoftReference<>(person);
        System.gc();
        new Thread(() ->{
            s.put("name","zhangsan");
            t1.set(person);
            System.out.println(t1.get());
            System.out.println(s.get("name"));
        }).start();

        new Thread(() ->{
            System.out.println(t1.get());
            System.out.println(s.get("name"));
        }).start();
    }
    public static class Person {
        private String name;
        private String sex;

    }
}


