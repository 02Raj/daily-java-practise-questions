package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Next Permutation
===========================================================
🔗 LeetCode: https://leetcode.com/problems/next-permutation/
📅 Solved On: 09-04-2025
🔁 Revision Due: 16-04-2025
===========================================================

📝 Problem Statement:
Given an array nums, rearrange it into the next lexicographically
greater permutation. If no such arrangement exists (array is
descending), rearrange to the lowest order (ascending).
Must be done IN-PLACE with O(1) extra space.

Example:
Input:  nums = [1,2,3]  →  Output: [1,3,2]
Input:  nums = [3,2,1]  →  Output: [1,2,3]
Input:  nums = [1,1,5]  →  Output: [1,5,1]

-----------------------------------------------------------
💡 Approach (Optimal — 3 Steps):

Step 1: Right se left jao, pehla "dip" dhundho
        → pehli jagah jahan nums[i] < nums[i+1]
        → yahi PIVOT hai (i)

Step 2: Agar pivot mila (i >= 0):
        → Right se pehla element dhundho jo nums[i] se bada ho (j)
        → nums[i] aur nums[j] ko swap karo

Step 3: i+1 se end tak reverse karo
        → Yeh hissa hamesha descending hota hai
        → Reverse karke smallest banana hai

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ "Dip" = pehli jagah jahan LEFT wala RIGHT se CHHOTA ho
→ Pivot ke right wala hissa HAMESHA descending hota hai
→ Step 2 mein j RIGHT se shuru hota hai — pehla bada milega
→ Agar i < 0 (no pivot) → poora array reverse = smallest perm
→ Step 3 hamesha chalta hai — even when i = -1 (left=0, right=n-1)

-----------------------------------------------------------
⏱ Time Complexity (TC):

Step 1 (scan) → O(n)
Step 2 (scan + swap) → O(n)
Step 3 (reverse) → O(n)

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

In-place — koi extra array nahi

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] i = n-2 se kyun shuru karte hain? (n-1 se kyun nahi?)
[ ] Agar pivot nahi mila toh kya hoga? (i = -1 case)
[ ] Step 3 sirf pivot ke baad kyun reverse karte hain?
[ ] Dry run: [2,3,1] → expected [3,1,2]
[ ] Dry run: [1,1,5] → expected [1,5,1] (duplicate case)

===========================================================
*/

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Right se left — pehla "dip" dhundho (pivot i)
        // nums[i] < nums[i+1] wali condition pe rukna hai
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Pivot mila toh — pivot se bada pehla element dhundho (j)
        // Right se scan karo, swap karo
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap pivot aur j
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // Step 3: i+1 se end tak reverse karo
        // Do pointer — left badhta hai, right ghatta hai
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();

        // Test 1: Simple case
        int[] nums1 = {1, 2, 3};
        obj.nextPermutation(nums1);
        System.out.print("Test 1: ");
        printArray(nums1); // Expected: [1, 3, 2]

        // Test 2: Full descending — reverse hoga
        int[] nums2 = {3, 2, 1};
        obj.nextPermutation(nums2);
        System.out.print("Test 2: ");
        printArray(nums2); // Expected: [1, 2, 3]

        // Test 3: Duplicate elements
        int[] nums3 = {1, 1, 5};
        obj.nextPermutation(nums3);
        System.out.print("Test 3: ");
        printArray(nums3); // Expected: [1, 5, 1]

        // Test 4: Full dry run case
        int[] nums4 = {2, 3, 1};
        obj.nextPermutation(nums4);
        System.out.print("Test 4: ");
        printArray(nums4); // Expected: [3, 1, 2]
    }

    // 🔥 Helper: array print karo
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}