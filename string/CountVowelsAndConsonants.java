package string;

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
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
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
}