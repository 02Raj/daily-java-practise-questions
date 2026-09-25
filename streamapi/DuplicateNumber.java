package streamapi;

import java.util.Arrays;
import java.util.List;

public class DuplicateNumber {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 10, 50
        );



//        List<Integer> duplciateNumbers = numbers.stream()
//                .filter(n-> numbers.stream().filter(x -> x.equals(n)).count() > 1)
//                .distinct()
//                .toList();
//        System.out.println("Duplicate Numbers: " + duplciateNumbers);


    }
}
