package sheji.guanchazhe.eg2;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject1 implements Subject1 {

    //订阅者容器
    private List<Observer1> observers = new ArrayList<>();

    @Override
    public void attach(Observer1 observer) {
        //添加订阅者
        observers.add(observer);
    }

    @Override
    public void detach(Observer1 observer) {
        //删除订阅者
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        //同通知订阅者
        for (Observer1 observer : observers) {
            observer.update(message);
        }
    }
}
