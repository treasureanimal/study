package sheji.guanchazhe.eg1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject2 {

    //订阅者容器
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        //添加订阅者
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        //删除订阅者
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        //同通知订阅者
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
