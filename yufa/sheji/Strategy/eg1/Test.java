package sheji.Strategy.eg1;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperation(new OperationAdd());
        int result = calculator.doOperation(1,2);
        System.out.println("result = " + result);
    }
}
