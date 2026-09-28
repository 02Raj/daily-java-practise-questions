package string;

import java.util.HashSet;
import java.util.Set;

public class DuplicateStringFinder {

    public static Set<String> findDuplicateStrings(String[] names) {

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (int i = 0; i < names.length; i++) {

            if (seen.contains(names[i])) {
                duplicates.add(names[i]);
            } else {
                seen.add(names[i]);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {

        String[] names = {
                "Rahul", "Amit", "Rahul", "Rohit",
                "Amit", "Rahul", "Suresh"
        };

        Set<String> result = findDuplicateStrings(names);

        System.out.println("Duplicate Strings: " + result);
    }
}