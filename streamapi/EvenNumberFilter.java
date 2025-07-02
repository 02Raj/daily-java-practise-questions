package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberFilter {

    public static void main(String[] args) {
        List<Integer>  numbers = Arrays.asList(10, 13, 15, 8, 6, 3, 2, 9);
        List<Integer> evenNumbers  = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers:" + evenNumbers );
    }
}

/*Used filter() to apply a condition (n % 2 == 0).

collect(Collectors.toList()) is used to store filtered values in a new list.

Stream API promotes clean, functional-style code.

*/