package jdk8.stream;


import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>() {{
            add(new Person("Tom", 8900, 18, "male", "New York"));
            add(new Person("Jack", 7000, 25, "male", "Bei Jing"));
            add(new Person("Lily", 7800, 24, "female", "Chong Qing"));
            add(new Person("Anni", 9500, 28, "female", "Shang Hai"));
            add(new Person("Owen", 8200, 22, "male", "Xi An"));
            add(new Person("Alisa", 7900, 30, "female", "Shen Zhen"));
        }};
        personList.forEach(person ->
                System.out.println("person = " + JSONObject.toJSON(person))
        );
        //将员工的薪资全部增加1000
        List<Person> collect1 = personList.stream().map(person -> {
            Person person1 = new Person(person.getName(), 0, 0, person.getSex(), person.getArea());
            person1.setSalary(person.getSalary() + 10000);
            return person1;
        }).toList();
        System.out.println("将员工的薪资全部增加1000 1= " + collect1.get(0).getName() + "->" + collect1.get(0).getSalary());
        List<Person> collect2 = personList.stream().peek(person -> person.setSalary(person.getSalary() + 10000)).collect(Collectors.toList());
        System.out.println("将员工的薪资全部增加1000 2= " + collect2.get(0).getName() + "->" + collect2.get(0).getSalary());


        //筛选员工中工资高于8000的人，并形成新的集合
        List<String> collect = personList.stream().filter(person -> person.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        //获取员工工资最高的人
        Optional<Integer> max2 = personList.stream().map(Person::getSalary).sorted().max((x, y) -> x - y);
        System.out.println("薪资最高的员工方式1 = " + max2.get());
        Optional<Person> max3 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("薪资最高的员工方式2 " + max3.get());
        /**
         * 获取最长字符串
         */
        List<String> list = Arrays.asList("admin", "sdfa", "hhgfds", "a", "abcdegsdfafdf");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("max = " + max);

        /**
         * 获取Integer集合中的最大值。
         */
        List<Integer> list1 = Arrays.asList(6, 5, 7, 8, 9, 32);
        IntSummaryStatistics intSummaryStatistics = list1.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("sum = " + intSummaryStatistics.getMax());

        Optional<Integer> max1 = list1.stream().sorted().min((x, y) -> x - y);
        System.out.println("max1.get() = " + max1.get());
        list1.stream().max(Integer::compareTo);
    }
}
