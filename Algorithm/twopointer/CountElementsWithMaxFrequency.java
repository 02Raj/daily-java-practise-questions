package Algorithm.twopointer;


/*
===========================================================
🧩 Problem: Count Elements With Maximum Frequency
===========================================================
🔗 LeetCode: https://leetcode.com/problems/count-elements-with-maximum-frequency/
📅 Solved On: 20-04-2025
🔁 Revision Due: 27-04-2025
===========================================================

📝 Problem Statement:
Array of positive integers diya hai.
Un sabhi elements ki total frequency return karo
jinki frequency MAXIMUM hai.

Example:
Input:  [2,5,5,3,2,6]  →  Output: 4  (2 aur 5 dono ka freq=2)
Input:  [4,5,6,7,8]    →  Output: 5  (sab ka freq=1)

-----------------------------------------------------------
💡 Approach: HashMap (Frequency Count)

Step 1: Har element ki frequency count karo (HashMap)
Step 2: Maximum frequency dhundo
Step 3: Jinki freq == maxFreq, unka sum karo

-----------------------------------------------------------
🧠 Key Ideas:
→ Two Pointer NAHI — kyunki positions nahi, counts chahiye
→ HashMap → O(n) mein frequency count
→ 2 passes: ek max dhundne ke liye, ek sum ke liye
→ Constraints chote hain (<=100) toh int[101] array bhi kaam karta

-----------------------------------------------------------
🔁 Dry Run: [2,5,5,3,2,6]

freq map: {2→2, 5→2, 3→1, 6→1}
maxFreq = 2
count   = 2 + 2 = 4 ✅

-----------------------------------------------------------
⏱ TC: O(n)   📦 SC: O(n)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Two pointer kyun nahi chala yahan?
[ ] maxFreq pehle kyun nikalna zaroori hai?
[ ] Dry run: [1,1,2,2,3] → expected 4
[ ] Dry run: [1] → expected 1

===========================================================
*/

public class CountElementsWithMaxFrequency {

    public int maxFrequencyElements(int[] nums) {

        // Step 1: Frequency map banao
        int[] freq = new int[101]; // values 1-100 hain
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Maximum frequency dhundo
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Step 3: Jinki frequency == maxFreq unka total count karo
        int count = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                count += maxFreq;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountElementsWithMaxFrequency sol = new CountElementsWithMaxFrequency();

        System.out.print("Test 1: ");
        System.out.println(sol.maxFrequencyElements(new int[]{2,5,5,3,2,6})); // 4

        System.out.print("Test 2: ");
        System.out.println(sol.maxFrequencyElements(new int[]{4,5,6,7,8})); // 5

        System.out.print("Test 3: ");
        System.out.println(sol.maxFrequencyElements(new int[]{1,1,2,2,3})); // 4

        System.out.print("Test 4: ");
        System.out.println(sol.maxFrequencyElements(new int[]{1})); // 1
    }
}
