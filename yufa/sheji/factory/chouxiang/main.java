package sheji.factory.chouxiang;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Persons persons = new Persons();
        List<Person> personList = new ArrayList<>();
        personList.add(personFactory.create("张三", "nan"));
        personList.add(personFactory.create("张四","nan"));
        persons.setPersonList(personList);

        personList.forEach(person -> {
            System.out.println("person.getName() = " + person.getName());
            System.out.println("person.getSex() = " + person.getSex());
        });
        System.out.println("persons = " + persons.getPersonList());
    }
}
