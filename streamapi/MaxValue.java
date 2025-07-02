package streamapi;

import java.util.Arrays;
import java.util.List;

public class MaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,25,5,12,5);
        int max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new RuntimeException("List is empty"));
        System.out.println("Maximum value: " + max);
    }
}


/*Approach: We used Java 8 Stream API to find the maximum value from a list of integers.
m() converts the list to a stream.

mapToInt(Integer::intValue) converts wrapper objects to primitive int for performance.

max() gives the highest value in the stream.

orElseThrow() ensures safety if the list is empty.

✅ This is a clean, functional, and null-safe way to find the max using modern Java.

strea
*/