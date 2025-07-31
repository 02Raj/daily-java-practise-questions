package string.substringpatternmatching;

import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromeBuilder {

    // 🔵 Approach 1: Using HashSet
    // -----------------------------------------
    // 🧠 Logic:
    // We use a HashSet to track characters.
    // - If a character repeats, we remove it from the set and add 2 to result.
    // - Characters that don’t repeat will remain in the set.
    // - At the end, if set is not empty, we can take 1 odd character in center.
    public static int approach1(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);  // Pair found
                result += 2;
            } else {
                set.add(ch);     // Waiting for pair
            }
        }

        // If any one odd character left, we can place it in the center
        if (!set.isEmpty()) {
            result++;
        }

        return result;
    }

    // 🔹 Approach 2: Using HashMap to Count Frequency
    // 🧠 Logic:
    // Step 1: Har character ka frequency count nikaalte hain
    // Step 2: Jitne bhi even frequency hain, unko fully use kar lete hain
    // Step 3: Odd frequency wale characters me se (freq - 1) characters use karte hain (pair ke liye)
    // Step 4: Agar koi odd frequency mila, to ek character center me use kar sakte hain (only once)

    public static int approach2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean centralCharUsed = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                result += freq;
            } else {
                result += freq - 1;
                centralCharUsed = true;
            }
        }

        if (centralCharUsed) {
            result++;
        }

        return result;
    }

    // 🔵 Approach 3: One Pass Frequency Tracker
    // -----------------------------------------
    // 🧠 Logic:
    // Count frequency while iterating.
    // Keep track of number of odd frequencies.
    // - If even, add to palindrome length.
    // - At the end, if oddFreq > 0, we can keep 1 central odd char.
    public static int approach3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int oddFreq = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) % 2 == 0) {
                oddFreq--;  // even frequency, remove from odd count
            } else {
                oddFreq++;  // odd frequency, add to odd count
            }
        }

        // Total palindrome = all even + 1 (if center odd allowed)
        if (oddFreq > 0) {
            return s.length() - oddFreq + 1;
        }

        return s.length();  // all characters can be paired
    }

    // 🔹 MAIN METHOD to test all 3 approaches
    public static void main(String[] args) {
        String input = "abccccdd";

        System.out.println("🔷 Input: " + input);
        System.out.println("✅ Approach 1 (Using HashSet): " + approach1(input));
        System.out.println("✅ Approach 2 (Using HashMap Count): " + approach2(input));
        System.out.println("✅ Approach 3 (One-pass Frequency): " + approach3(input));
    }
}
