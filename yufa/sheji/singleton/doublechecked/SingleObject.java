package sheji.singleton.doublechecked;

public class SingleObject {

    private volatile static SingleObject singleObject;

    public SingleObject() {
    }

    public static SingleObject getInstance(){
        if(singleObject == null){
            synchronized (SingleObject.class){
                if (singleObject ==null) {
                    singleObject = new SingleObject();
                }
            }
        }
        return singleObject;
    }
}
