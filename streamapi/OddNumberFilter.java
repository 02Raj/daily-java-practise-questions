package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddNumberFilter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 13, 15, 8, 6, 3, 2, 9);
        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 != 0).toList();
        System.out.println("Even Numbers:" + oddNumbers );
    }
}
