package streamapi;

import java.util.Arrays;
import java.util.List;

public class FindMaximumNumber {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 25, 7, 40, 18, 32);

//        Integer maximum = numbers.stream().max(Integer::compareTo).get();

        Integer maximum = numbers.stream().max((a,b) -> a.compareTo(b)).get();
        System.out.println("Maximum Number: " + maximum);


        ///  check nay number greater then 40 or not
        boolean isGreaterThen40OrNot = numbers.stream().anyMatch(n -> n > 40);
        System.out.println("Is any number greater than 40: " + isGreaterThen40OrNot);

        // check negative numbers exist or not
        boolean isNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Is any negative number exist: " + isNegative);

        // find maximum number using reduce and stream
         Integer maxNumber = numbers.stream().reduce(0, (a,b) -> Math.max(a,b));
         System.out.println("Maximum Number (using reduce): " + maxNumber);
    }
}
