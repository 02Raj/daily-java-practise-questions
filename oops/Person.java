package oops;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person pr = new Person("Mohit", 26);
        System.out.println("pr  "  + pr.name);

    }
}
