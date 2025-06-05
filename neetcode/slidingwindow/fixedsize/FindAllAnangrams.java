package neetcode.slidingwindow.fixedsize;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🔗 LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * ❓ Question: Text mein pattern ke saare anagram ke starting index return karne hain.
 *
 * 🧠 Approach:
 * - Sliding Window (Fixed Size) technique ka use kiya hai.
 * - Pattern ke characters ka frequency count array banaya (size 26 for a-z).
 * - Text pe window slide kiya, har step pe frequency ko update kiya.
 * - Agar frequency array ka har element 0 ho gaya, toh current window ek anagram hai.
 *
 * 🔁 Related to:
 * - `AnagramOccurrencesCounter.java` → usmein sirf count return hota tha.
 * - Is version mein hum starting **indices** return kar rahe hain.
 *
 * ⏱️ Time Complexity: O(n)
 * 🗃️ Space Complexity: O(1)
 */

public class FindAllAnangrams {

    public List<Integer> findAnagrams(String text, String pattern){
        int k = pattern.length();  // Pattern ki length = window size
        int[] count = new int[26];  // 26 lowercase letters ke liye frequency array

        // Pattern ke har character ka count update karo
        for (char ch : pattern.toCharArray()) {
            count[ch - 'a']++;
        }

        int left = 0, right = 0;
        int n = text.length();
        List<Integer> result = new ArrayList<>();  // Result list for starting indices

        // Text pe sliding window chalao
        while (right < n) {
            // Right pointer wala character window mein include karo
            count[text.charAt(right) - 'a']--;

            // Jab tak window size pattern se chhoti hai, right badhao
            if (right - left + 1 < k) {
                right++;
            }
            // Jab window size pattern ke barabar ho jaye, tab check karo
            else if (right - left + 1 == k) {
                // Agar count array ke sab elements 0 hain, toh yeh anagram hai
                if (allZero(count)) {
                    result.add(left);  // Valid anagram, left index add karo
                }

                // Left character ko wapas frequency mein add karo
                count[text.charAt(left) - 'a']++;

                // Window ko aage slide karo
                left++;
                right++;
            }
        }

        return result;
    }

    // Helper: check karo ki sabhi count zero hain ya nahi
    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnangrams finder = new FindAllAnangrams();
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = finder.findAnagrams(s, p);

        System.out.println("Anagram starting indices of '" + p + "' in '" + s + "' are: " + result);
    }
}
