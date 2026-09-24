package streamapi;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int sum = numbers.stream().reduce(0, (a,b) -> a + b);
        System.out.println("Sum of Numbers: " + sum);
    }
}
