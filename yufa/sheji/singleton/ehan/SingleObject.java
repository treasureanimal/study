package sheji.singleton.ehan;

public class SingleObject {
    private static SingleObject singleObject = new SingleObject();

    public SingleObject() {
    }

    public static SingleObject getInstance(){
        return singleObject;
    }
}
