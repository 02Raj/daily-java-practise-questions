package string;

import java.util.*;
import java.util.stream.Collectors;

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

    public static class RemoveDuplicateNumbers {

        public static void main(String[] args) {

            List<Integer> numbers = Arrays.asList(
                    10, 20, 10, 30, 20, 40, 30, 50
            );

            List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
            System.out.println("Unique Numbers: " + uniqueNumbers);

        }

        public static class CharacterFrequency {

            public static void main(String[] args) {

                String str = "banana";

                Map<Character, Long> freq = str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c-> c, Collectors.counting()));
                System.out.println("freq: "+ freq);

                List<Character> duplicateCharacters =   freq.entrySet().stream().filter(e -> e.getValue() > 1).map(entry -> entry.getKey()).toList();
                System.out.println("duplicateCharacters: "+ duplicateCharacters);
            }

        }
    }
}