package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Charlie", "James");
        String upperCaseNames = String.valueOf(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println(upperCaseNames);
    }
}
/*
map() is used to transform each element in the stream.

String::toUpperCase converts every name to uppercase.

collect(Collectors.toList()) gathers the transformed elements
into a new List.

This demonstrates how Stream API simplifies data transformation.
*/