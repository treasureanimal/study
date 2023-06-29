package sheji.guanchazhe.eg2;

public class SendSuccessMessageObserver implements Observer1 {
    @Override
    public void update(String message) {
        // 处理业务逻辑
        System.out.println("注册成功");
    }

    public static void main(String[] args) {
        // 假设用户注册成功直接通知观察者，改干自己的事情了
        ConcreteSubject1 subject = buildSubject();
        subject.notifyObserver("");
    }

    private static ConcreteSubject1 buildSubject() {
        ConcreteSubject1 subject = new ConcreteSubject1();
        subject.attach(new SendSuccessMessageObserver());
        subject.attach(new SendNewPersonCouponObserver());
        return subject;
    }
}
