package collectionFramework.arrayListExample;

import java.util.ArrayList;

public class ArrayListExampleObject {
    public static void main(String[] args) {

        ArrayList<Object> items = new ArrayList<>();


        items.add("Rudra");
        items.add(25);
        items.add(5.5);
        items.add(new Person("John", 30));


        System.out.println("Items in the list:");
        for (Object item : items) {
            System.out.println(item);
        }


        Person p = (Person) items.get(4);
        System.out.println("Person's name: " + p.getName());
        System.out.println("Person's age: " + p.getAge());


        items.clear();
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
