package string;

import java.util.Arrays;

public class AnagramChecker {


    public static boolean areAnagrams(String str1, String str2) {

        // 🚨 Null check
        if (str1 == null || str2 == null) return false;

        // ✅ Step 1: If lengths are not same, not anagrams
        if (str1.length() != str2.length()) return false;

        // ✅ Step 2: Convert strings to char arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // ✅ Step 3: Sort both arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // ✅ Step 4: Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    // 🔎 Method 2 (Interview Friendly): Check using frequency count (Better TC)
    public static boolean areAnagramsByCount(String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;

        int[] freq = new int[256]; // ASCII characters

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println("Using Sorting: Are Anagrams? " + areAnagrams(str1, str2));
        System.out.println("Using Count : Are Anagrams? " + areAnagramsByCount(str1, str2));

    }
}

/*
🧠 What is an Anagram?
   - Two strings are anagrams if they have the same characters with the same frequency, in any order.

🔍 Method 1 (Sorting):
   - Convert strings to character arrays.
   - Sort both arrays.
   - Compare them.
   ✅ TC: O(n log n) (due to sorting)
   ✅ SC: O(n) (char array creation)

🔍 Method 2 (Character Frequency):
   - Use an integer array of size 256 (ASCII) or 26 (for lowercase only).
   - Traverse both strings, increment for str1, decrement for str2.
   - If all values are zero → anagram.
   ✅ TC: O(n)
   ✅ SC: O(1) (constant space for ASCII)

🔥 Tip:
   - Frequency method is faster for interviews & large inputs.
*/
