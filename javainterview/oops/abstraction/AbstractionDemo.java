package javainterview.oops.abstraction;



public class AbstractionDemo {

    public static void main(String[] args) {

        // Abstract class cannot be instantiated:
        // Vehicle v = new Vehicle();  ❌ NOT ALLOWED

        Vehicle car = new Car();
        car.start();   // abstraction in action
        car.stop();

        Vehicle bike = new Bike();
        bike.start();
        bike.stop();

        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
