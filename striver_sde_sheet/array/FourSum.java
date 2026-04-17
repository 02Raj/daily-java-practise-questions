package striver_sde_sheet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
===========================================================
🧩 Problem: Four Sum
===========================================================
🔗 LeetCode: https://leetcode.com/problems/4sum/
📅 Solved On: 17-04-2025
🔁 Revision Due: 24-04-2025
===========================================================

📝 Problem Statement:
Given an integer array nums and a target, return all unique
quadruplets [a,b,c,d] such that a+b+c+d = target.

Example:
Input:  nums=[1,0,-1,0,-2,2], target=0  → [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Input:  nums=[2,2,2,2,2],     target=8  → [[2,2,2,2]]

===========================================================
💡 APPROACH — Sort + Fix Two + Two Pointer
===========================================================

🧠 Intuition:
→ Three Sum mein ek fix kiya tha, Two Pointer lagaya tha
→ Four Sum mein do fix karo (i, j), baaki do pe Two Pointer
→ a+b+c+d = target  ===  c+d = target-a-b  (yahi Two Pointer ka target)

Step 1: Sort karo
Step 2: i = 0 to n-4 (fix karo nums[i])
Step 3: j = i+1 to n-3 (fix karo nums[j])
Step 4: L=j+1, R=n-1 pe Two Pointer
Step 5: Har level pe duplicates skip karo

⚠️ OVERFLOW WARNING:
→ nums[i] + nums[j] + nums[L] + nums[R] — chaar bade numbers
→ int range: ~2.1 billion, teen-chaar large ints add karo → OVERFLOW
→ FIX: Har jagah long use karo!

Example of overflow:
  nums[i]=1000000000, nums[j]=1000000000
  int sum = nums[i] + nums[j] → 2000000000 (theek hai abhi)
  + nums[L]=1000000000 → OVERFLOW! int wrap ho jaata hai

-----------------------------------------------------------
🔁 Dry Run: nums=[1,0,-1,0,-2,2], target=0
-----------------------------------------------------------

After sort → [-2,-1,0,0,1,2]
               0   1 2 3 4 5

--- i=0 (nums[i]=-2) ---

  j=1 (nums[j]=-1), twoPointerTarget = 0-(-2)-(-1) = 3
  L=2,R=5: -2+1? No wait nums[L]=0,nums[R]=2 → sum=2 < 3 → L++
  L=3,R=5: 0+2=2 < 3 → L++
  L=4,R=5: 1+2=3 ✅ → store [-2,-1,1,2] → L++,R--
  L>=R → stop

  j=2 (nums[j]=0), twoPointerTarget = 0-(-2)-0 = 2
  L=3,R=5: 0+2=2 ✅ → store [-2,0,0,2] → L++,R--
  L>=R → stop

  j=3 (nums[j]=0) → j>i+1 && nums[3]==nums[2] → SKIP

  j=4 (nums[j]=1), twoPointerTarget = 0-(-2)-1 = 1
  L=5,R=5: L>=R → stop immediately

--- i=1 (nums[i]=-1) ---

  j=2 (nums[j]=0), twoPointerTarget = 0-(-1)-0 = 1
  L=3,R=5: 0+2=2 > 1 → R--
  L=3,R=4: 0+1=1 ✅ → store [-1,0,0,1] → L++,R--
  L>=R → stop

  j=3 (nums[j]=0) → j>i+1 && nums[3]==nums[2] → SKIP

--- i=2 (nums[i]=0) → i>0 && nums[2]==nums[1]? No (0!=-1) ---
  j=3 (nums[j]=0), twoPointerTarget = 0-0-0 = 0
  L=4,R=5: 1+2=3 > 0 → R--
  L>=R → stop

  (remaining j values give no valid pairs)

--- i=3 → i>0 && nums[3]==nums[2] → SKIP ---

👉 Answer: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ✅

-----------------------------------------------------------
⏱ Time Complexity (TC):

→ Sorting          → O(n log n)
→ Outer loop i     → O(n)
→ Inner loop j     → O(n)
→ Two Pointer      → O(n)
→ Total            → O(n²) per i → O(n³) overall

👉 Final TC = O(n³)

-----------------------------------------------------------
📦 Space Complexity (SC):

→ Sorting stack    → O(log n)
→ No extra arrays

👉 SC = O(log n)

-----------------------------------------------------------
🧠 Key Points (Must Remember):
[ ] LONG use karo HAMESHA — int overflow sabse common bug hai Four Sum mein
[ ] Do levels pe duplicate skip: i aur j dono pe
[ ] i duplicate: i > 0 && nums[i] == nums[i-1]
[ ] j duplicate: j > i+1 && nums[j] == nums[j-1]  ← i+1 kyunki j i se start hota hai
[ ] twoPointer target = (long)target - nums[i] - nums[j]
[ ] Three Sum se ek extra loop — same pattern, ek level deeper

-----------------------------------------------------------
🆚 Comparison — Two/Three/Four Sum Pattern:

Problem    | Fix    | Two Pointer | TC      | Overflow Risk
-----------|--------|-------------|---------|---------------
Two Sum    | 0 vars | ✅ 1 pass   | O(n)    | Low
Three Sum  | 1 var  | ✅ inner    | O(n²)   | Medium
Four Sum   | 2 vars | ✅ inner    | O(n³)   | ⚠️ HIGH — use long!

===========================================================
*/

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // Duplicate i skip
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Duplicate j skip — j>i+1 kyunki pehli j always valid
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // ✅ long mein target pass karo — overflow avoid
                long twoPointerTarget = (long) target - nums[i] - nums[j];
                twoPointer(nums, j + 1, result, twoPointerTarget, nums[i], nums[j]);
            }
        }

        return result;
    }

    // ✅ target parameter long hai — overflow nahi hoga
    private static void twoPointer(int[] nums, int start,
                                   List<List<Integer>> result,
                                   long target, int first, int second) {
        int L = start;
        int R = nums.length - 1;

        while (L < R) {
            // ✅ long mein sum — do large ints ka addition overflow-safe
            long sum = (long) nums[L] + nums[R];

            if (sum > target) {
                R--;
            } else if (sum < target) {
                L++;
            } else {
                result.add(Arrays.asList(first, second, nums[L], nums[R]));

                // Duplicate L aur R skip karo
                while (L < R && nums[L] == nums[L + 1]) L++;
                while (L < R && nums[R] == nums[R - 1]) R--;

                L++;
                R--;
            }
        }
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] arr1 = {1, 0, -1, 0, -2, 2};
        System.out.println("Test 1: " + fourSum(arr1, 0));
        // Expected: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        // Test 2: All same elements
        int[] arr2 = {2, 2, 2, 2, 2};
        System.out.println("Test 2: " + fourSum(arr2, 8));
        // Expected: [[2,2,2,2]]

        // Test 3: Overflow test case — int se hota WRONG ANSWER
        int[] arr3 = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println("Test 3: " + fourSum(arr3, -294967296));
        // Expected: []  ← long se sahi aayega!

        // Test 4: Negative target
        int[] arr4 = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println("Test 4: " + fourSum(arr4, 0));
        // Expected: [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}