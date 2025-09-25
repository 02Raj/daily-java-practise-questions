package javainterview.java8.functionalinterfaces;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        // ✅ Supplier<T> ek Functional Interface hai jo koi input nahi leta
        // lekin ek value return karta hai (T).
        // Iske paas ek method hota hai: T get()
        // Use case: Random value generate karna, object creation, lazily data fetch karna

        Supplier<Double> randomValue = () -> Math.random();  // Har call pe ek naya random number return karega

        System.out.println(randomValue.get());
        System.out.println(randomValue.get());
    }
}