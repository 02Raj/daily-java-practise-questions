package striver_sde_sheet.array;

import java.util.HashMap;
import java.util.Map;

/*
===========================================================
🧩 Problem: Four Sum II (4Sum II)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/4sum-ii/
📅 Solved On: 17-04-2025
🔁 Revision Due: 24-04-2025
===========================================================

📝 Problem Statement:
Given four integer arrays nums1, nums2, nums3, nums4 of length n,
return the number of tuples (i,j,k,l) such that:
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Example:
Input:  nums1=[1,2], nums2=[-2,-1], nums3=[-1,2], nums4=[0,2]
Output: 2
Tuples: (0,0,0,0) → 1+(-2)+(-1)+0 = 0 ✅
        (1,1,0,0) → 2+(-1)+(-1)+0 = 0 ✅

Input:  nums1=[0], nums2=[0], nums3=[0], nums4=[0]
Output: 1

===========================================================
❓ YEH PROBLEM PREVIOUS FOUR SUM SE ALAG KYUN HAI?
===========================================================

Feature              | Four Sum (LC 18)        | Four Sum II (LC 454)
---------------------|-------------------------|-------------------------
Input                | 1 array                 | 4 ALAG arrays
Output               | Unique quadruplets      | COUNT of tuples
Duplicates?          | Skip karne padte hain   | KOI duplicate issue NAHI
                     |                         | (alag arrays hain)
Two Pointer?         | ✅ Sort + Two Pointer   | ❌ NAHI CHALEGA
                     |                         | (4 alag arrays sort
                     |                         |  karne se kuch nahi
                     |                         |  hoga — ek array nahi)
Overflow risk?       | ⚠️ High — long use karo | Low — n<=200, values
                     |                         | small, int safe hai

===========================================================
💡 APPROACH — HashMap (Split into Two Pairs)
===========================================================

🧠 Intuition:
→ Brute force: 4 nested loops → O(n⁴) — bahut slow
→ Smart idea: 4 arrays ko 2+2 mein tod do!
  - nums1+nums2 ke saare sums → HashMap mein store karo
  - nums3+nums4 ke har sum ke liye → complement map mein dhundo
→ a+b+c+d=0  ===  a+b = -(c+d)
→ Yahi HashMap ka kaam hai!

Kyun Two Pointer nahi?
→ Two Pointer ek SORTED array pe kaam karta hai
→ Yahaan 4 ALAG arrays hain — inhe combine karke sort
  karna O(n⁴) combinations banata hai — koi faida nahi
→ HashMap se hum O(n²) mein nikal jaate hain

Kyun Overflow nahi?
→ Constraints: n <= 200, values <= 10^9 max
→ a+b max = 2 * 10^9 → int range mein (barely) fit hai
→ But SAFE rehne ke liye long use karna better practice hai

Step 1: nums1 x nums2 ke saare pairs ka sum → map mein store karo
        map = {sum → kitni baar aaya}
Step 2: nums3 x nums4 ke har pair ke liye:
        complement = -(c+d)
        map mein complement hai? → count += map.get(complement)

-----------------------------------------------------------
🔁 Dry Run:
nums1=[1,2], nums2=[-2,-1], nums3=[-1,2], nums4=[0,2]
-----------------------------------------------------------

STEP 1 — nums1 x nums2 sums:

a  |  b  | sum  | map state
---|-----|------|---------------------------
1  | -2  |  -1  | {-1:1}
1  | -1  |   0  | {-1:1, 0:1}
2  | -2  |   0  | {-1:1, 0:2}
2  | -1  |   1  | {-1:1, 0:2, 1:1}

STEP 2 — nums3 x nums4, complement dhundo:

c  |  d  | c+d | complement=-(c+d) | map.get? | count
---|-----|-----|-------------------|----------|------
-1 |  0  | -1  |        1          |    1     |   1
-1 |  2  |  1  |       -1          |    1     |   2
 2 |  0  |  2  |       -2          |  null    |   2
 2 |  2  |  4  |       -4          |  null    |   2

👉 Answer: 2 ✅

-----------------------------------------------------------
⏱ Time Complexity (TC):

→ Step 1: nums1 x nums2 → O(n²)
→ Step 2: nums3 x nums4 → O(n²)
→ HashMap lookup → O(1) average

👉 Final TC = O(n²)   ← Brute force O(n⁴) se bahut better!

-----------------------------------------------------------
📦 Space Complexity (SC):

→ HashMap mein max n² entries (nums1 x nums2 pairs)

👉 SC = O(n²)

-----------------------------------------------------------
🧠 Key Points (Must Remember):
[ ] 4 alag arrays → Two Pointer kaam NAHI karta
[ ] a+b = -(c+d) → yahi split idea hai — yaad rakho!
[ ] map.getOrDefault(sum, 0)+1 → naya sum pehli baar aaye toh 0 se shuru
[ ] complement = -sum (c+d ka negative)
[ ] count += map.get(-sum) → ek complement ke liye MULTIPLE pairs ho sakte hain
[ ] Overflow yahaan LOW risk hai (n<=200) — phir bhi long better practice

-----------------------------------------------------------
🆚 Kab kaunsa approach?

Situation                          | Approach
-----------------------------------|------------------
1 array, unique quadruplets        | Sort + Two Pointer (Four Sum LC 18)
4 alag arrays, count of tuples     | HashMap 2+2 split (Four Sum II LC 454)
2 arrays, count of pairs = target  | HashMap (Two Sum variant)

===========================================================
*/

public class FourSumII {

    public static int fourSumCount(int[] nums1, int[] nums2,
                                   int[] nums3, int[] nums4) {

        // Step 1: nums1 x nums2 ke saare sums store karo
        // map = {sum → kitni baar aaya}
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                // Pehli baar aaya → 0+1=1, dobara aaya → existing+1
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Step 2: nums3 x nums4 ke har pair ke liye complement dhundo
        // a+b+c+d=0 → a+b = -(c+d)
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;

                // Complement map mein hai? → utne saare tuples add karo
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }

        return count;
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] n1 = {1, 2},  n2 = {-2, -1};
        int[] n3 = {-1, 2}, n4 = {0, 2};
        System.out.println("Test 1: " + fourSumCount(n1, n2, n3, n4));
        // Expected: 2

        // Test 2: All zeros
        int[] a1 = {0}, a2 = {0}, a3 = {0}, a4 = {0};
        System.out.println("Test 2: " + fourSumCount(a1, a2, a3, a4));
        // Expected: 1

        // Test 3: No valid tuple
        int[] b1 = {1, 2}, b2 = {3, 4}, b3 = {5, 6}, b4 = {7, 8};
        System.out.println("Test 3: " + fourSumCount(b1, b2, b3, b4));
        // Expected: 0

        // Test 4: Multiple same sums — count properly
        int[] c1 = {1, -1}, c2 = {-1, 1}, c3 = {1, -1}, c4 = {-1, 1};
        System.out.println("Test 4: " + fourSumCount(c1, c2, c3, c4));
        // Expected: 8
    }
}