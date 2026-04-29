package streamapi;

import java.util.Arrays;
import java.util.List;

public class SumOfElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,30,40,50);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("result: " + sum);


    }

}

/*
mapToInt(Integer::intValue) is used to convert Stream<Integer>
into an IntStream.

sum() is a terminal operation that adds all elements
of the IntStream and returns the total.

Stream API provides a concise and readable way
to perform aggregate operations like sum.
*/
