package oops.classbasics;

public class Person {
    String name;
    int age;

  Person(String name, int age){
      this.name = name;
      this.age = age;
  }

  void displayPersonInfo(){
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
  }

  void greet(){
      System.out.println("Hello, my name is max");
  }
}
