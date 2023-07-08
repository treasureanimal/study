package thread.jiaotidayin;

/**
 * 交替打印50个AB
 * @author zhangxiaoxiong
 */
public class PrintAB {
    public static void main(String[] args) {
        PrintObject printObject = new PrintObject(1, 50);
        new Thread(() -> printObject.print("A", 1, 2)).start();
        new Thread(() -> printObject.print("B", 2, 1)).start();
    }

}
class PrintObject{
    private int flag;
    private final int loopNum;

    public PrintObject(int flag, int loopNum) {
        this.flag = flag;
        this.loopNum = loopNum;
    }

    public void print(String str, int currFlag, int nextFlag) {
        for (int i = 0; i < loopNum; i++) {
            synchronized (this){
                while(flag != currFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
