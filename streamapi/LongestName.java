package streamapi;

import java.util.Arrays;
import java.util.List;

public class LongestName {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Rohit", "Ankit", "Ravi"
        );

        String longestName = names.stream()
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2)
                .orElse(null);
        System.out.println("Longest name: " + longestName);
    }
}
