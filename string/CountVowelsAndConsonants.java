package string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountVowelsAndConsonants {

    /**
     * ============================================
     *            PROBLEM STATEMENT
     * ============================================
     * Given a string, count the number of
     * vowels and consonants present in it.
     *
     * Ignore spaces, digits, and special characters.
     *
     * --------------------------------------------
     * INPUT:
     *   "Hello World"
     *
     * OUTPUT:
     *   Vowels = 3
     *   Consonants = 7
     *
     * --------------------------------------------
     * EXPLANATION:
     *   Vowels:
     *      e, o, o
     *
     *   Consonants:
     *      H, l, l, W, r, l, d
     *
     * --------------------------------------------
     * APPROACH:
     * 1. Initialize vowel and consonant counters.
     * 2. Convert the string to lowercase.
     * 3. Traverse each character.
     * 4. If it is an alphabet:
     *      - Check if it is a vowel.
     *      - Otherwise count it as a consonant.
     * 5. Print the final counts.
     *
     * --------------------------------------------
     * TIME COMPLEXITY: O(n)
     *   n = length of the string
     *
     * SPACE COMPLEXITY: O(1)
     *
     * ============================================
     */

    public void countVowelsAndConsonants(String str) {

        int vowels = 0;
        int consonants = 0;

        // Convert string to lowercase
        str = str.toLowerCase();

        // Traverse each character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check if character is an alphabet
            if (ch >= 'a' && ch <= 'z') {

                // Check for vowels
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {

        CountVowelsAndConsonants obj = new CountVowelsAndConsonants();

        String input = "Divyansh Raj";

        obj.countVowelsAndConsonants(input);
    }

    public static class SortList {

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

        public static class FirstNonRepeatingCharacter {

            public static void main(String[] args) {

                String str = "swiss";

                Map<Character, Long> count = str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        ));

                Character firstNonRepeating = count.entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .map(e -> e.getKey())
                        .findFirst()
                        .orElse(null);

                System.out.println(firstNonRepeating);
            }
        }
    }
}