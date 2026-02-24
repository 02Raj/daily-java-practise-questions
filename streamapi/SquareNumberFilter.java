package streamapi;

import java.util.Arrays;
import java.util.List;

public class SquareNumberFilter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,3,4,5);
        List<Integer> result = numbers.stream().map(n-> n * n).toList();
        System.out.println("result:" + result );
    }
}
