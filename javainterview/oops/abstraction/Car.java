package javainterview.oops.abstraction;

// Concrete class (child)
class Car extends Vehicle {

    // implementing abstract method
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}
