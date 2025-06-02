package neetcode.slidingwindow;

/**
 * 🔐 Problem: Longest Substring Without Repeating Characters
 * 📎 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 📌 Approach:
 * - Sliding Window technique use kiya gaya hai
 * - Do pointer (`left` aur `right`) banaye jinke beech ek window maintain karenge
 * - HashSet use karke window ke andar unique characters store karenge
 * - Agar koi character repeat ho raha hai, toh `left` pointer aage badha kar
 *   us duplicate character ko hata denge
 * - Har valid window pe `maxLength` update karenge
 *
 * ⏱️ Time Complexity: O(n) — har character sirf ek baar process hota hai
 * 💾 Space Complexity: O(k) — jahan k = unique characters in string (usually 128 for ASCII)
 */

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

        String input = "abcabcbb";


        int result = lengthOfLongestSubstring(input);


        System.out.println("Length of Longest Substring without Repeating Characters: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>(); // Unique characters ka window
        int left = 0, right = 0; // Window ke do pointer
        int maxLength = 0; // Result store karne ke liye

        // Jab tak right pointer string ke end tak nahi pahuchta
        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // Agar character duplicate hai, toh left pointer aage badhao aur purane chars hatao
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Current character ko window mein daalo
            window.add(currentChar);

            // Maximum length update karo
            maxLength = Math.max(maxLength, right - left + 1);

            // Right pointer aage badhao
            right++;
        }

        return maxLength;
    }
}
