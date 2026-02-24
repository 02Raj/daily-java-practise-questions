package streamapi;

import java.util.Arrays;
import java.util.List;

public class CapitalizeFirstLetter {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("java", "spring", "boot");

        List<String> result = strings.stream()
                .map(CapitalizeFirstLetter::capitalize)
                .toList();

        System.out.println("First Letter Capital: " + result);
    }

    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
