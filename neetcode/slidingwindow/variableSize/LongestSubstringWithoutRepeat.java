package neetcode.slidingwindow.variableSize;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        // Unique characters ko track karne ke liye HashSet
        HashSet<Character> set = new HashSet<>();

        int left = 0, right = 0; // Sliding window pointers
        int maxLength = 0;

        while (right < s.length()) {
            // Agar character repeat nahi hua hai
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));                 // Add to current window
                maxLength = Math.max(maxLength, right - left + 1); // Max update
                right++;                                  // Window expand karo
            } else {
                // Duplicate mila — left se characters hatao jab tak duplicate na hat jaye
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

