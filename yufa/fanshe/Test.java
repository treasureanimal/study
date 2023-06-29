package com.study.fanshe;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Student student = new Student();
        student.setAge(18);
        student.setName("zhangsan");
        student.setSex("男");
        Field field = student.getClass().getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field);
        Object object = field.get(student);
        System.out.println(object);
    }



}


class Student{

    private String name;

    private Integer age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
