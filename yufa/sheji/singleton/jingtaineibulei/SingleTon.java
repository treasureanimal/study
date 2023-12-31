package sheji.singleton.jingtaineibulei;

public class SingleTon {

    /* 私有构造方法，防止被实例化 */
    private SingleTon() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static SingleTon instance = new SingleTon();
    }

    /* 获取实例 */
    public static SingleTon getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
