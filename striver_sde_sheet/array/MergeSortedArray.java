package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Merge Sorted Array
===========================================================
🔗 LeetCode: https://leetcode.com/problems/merge-sorted-array/
📅 Solved On: 13-04-2025
🔁 Revision Due: 20-04-2025
===========================================================

📝 Problem Statement:
Do sorted arrays nums1 aur nums2 diye hain.
nums1 ki size m+n hai — pehle m elements valid hain, baaki n slots empty hain.
nums2 ki size n hai.
Dono ko merge karo nums1 mein — in-place, sorted order mein.

Example:
Input:  nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3
Output: nums1 = [1,2,2,3,5,6]

Input:  nums1 = [1], m = 1, nums2 = [], n = 0
Output: nums1 = [1]

Input:  nums1 = [0], m = 0, nums2 = [1], n = 1
Output: nums1 = [1]

-----------------------------------------------------------
💡 Approach (Optimal — 3 Pointer from the End):

Main idea:
→ Aage se merge karne pe overwrite ka darr hota hai
→ Isliye PEECHE se shuru karo — sabse bada element pehle place karo

3 Pointers:
→ i = nums1 ka last valid element  (index: m-1)
→ j = nums2 ka last element        (index: n-1)
→ k = nums1 ka last slot           (index: m+n-1)

Step 1: nums1[i] aur nums2[j] compare karo
        → Jo bada ho, use nums1[k] pe rakho, k-- aur wo pointer--

Step 2: Jab nums1 khatam ho jaaye (i < 0),
        nums2 ke baaki elements seedha copy kar do
        → nums1[i] pehle se sorted hain, inhe move karne ki zarurat nahi

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ Peeche se traverse karo — overwrite problem nahi aati
→ Sirf nums2 ka remaining copy karna zaroori hai (nums1 ka nahi)
  → nums1 ke baaki elements already sahi jagah pe hain
→ O(m+n) time, O(1) space — no extra array needed

-----------------------------------------------------------
🔁 Dry Run: nums1=[1,2,3,0,0,0] m=3, nums2=[2,5,6] n=3

i=2, j=2, k=5

i  | j  | k  | nums1[i] vs nums2[j] | Action
---|----|----|----------------------|-------------------------
 2 |  2 |  5 | 3 < 6                | nums1[5]=6, j=1, k=4
 2 |  1 |  4 | 3 < 5                | nums1[4]=5, j=0, k=3
 2 |  0 |  3 | 3 > 2                | nums1[3]=3, i=1, k=2
 1 |  0 |  2 | 2 == 2               | nums1[2]=2, j=-1, k=1

j < 0 → loop ends
nums1 = [1,2,2,3,5,6] ✅

-----------------------------------------------------------
⏱ Time Complexity (TC):

Ek hi pass — m+n elements pe → O(m+n)

👉 Final TC = O(m+n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Koi extra array nahi, sirf 3 variables

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Peeche se kyun shuru karte hain? Aage se kya problem hoti?
[ ] Sirf nums2 ka remaining loop kyun? nums1 ka kyun nahi?
[ ] Dry run: nums1=[0], m=0, nums2=[1], n=1 → expected [1]
[ ] Dry run: nums1=[1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3 → [1,2,2,3,5,6]
[ ] Edge case: nums2 empty ho toh kya hoga?

===========================================================
*/

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // nums1 ka last valid element
        int j = n - 1;       // nums2 ka last element
        int k = m + n - 1;   // nums1 ka last slot (fill karna hai yahan se)

        // Step 1: Dono arrays compare karo — bada element peeche rakho
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Step 2: nums2 ke baaki elements copy karo (agar bache ho)
        // nums1 ke baaki elements already sahi jagah pe hain — kuch karna nahi
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.print("Test 1: ");
        System.out.println(java.util.Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]

        // Test 2: nums2 empty
        int[] nums2 = {1};
        merge(nums2, 1, new int[]{}, 0);
        System.out.print("Test 2: ");
        System.out.println(java.util.Arrays.toString(nums2)); // [1]

        // Test 3: nums1 empty (m=0)
        int[] nums3 = {0};
        merge(nums3, 0, new int[]{1}, 1);
        System.out.print("Test 3: ");
        System.out.println(java.util.Arrays.toString(nums3)); // [1]
    }
}