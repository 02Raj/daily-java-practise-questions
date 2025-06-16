package neetcode.slidingwindow.fixedsize;

public class MaxVowels {

    public static void main(String[] args) {
        // 🔸 LeetCode Question: 1456. Maximum Number of Vowels in a Substring of Given Length
        // Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

        // ❓ Problem Statement:
        // Given a string s and an integer k, return the maximum number of vowel letters
        // in any substring of s with length k.

        // 📥 Input Example:
        String s = "abciiidef";
        int k = 3;

        // ✅ Expected Output: 3 ("iii" has 3 vowels)

        // 📘 Approach:
        // Use Sliding Window of fixed size k
        // Count vowels in the current window
        // Slide the window to the right → update max when needed

        // 🧠 Story Point:
        // Imagine you're reading a sentence through a window of 3 letters at a time.
        // At each step, you count how many vowels are inside the window.
        // You want to find the window where the count of vowels is the highest.

        // ▶ Run and Print Result
        MaxVowels obj = new MaxVowels();
        int result = obj.maxVowels(s, k);
        System.out.println("Max vowels in any substring of length " + k + ": " + result);
    }

    // ✅ Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); // Make sure case doesn't matter
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // 🚀 Main logic using Sliding Window (Fixed Size)
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;      // Left boundary of the window
        int right = 0;     // Right boundary of the window
        int count = 0;     // Vowels in the current window
        int maxVowels = 0; // Max vowels found in any window

        // 🔁 Traverse through the string
        while (right < n) {
            // ✅ If current char is vowel, increase count
            if (isVowel(s.charAt(right))) {
                count++;
            }

            // 🪟 When window size becomes exactly k
            if (right - left + 1 == k) {
                // 📌 Update maxVowels if this window has more vowels
                maxVowels = Math.max(maxVowels, count);

                // ❎ If character going out of window is vowel, decrease count
                if (isVowel(s.charAt(left))) {
                    count--;
                }

                // ⏩ Move window forward from the left
                left++;
            }

            // ⏩ Always move window forward from the right
            right++;
        }

        // 🔚 Return the final answer
        return maxVowels;
    }
}
