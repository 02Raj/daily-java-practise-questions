package javainterview.java8.functionalinterfaces;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        // ✅ Consumer<T> ek Functional Interface hai jo input T accept karta hai
        // lekin kuch return nahi karta (sirf operation perform karta hai).
        // Iske paas ek method hota hai: void accept(T t)
        // Use case: Logging, printing, external operations (jaise DB update, API call, etc.)

        Consumer<String> print = msg -> System.out.println("Message: " + msg);

        print.accept("Hello Java 8!");
        print.accept("Functional Interfaces");
    }
}

