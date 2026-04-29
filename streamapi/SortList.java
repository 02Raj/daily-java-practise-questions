package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,2,9,3,8,1,7);
        List<Integer> sortNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortNumbers);
    }
}
