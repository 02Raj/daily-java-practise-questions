package hashmap;

import java.util.HashMap;

public class FirstRepeatedCharFinder {

    public static char firstRepeatedChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Frequency count
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Original order mein first repeated character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (map.get(ch) > 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        String str = "programming";

        char result = firstRepeatedChar(str);

        if (result != '\0') {
            System.out.println("First repeated character: " + result);
        } else {
            System.out.println("No repeated character");
        }
    }
}