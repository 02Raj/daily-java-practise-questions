package javainterview.java8.functionalinterfaces;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        // ✅ Function<T, R> ek Functional Interface hai jo ek input leta hai (T)
        // aur ek output return karta hai (R).
        // Iske paas ek method hota hai: R apply(T t)
        // Use case: Transformation (String -> Integer, Object -> Value)

        Function<String, Integer> strLength = str -> str.length(); // String ko uski length mein convert karega

        System.out.println(strLength.apply("Divyansh")); // 8
        System.out.println(strLength.apply("Java")); // 4
    }
}
