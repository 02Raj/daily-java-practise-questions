package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEvenOdd {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 25, 30, 35, 40
        );

        /*
         * ============================================================
         * APPROACH 1: filter() use karke Even aur Odd alag karna
         * ============================================================
         *
         * Yahan hum stream ko 2 baar chala rahe hain:
         *
         * 1. Pehli baar -> Even numbers
         * 2. Dusri baar -> Odd numbers
         *
         * filter() sirf un elements ko rakhta hai
         * jo given condition ko satisfy karte hain.
         */

        List<Integer> evenList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        List<Integer> oddList = numbers.stream()
                .filter(n -> n % 2 == 1)
                .toList();

        System.out.println("Even list: " + evenList);
        System.out.println("Odd list: " + oddList);


        /*
         * ============================================================
         * APPROACH 2: partitioningBy()
         * ============================================================
         *
         * partitioningBy() ka use tab karte hain jab humein
         * collection ko EK BOOLEAN CONDITION ke basis par
         * exactly 2 groups mein divide karna ho.
         *
         * Example:
         *
         *     n -> n % 2 == 0
         *
         * Ye condition boolean return karegi:
         *
         *     true  -> number EVEN hai
         *     false -> number ODD hai
         *
         * Isliye partitioningBy() humein:
         *
         *     true  -> Even numbers
         *     false -> Odd numbers
         *
         * ke form mein Map<Boolean, List<Integer>> deta hai.
         */

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("result: " + result);

        Map<Boolean, Long> count = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0,Collectors.counting()));

        System.out.println("count: " + count);

        /*
         * Result:
         *
         * {
         *     false=[15, 25, 35],
         *     true=[10, 20, 30, 40]
         * }
         *
         * Yahan:
         *
         * result.get(true)
         *     -> [10, 20, 30, 40]  // Even
         *
         * result.get(false)
         *     -> [15, 25, 35]      // Odd
         */


        List<Integer> even = result.get(true);
        List<Integer> odd = result.get(false);

        int evenCount = even.size();
        int oddCount = odd.size();
        System.out.println("even count: " + evenCount);
        System.out.println("odd count: " + oddCount);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}