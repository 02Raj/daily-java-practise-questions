package neetcode.slidingwindow.fixedsize;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AnagramOccurrencesCounter {

    // Method to count occurrences of anagrams of pattern in text
    public int countAnagramOccurrences(String text, String pattern) {
        int k = pattern.length();  // Pattern ki length, jo window size hogi

        // Frequency array for pattern characters (26 letters for 'a' to 'z')
        int[] count = new int[26];
        Arrays.fill(count, 0);  // Initially zero se fill kar diya

        // Pattern ke har character ka frequency array mein count badhao
        for (char ch : pattern.toCharArray()) {
            count[ch - 'a']++;
        }

        int left = 0, right = 0;  // Sliding window ke pointers
        int n = text.length();    // Text ki length
        int result = 0;           // Total anagram count

        // Sliding window ko text par chalao jab tak right pointer end tak na pahunch jaye
        while (right < n) {
            // Window me right pointer pe jo char hai, uska frequency array se ek kam karo
            // Kyunki hum window me ye char include kar rahe hain
            count[text.charAt(right) - 'a']--;

            // Agar window ka size abhi pattern se chhota hai to right pointer aage badhao
            if (right - left + 1 < k) {
                right++;
            }
            // Jab window size pattern ke barabar ho jaye to check karo
            else if (right - left + 1 == k) {
                // Agar count array ke sare elements zero hain to iska matlab
                // ye window pattern ka anagram hai
                if (allZero(count)) {
                    result++;  // Anagram mila, count increment karo
                }

                // Sliding window ko aage badhane se pehle left pointer pe wala character
                // frequency array me wapas add karo, kyunki wo ab window me nahi rahega
                count[text.charAt(left) - 'a']++;

                // Window ko slide karo, left aur right dono ek step aage badhao
                left++;
                right++;
            }
        }

        // Finally total anagram count return karo
        return result;
    }

    // Helper method: Check karo ki count array ke sare elements zero hain ya nahi
    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;  // Agar koi bhi element zero nahi hai to false return karo
            }
        }
        return true;  // Agar sab zero hain to true return karo
    }

    // Main method to test the solution
    public static void main(String[] args) {
        AnagramOccurrencesCounter counter = new AnagramOccurrencesCounter();

        // Text jisme hume pattern ke anagrams dhundhne hain
        String text = "cbaebabacd";

        // Pattern jiska anagram count karna hai
        String pattern = "abc";

        // Function call karke result lo
        int result = counter.countAnagramOccurrences(text, pattern);

        // Result print karo
        System.out.println("Number of anagram occurrences of '" + pattern + "' in '" + text + "' is: " + result);
    }
}
