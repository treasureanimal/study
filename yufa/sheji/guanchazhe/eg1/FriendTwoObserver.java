package sheji.guanchazhe.eg1;

public class FriendTwoObserver implements Observer{
    @Override
    public void update(String message) {
        // 模拟处理业务逻辑
        System.out.println("FriendTwo 知道了你发动态了" + message);
    }
}
