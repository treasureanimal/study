package jdk8.lambda.forEachTest;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("zhangsan");
        strings.add("lisi");
        strings.forEach(System.out::println);
    }
}
