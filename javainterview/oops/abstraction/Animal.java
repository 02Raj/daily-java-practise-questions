package javainterview.oops.abstraction;

// ---------------------------------------------
// Abstraction using Interface
// ---------------------------------------------
interface Animal {

    // abstract method by default
    void sound();

    // from Java 8 - default method
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}
