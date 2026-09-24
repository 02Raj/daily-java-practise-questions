package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,2,9,3,8,1,7);
        List<Integer> sortNumbers = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println(sortNumbers);


        List<Integer> numbers2 = Arrays.asList(
                50, 10, 40, 20, 30
        );
        List<Integer> sortNumbers2 = numbers2.stream().sorted().toList();
        System.out.println(sortNumbers2);

    }
}
