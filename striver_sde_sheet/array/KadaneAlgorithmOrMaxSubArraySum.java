package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Maximum Subarray Sum (Kadane's Algorithm)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/maximum-subarray/
📅 Solved On: 10-04-2025
🔁 Revision Due: 17-04-2025
===========================================================

📝 Problem Statement:
Given an integer array nums, find the subarray with the
largest sum and return that sum.

Example:
Input:  nums = [-2,1,-3,4,-1,2,1,-5,4]  →  Output: 6
        (Subarray: [4,-1,2,1])
Input:  nums = [1]                        →  Output: 1
Input:  nums = [5,4,-1,7,8]              →  Output: 23

-----------------------------------------------------------
💡 Approach (Optimal — Kadane's Algorithm):

Main idea:
→ Har element pe ek sawaal poochho:
  "Kya main pichle subarray ke saath jodunga, ya fresh start karunga?"

Step 1: currentSum mein current element add karo
        → currentSum += num

Step 2: maxSum update karo agar currentSum bada ho
        → maxSum = Math.max(maxSum, currentSum)

Step 3: Agar currentSum negative ho jaaye, reset kar do
        → currentSum = 0
        → Negative sum aage le jaana fayda nahi

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ currentSum < 0 hone pe reset karo — negative prefix kabhi helpful nahi
→ maxSum ko Integer.MIN_VALUE se shuru karo (all-negative arrays handle hote hain)
→ Reset SE PEHLE maxSum update karo — warna us element ka contribution miss hoga
→ Yeh O(n) mein kaam karta hai — ek hi pass mein answer mil jaata hai
→ Subarray track karna ho toh start/end indices bhi save kar sakte ho

-----------------------------------------------------------
🔁 Dry Run: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

num  | currentSum | maxSum | Action
-----|------------|--------|---------------------------
 -2  |    -2      |  -2    | Reset (currentSum < 0)
  1  |     1      |   1    | Continue
 -3  |    -2      |   1    | Reset (currentSum < 0)
  4  |     4      |   4    | Continue
 -1  |     3      |   4    | Continue
  2  |     5      |   5    | Continue
  1  |     6      |   6    | Continue   ← MAX
 -5  |     1      |   6    | Continue
  4  |     5      |   6    | Continue

👉 Answer: 6  (Subarray: [4,-1,2,1])

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass through array → O(n)

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Koi extra array nahi, sirf 2 variables

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] maxSum ko Integer.MIN_VALUE se kyun initialize karte hain?
[ ] Reset se pehle maxSum update kyun karna zaroori hai?
[ ] All-negative array mein kya hoga? e.g. [-3,-1,-2] → -1
[ ] Dry run: [5,4,-1,7,8] → expected 23
[ ] Dry run: [-2,-1] → expected -1

===========================================================
*/

public class KadaneAlgorithmOrMaxSubArraySum {

    public static int maxSubArray(int[] arr) {
        // Integer.MIN_VALUE isliye — agar sab elements negative ho
        // toh bhi correct (sabse kam negative) answer mile
        int maxSum = Integer.MIN_VALUE;

        // currentSum = abhi tak ka running subarray sum
        int currentSum = 0;

        for (int num : arr) {
            // Step 1: Current element ko running sum mein add karo
            currentSum += num;

            // Step 2: Pehle maxSum update karo — reset se pehle!
            // (Warna is element ka contribution record nahi hoga)
            maxSum = Math.max(maxSum, currentSum);

            // Step 3: Agar currentSum negative ho gaya toh reset
            // Negative prefix aage carry karna nuksandeh hai
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Mixed array — classic case
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print("Test 1: ");
        System.out.println(maxSubArray(arr1)); // Expected: 6

        // Test 2: All positive — poora array best subarray hai
        int[] arr2 = {5, 4, -1, 7, 8};
        System.out.print("Test 2: ");
        System.out.println(maxSubArray(arr2)); // Expected: 23

        // Test 3: All negative — sabse bada (least negative) element
        int[] arr3 = {-3, -1, -2};
        System.out.print("Test 3: ");
        System.out.println(maxSubArray(arr3)); // Expected: -1

        // Test 4: Single element
        int[] arr4 = {1};
        System.out.print("Test 4: ");
        System.out.println(maxSubArray(arr4)); // Expected: 1
    }
}