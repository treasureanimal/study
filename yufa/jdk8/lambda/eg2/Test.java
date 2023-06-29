package jdk8.lambda.eg2;

public class Test {

    public static void main(String[] args) {
        String dfafafa = toUpperString(str -> str.toUpperCase(), "dfafafa");
        System.out.println("dfafafa = " + dfafafa);
    }

    public static String toUpperString(MyFunc<String> mf, String str){
        return mf.getValue(str);
    }
}
