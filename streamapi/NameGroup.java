package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameGroup {


    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Rahul", "Rohit", "Amit"
        );

        Map<String,  List<String>> result  =   names.stream().collect(Collectors.groupingBy(n->n));
        System.out.println("Grouped Names: " + result);

        Map<String, Long> count  =   names.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println("Grouped Names: " + count);
    }

}
