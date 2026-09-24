package streamapi;

import java.util.Arrays;
import java.util.List;

public class FilterEvenAndDouble {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40);
        List<Integer> evenNumber = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).toList();
//        List<Integer> doubleEvenNumbers = evenNumber.stream().map(n -> n * 2).toList();
//        System.out.println("Even Numbers: " + evenNumber);
//        System.out.println("Double Even Numbers: " + doubleEvenNumbers);
        System.out.println("Double Even Numbers: " + evenNumber);
    }
}
