package streamapi;

import java.util.Arrays;
import java.util.List;

public class FindMaximumNumber {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 25, 7, 40, 18, 32);

        Integer maximum = numbers.stream().max(Integer::compareTo).get();


    }
}
