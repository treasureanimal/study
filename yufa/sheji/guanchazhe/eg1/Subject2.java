package sheji.guanchazhe.eg1;


public interface Subject2 {
    //添加订阅关系
    void attach(Observer observer);
    //移除订阅关系
    void detach(Observer observer);
    //通知订阅者
    void notifyObserver(String message);
}
