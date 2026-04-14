package striver_sde_sheet.array;

import java.util.HashMap;

/*
===========================================================
🧩 Problem: Majority Element
===========================================================
🔗 LeetCode: https://leetcode.com/problems/majority-element/
📅 Solved On: 14-04-2025
🔁 Revision Due: 21-04-2025
===========================================================

📝 Problem Statement:
Given an integer array nums of size n, find the element
that appears MORE THAN n/2 times. (It is guaranteed to exist.)

Example:
Input:  nums = [3,2,3]           →  Output: 3
Input:  nums = [2,2,1,1,1,2,2]  →  Output: 2

-----------------------------------------------------------
💡 Approach (HashMap — Frequency Count):

Main idea:
→ Har element ki frequency track karo HashMap mein
→ Jaise hi kisi element ki count n/2 se zyada ho jaaye,
  wahi hamara majority element hai — turant return karo

Step 1: halfLength = n / 2 calculate karo

Step 2: Array traverse karo:
        → freqMap mein current element ki count badhao
        → Agar count > halfLength ho jaaye → return that element

Step 3: Agar loop ke baad kuch na mile → return -1
        (Problem guarantees existence, toh yeh case aayega nahi)

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ getOrDefault(key, 0) use karo — NullPointerException avoid hoti hai
→ count ko PUT karne KE BAAD check karo — warna ek count peeche rahega
→ Majority element guaranteed hai, toh -1 practically kabhi nahi aayega
→ Early return optimization hai — poora array traverse nahi karna padta

-----------------------------------------------------------
🔁 Dry Run: [2, 2, 1, 1, 1, 2, 2]  →  n=7, halfLength=3

i  | nums[i] | freqMap after put       | count > 3?
---|---------|-------------------------|------------
0  |    2    | {2=1}                   | No
1  |    2    | {2=2}                   | No
2  |    1    | {2=2, 1=1}              | No
3  |    1    | {2=2, 1=2}              | No
4  |    1    | {2=2, 1=3}              | No
5  |    2    | {2=3, 1=3}              | No
6  |    2    | {2=4, 1=3}              | YES → return 2 ✅

👉 Answer: 2

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass through array → O(n)
HashMap get/put → O(1) average

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

HashMap mein at most n distinct elements → O(n)

👉 SC = O(n)

-----------------------------------------------------------
💡 Better Approach (Bonus — Moore's Voting Algorithm):

→ O(n) time aur O(1) space mein solve hota hai
→ Idea: majority element ke votes baaki sab ko cancel kar dete hain
→ Aage is problem ko Moore's Voting se bhi solve karna seekhna!

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] getOrDefault() kyun use kiya? Direct get() se kya problem hoti?
[ ] Count check PUT ke baad kyun karte hain, pehle kyun nahi?
[ ] All-same array mein kya hoga? e.g. [3,3,3] → 3
[ ] Dry run: [3,2,3] → expected 3
[ ] Moore's Voting Algorithm se kaise solve hoga? (O(1) space)

===========================================================
*/

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int halfLength = n / 2;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Pehle current count lo (0 default agar pehli baar hai)
            int count = freqMap.getOrDefault(nums[i], 0) + 1;

            // Updated count wapas map mein daalo
            freqMap.put(nums[i], count);

            // Agar majority condition satisfy ho gayi → turant return
            if (count > halfLength) {
                return nums[i];
            }
        }

        // Yahan kabhi nahi aayenge (problem guarantees majority element exists)
        return -1;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] arr1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.print("Test 1: ");
        System.out.println(majorityElement(arr1)); // Expected: 2

        // Test 2: Simple case
        int[] arr2 = {3, 2, 3};
        System.out.print("Test 2: ");
        System.out.println(majorityElement(arr2)); // Expected: 3

        // Test 3: All same elements
        int[] arr3 = {3, 3, 3};
        System.out.print("Test 3: ");
        System.out.println(majorityElement(arr3)); // Expected: 3

        // Test 4: Single element
        int[] arr4 = {1};
        System.out.print("Test 4: ");
        System.out.println(majorityElement(arr4)); // Expected: 1

        // Test 5: Majority at the end
        int[] arr5 = {1, 2, 1, 2, 1, 2, 1};
        System.out.print("Test 5: ");
        System.out.println(majorityElement(arr5)); // Expected: 1
    }
}