package jdk8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class map {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<Integer, String>();

        strMap = strList.stream()
                .collect( Collectors.toMap(str -> strList.indexOf(str), str -> str ) );

        strMap.forEach((key, value) -> {
            System.out.println(key+":"+value);
        });

        HashMap<String, String> hashMap = new HashMap<String, String>() {{
            put("name", "zhangsan");
        }};
        hashMap.forEach((key, value) -> {
            System.out.println(key+":"+value);
        });

//        List<Pair<String,Double>> pairArrayList = new ArrayList<>(3);
//        pairArrayList.add(new Pair<>("version", 12.10));
//        pairArrayList.add(new Pair<>("version", 12.19));
//        pairArrayList.add(new Pair<>("version", 6.28));
//        Map<String, Double> collect = pairArrayList.stream().collect(
//                // 生成的 map 集合中只有一个键值对：{version=6.28}
//                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
//        collect.forEach((key, value) -> {
//            System.out.println(key+":"+value);
//        });


        IntStream.range(1,5).forEach(System.out::println);

    }
}
