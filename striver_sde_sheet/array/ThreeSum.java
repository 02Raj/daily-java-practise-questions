package striver_sde_sheet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
===========================================================
🧩 Problem: Three Sum
===========================================================
🔗 LeetCode: https://leetcode.com/problems/3sum/
📅 Solved On: 17-04-2025
🔁 Revision Due: 24-04-2025
===========================================================

📝 Problem Statement:
Given an integer array nums, return all triplets [a, b, c]
such that a + b + c = 0, and no duplicate triplets.

Example:
Input:  nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1,-1,2], [-1,0,1]]

Input:  nums = [0, 0, 0, 0]
Output: [[0,0,0]]

Input:  nums = [1, 2, -2, -1]
Output: []

===========================================================
💡 APPROACH — Sort + Two Pointer
===========================================================

🧠 Intuition:
→ Brute force: teen nested loops → O(n³) — bahut slow
→ Better idea: Three Sum ko Two Sum mein reduce karo!
→ Ek element fix karo (nums[i]), baaki do ke liye
  Two Pointer use karo sorted array pe
→ a + b + c = 0  ===  b + c = -nums[i]  (yahi target hai)

Kyun Sort karna zaroori hai?
→ Two Pointer sirf sorted array pe kaam karta hai
→ Duplicates skip karna sort ke baad bahut easy ho jaata hai

Step 1: Array sort karo
Step 2: i = 0 se n-3 tak loop karo (nums[i] fix karo)
Step 3: Duplicate i skip karo → nums[i] == nums[i-1]? continue
Step 4: Baaki array pe Two Pointer → target = -nums[i]
Step 5: Triplet mile → store karo, duplicate L/R bhi skip karo

-----------------------------------------------------------
🔁 Dry Run: nums = [-1, 0, 1, 2, -1, -4], target = 0
-----------------------------------------------------------

After sort → [-4, -1, -1, 0, 1, 2]
               0    1   2  3  4  5   ← indices

--- i=0, nums[i]=-4, target=4, L=1, R=5 ---

L  | R  | nums[L] | nums[R] | sum | Action
---|-----|---------|---------|-----|-------------------
1  |  5  |   -1   |    2    |  1  | < 4 → L++
2  |  5  |   -1   |    2    |  1  | < 4 → L++
3  |  5  |    0   |    2    |  2  | < 4 → L++
4  |  5  |    1   |    2    |  3  | < 4 → L++
L >= R → stop. No triplet found.

--- i=1, nums[i]=-1, target=1, L=2, R=5 ---

L  | R  | nums[L] | nums[R] | sum | Action
---|-----|---------|---------|-----|-------------------
2  |  5  |   -1   |    2    |  1  | = 1 ✅ store [-1,-1,2]
           skip duplicates → L=3, R=4
3  |  4  |    0   |    1    |  1  | = 1 ✅ store [-1,0,1]
           skip duplicates → L=4, R=3
L >= R → stop.

--- i=2, nums[i]=-1 → nums[2]==nums[1] → SKIP (duplicate) ---

--- i=3, nums[i]=0, target=0, L=4, R=5 ---

L  | R  | nums[L] | nums[R] | sum | Action
---|-----|---------|---------|-----|-------------------
4  |  5  |    1   |    2    |  3  | > 0 → R--
L >= R → stop.

👉 Answer: [[-1,-1,2], [-1,0,1]]

-----------------------------------------------------------
⏱ Time Complexity (TC):

→ Sorting          → O(n log n)
→ Outer loop i     → O(n)
→ Two Pointer      → O(n) per iteration
→ Total loop work  → O(n²)

👉 Final TC = O(n²)   ← Sorting se dominated nahi, loop se

-----------------------------------------------------------
📦 Space Complexity (SC):

→ Result list ko count nahi karte (output space)
→ Sorting in-place (Java Arrays.sort) → O(log n) stack
→ Extra koi array nahi

👉 SC = O(log n)   [only sorting stack space]

-----------------------------------------------------------
🧠 Key Points (Must Remember):
[ ] Sort karna ZAROORI hai — Two Pointer + Duplicate skip dono ke liye
[ ] Outer loop i → 0 to n-3 tak (last 2 elements L/R ke liye chahiye)
[ ] Duplicate i skip: i > 0 && nums[i] == nums[i-1] → continue
[ ] Triplet store karne ke BAAD L/R duplicates skip karo
[ ] target = -nums[i] (a+b+c=0 se b+c=-a nikala)
[ ] L/R duplicate skip: while(i<j && nums[i]==nums[i+1]) i++
    Phir EXTRA i++, j-- bhi karo — next unique pair pe jaane ke liye
[ ] nums[i] > 0 → Early exit possible! (sorted array, aage sab positive,
    sum kabhi 0 nahi banega) — optional optimization

-----------------------------------------------------------
🆚 Approaches Comparison:

Approach        | TC      | SC        | Notes
----------------|---------|-----------|---------------------------
Brute Force     | O(n³)   | O(1)      | 3 nested loops, TLE
HashSet         | O(n²)   | O(n)      | Extra space, complex dedup
Sort+TwoPointer | O(n²)   | O(log n)  | ✅ Best — clean + optimal

===========================================================
*/

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: 3 se kam elements → triplet possible hi nahi
        if (nums.length < 3) return result;

        // Step 1: Sort — Two Pointer aur duplicate skip dono ke liye zaroori
        Arrays.sort(nums);

        // Step 2: Har element ko fix karo (last 2 L/R ke liye reserved)
        for (int i = 0; i < nums.length - 2; i++) {

            // Duplicate i skip karo — same triplets dobara nahi chahiye
            // i>0 check isliye — pehle element pe peeche koi nahi hota
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optional optimization: nums[i] > 0 → aage sab positive
            // → sum kabhi 0 nahi banega
            if (nums[i] > 0) break;

            // Step 3: Baaki array pe Two Pointer
            // target = -nums[i] kyunki a + b + c = 0 → b + c = -a
            twoPointer(nums, i + 1, -nums[i], result);
        }

        return result;
    }

    private static void twoPointer(int[] nums, int start, int target,
                                   List<List<Integer>> result) {
        int L = start;
        int R = nums.length - 1;

        while (L < R) {
            int sum = nums[L] + nums[R];

            if (sum > target) {
                R--;  // Sum bada → R left laao (value choti karo)

            } else if (sum < target) {
                L++;  // Sum chota → L right laao (value badi karo)

            } else {
                // Triplet mila! — target wapas negate karo original value ke liye
                result.add(Arrays.asList(-target, nums[L], nums[R]));

                // Duplicate L skip karo — same triplet dobara nahi chahiye
                while (L < R && nums[L] == nums[L + 1]) L++;
                // Duplicate R skip karo
                while (L < R && nums[R] == nums[R - 1]) R--;

                // Next unique pair pe jao
                L++;
                R--;
            }
        }
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        // Test 1: Classic case — 2 triplets
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + threeSum(arr1));
        // Expected: [[-1,-1,2],[-1,0,1]]

        // Test 2: All zeros — only one triplet
        int[] arr2 = {0, 0, 0, 0};
        System.out.println("Test 2: " + threeSum(arr2));
        // Expected: [[0,0,0]]

        // Test 3: No valid triplet
        int[] arr3 = {1, 2, -2, -1};
        System.out.println("Test 3: " + threeSum(arr3));
        // Expected: []

        // Test 4: All same negative — no triplet
        int[] arr4 = {-2, -2, -2};
        System.out.println("Test 4: " + threeSum(arr4));
        // Expected: []

        // Test 5: Large with multiple triplets
        int[] arr5 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println("Test 5: " + threeSum(arr5));
        // Expected: [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
    }
}