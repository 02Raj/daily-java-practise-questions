package oops.Inheritance.singleInheritance;

public class Animal {

    void eat(){
        System.out.println("Animal is eating");
    }

}

class Dog extends Animal {
    void bark(){
        System.out.println("Dog is barking");
    }
    @Override
    void eat(){
        super.eat();
        System.out.println();
    }
}
 class TestInheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}