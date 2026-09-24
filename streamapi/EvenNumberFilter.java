package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberFilter {

    public static void main(String[] args) {
        List<Integer>  numbers = Arrays.asList(10, 13, 15, 8, 6, 3, 2, 9);
//        List<Integer> evenNumbers  = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println("Even Numbers:" + evenNumbers );

        List<Integer> numberEven = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Even Numbers:" + numberEven );


        // count for eveneNumbers
        long countEvenNumbers = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Count of Even Numbers: " + countEvenNumbers);
    }
}

/*Used filter() to apply a condition (n % 2 == 0).

collect(Collectors.toList()) is used to store filtered values in a new list.

Stream API promotes clean, functional-style code.


Why filter() and not map()?
"filter() is used when I want to select/remove elements based on a condition, whereas map() is used to transform each element."
*/