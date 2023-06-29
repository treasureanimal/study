package sheji.factory.chouxiang;

public class PersonFactory {

    public Person create(String name, String sex){
        Person person = new Person();
        person.setName(name);
        person.setSex(sex);
        return person;
    }
}
