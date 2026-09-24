package streamapi;

import java.util.Arrays;
import java.util.List;

public class DoubleValueConverter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
        List<Integer> doubleNumbers = numbers.stream().map(n -> n * 2).toList();
        System.out.println("Double Numbers: " + doubleNumbers);
    }
}
