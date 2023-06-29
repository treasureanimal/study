package sheji.guanchazhe.eg2;


public interface Subject1 {
    //添加订阅关系
    void attach(Observer1 observer);
    //移除订阅关系
    void detach(Observer1 observer);
    //通知订阅者
    void notifyObserver(String message);
}
