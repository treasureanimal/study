package jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter(x -> x>6).forEach(System.out::println);

        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        System.out.println("first = " + first.get());

    }
}
