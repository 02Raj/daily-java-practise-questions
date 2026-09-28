package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateNameFinder {


    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Rahul", "Rohit",
                "Amit", "Rahul", "Suresh"
        );

        List<String> duplicateNames = names.stream().filter(name -> names.stream().filter(n -> n.equals(name)).count() > 1).distinct().toList();
        System.out.println("Duplicate Names: " + duplicateNames);
    }
}
