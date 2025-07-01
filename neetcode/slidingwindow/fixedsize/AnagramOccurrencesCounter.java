package neetcode.slidingwindow.fixedsize;

import java.util.Arrays;

/*
🔍 Problem Statement:
Hume ek `text` string aur ek `pattern` string di gayi hai.
Task hai ye find karna ki `text` mein `pattern` ke kitne anagram (shuffled versions) maujood hain.

💡 Example:
Text:    "cbaebabacd"
Pattern: "abc"
"abc" ke anagrams ho sakte hain: [abc, acb, bac, bca, cab, cba]
Toh output hoga: 2 (cba at index 0 and bac at index 6)

🧠 Approach:
- Sliding Window lagayenge jiska size = pattern ki length hoga.
- Pattern ke characters ka frequency array banayenge.
- Jab window slide karega, right char ko window mein include karenge → count kam karenge.
- Jab window ka size pattern ke barabar hoga, check karenge ki kya count array mein sab 0 hain.
- Agar haan → valid anagram mila.
- Phir left se window ko slide karenge → left char ka count wapas increase karenge.
*/

public class AnagramOccurrencesCounter {

    // ✅ Function to count total anagram occurrences in text
    public int countAnagramOccurrences(String text, String pattern) {
        int k = pattern.length();             // ✅ Window size = pattern ka length
        int[] count = new int[26];            // ✅ 26 characters (a-z) ka frequency array banaya

        Arrays.fill(count, 0);                // 🔄 Pura array 0 se initialize kiya (default)

        // 🏗️ Pattern ke har character ka count array mein frequency badhaya
        for (char ch : pattern.toCharArray()) {
            count[ch - 'a']++;                // ➕ Example: 'a' - 'a' = 0 index, 'c' - 'a' = 2
        }

        int left = 0, right = 0;              // 🧭 Sliding window ke pointers
        int result = 0;                       // 🎯 Final result (kitne anagrams mile)
        int n = text.length();                // 📏 Text ki total length

        // 🧭 Window ko text pe slide karo
        while (right < n) {

            // 🔽 Window mein right char include kiya aur uska count kam kiya
            // ❓ Kyun? Kyunki wo char ab window ke andar aa gaya hai
            count[text.charAt(right) - 'a']--;

            // 🚪 Jab tak window chhoti hai pattern se, sirf right badhao
            if (right - left + 1 < k) {
                right++; // ➡️ Right pointer aage badhaya (window expand)
            }

            // ✅ Jab window ka size pattern ke barabar ho gaya
            else if (right - left + 1 == k) {

                // 🔍 Check karo kya count array ka har value 0 hai
                if (allZero(count)) {
                    result++;  // 🎯 Valid anagram mila, result increment karo
                }

                // ♻️ Window slide karne se pehle left char ka count wapas badhao
                // ❓ Kyun? Kyunki wo ab window se bahar jaa raha hai
                count[text.charAt(left) - 'a']++;

                // 🪟 Window ko slide karo → left aur right dono badhao
                left++;   // ⬅️ Left pointer ko aage le jao
                right++;  // ➡️ Right pointer bhi aage le jao
            }
        }

        return result;  // 🔁 Total valid anagram count return karo
    }

    // ✅ Helper method: check karo kya count array ka har value 0 hai
    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) return false;  // ❌ Agar koi bhi element non-zero mila → not an anagram
        }
        return true;  // ✅ Sab 0 hain → perfect match mila
    }

    // 🚀 Main method to test the function
    public static void main(String[] args) {
        AnagramOccurrencesCounter counter = new AnagramOccurrencesCounter();

        String text = "cbaebabacd";     // 📝 Text jisme anagrams dhoondhna hai
        String pattern = "abc";         // 🎯 Pattern jiska anagram check karna hai

        int result = counter.countAnagramOccurrences(text, pattern);  // 🧪 Function call

        System.out.println("Number of anagram occurrences of '" + pattern + "' in '" + text + "' is: " + result);
        // 📢 Final output print karo
    }
}
