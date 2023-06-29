package sheji.singleton.lanhan;

public class SingleObject {
    private static SingleObject singleObject;

    public SingleObject() {
    }

    public static synchronized SingleObject getInstance(){
        if (singleObject ==null) {
            singleObject = new SingleObject();
        }
        return singleObject;
    }
}
