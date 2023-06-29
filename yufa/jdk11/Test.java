package jdk11;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        var javasc = " javasstack aaa \n b \n cdadf ";
        System.out.println("javasc = " + javasc);
        System.out.println(" ".isBlank());
        System.out.println("".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println("javasc1 = " + javasc.strip());
        System.out.println("javasc2 = " + javasc.repeat(4));
        System.out.println("javasc2 = " + javasc.lines().count());

        var list = List.of("java", "c", "Python");
        var list1 = new ArrayList<String>();
        list1.add("java");
        list1.add("c");
        list1.add("Python");
        System.out.println("list1 = " + list1);
        System.out.println(List.copyOf(list1) == list1);
        System.out.println(List.copyOf(list) == list);
        System.out.println("list = " + list);
        System.out.println(list1 == list);
        Thread thread = new Thread(() -> {
            System.out.println("list1 = " + list1);
        });
        thread.start();
    }
}
