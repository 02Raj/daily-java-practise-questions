package javainterview.java8.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
    }
}
