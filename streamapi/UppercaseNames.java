package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Charlie", "James");
        String upperCaseNames = String.valueOf(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println(upperCaseNames);

        List<String> names2 = Arrays.asList(
                "Rahul", "Amit", "Rohit", "Ankit", "Ravi", "Suresh"
        );

        List<String> upperCaseNames2 = names2.stream()
                .filter(name -> name.startsWith("R"))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase names starting with R: " + upperCaseNames2);
    }
}
/*
map() is used to transform each element in the stream.

String::toUpperCase converts every name to uppercase.

collect(Collectors.toList()) gathers the transformed elements
into a new List.

This demonstrates how Stream API simplifies data transformation.
*/