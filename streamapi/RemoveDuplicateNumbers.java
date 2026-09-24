package streamapi;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30, 50
        );

        List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
        System.out.println("Unique Numbers: " + uniqueNumbers);

    }

}
