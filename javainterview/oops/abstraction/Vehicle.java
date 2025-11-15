package javainterview.oops.abstraction;

// ---------------------------------------------
// Abstraction using Abstract Class
// ---------------------------------------------

// Abstract class = partial abstraction
// It can have abstract + normal methods
abstract class Vehicle {

    // abstract method (no body)
    abstract void start();

    // normal method
    void stop() {
        System.out.println("Vehicle stopped");
    }
}

