package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstCharUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Charlie", "James");
        List<String> result = names.stream().map(name-> name.substring(0,1).toUpperCase() + name.substring(1)).collect(Collectors.toList());
        System.out.println(result);
    }
}
/*
map() is used to transform each string.

substring(0,1).toUpperCase() converts only the first character
to uppercase.

substring(1) appends the remaining part of the string unchanged.

This approach capitalizes only the first letter of each word.
*/