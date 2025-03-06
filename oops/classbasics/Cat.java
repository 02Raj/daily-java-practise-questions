package oops.classbasics;

public class Cat implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Cat meows!");
    }

    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();

        Animal myCat = new Cat();
        myCat.makeSound();



    }
}
