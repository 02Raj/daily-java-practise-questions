package hashmap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= start) {
                start = charMap.get(currentChar) + 1;
            }
            charMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + longestSubstringWithoutRepeatingCharacters(s)); // Output: 3
    }
}



