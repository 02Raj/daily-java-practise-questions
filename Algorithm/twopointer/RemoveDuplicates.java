package Algorithm.twopointer;

/*
===========================================================
🧩 Problem: Remove Duplicates from Sorted Array
===========================================================
🔗 LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
📅 Solved On: 20-04-2026
🔁 Revision Due: 27-04-2026
===========================================================

📝 Problem Statement:
Given a sorted array nums, remove the duplicates in-place
such that each unique element appears only once.

Return the number of unique elements (k).

The first k elements of nums should contain the final result.

Example:
Input:  nums = [1,1,2]        → Output: 2  (nums = [1,2,_])
Input:  nums = [0,0,1,1,2,2]  → Output: 3  (nums = [0,1,2,_])

-----------------------------------------------------------
💡 Approach (Two Pointer):

Main idea:
→ Ek pointer (j) unique elements track karega
→ Dusra pointer (i) array traverse karega

Step 1: j = 0 (first element always unique)
Step 2: i = 1 se loop chalao

Step 3: Agar nums[i] != nums[j]
        → naya unique element mila
        → j++ karo
        → nums[j] = nums[i]

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):

→ Array sorted hai, isliye duplicates adjacent honge
→ j = last unique element ka index
→ i = scanning pointer
→ Left side (0 to j) = always unique elements
→ In-place solution (extra space nahi use hota)
→ Return = j + 1 (length of unique elements)

-----------------------------------------------------------
🔁 Dry Run: [1,1,2,2,3]

i  | nums[i] | nums[j] | Action              | Array
---|---------|---------|---------------------|----------------
1  |   1     |   1     | Duplicate (skip)    | [1,1,2,2,3]
2  |   2     |   1     | Unique → j++        | [1,2,2,2,3]
3  |   2     |   2     | Duplicate (skip)    | [1,2,2,2,3]
4  |   3     |   2     | Unique → j++        | [1,2,3,2,3]

👉 Final Unique Part: [1,2,3]
👉 Return: 3

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass → O(n)

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

In-place (no extra space)

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:

[ ] j pointer kya represent karta hai?
[ ] kyun array sorted hona zaroori hai?
[ ] return j + 1 kyun karte hain?
[ ] Dry run: [1,1,1,2] → expected 2
[ ] Dry run: [0,0,0] → expected 1

===========================================================
*/

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0; // last unique element index

        for (int i = 1; i < nums.length; i++) {

            // new unique element mila
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        int[] arr1 = {1,1,2};
        System.out.print("Test 1: ");
        System.out.println(removeDuplicates(arr1)); // Expected: 2

        int[] arr2 = {0,0,1,1,2,2};
        System.out.print("Test 2: ");
        System.out.println(removeDuplicates(arr2)); // Expected: 3

        int[] arr3 = {1,1,1,1};
        System.out.print("Test 3: ");
        System.out.println(removeDuplicates(arr3)); // Expected: 1

        int[] arr4 = {1,2,3};
        System.out.print("Test 4: ");
        System.out.println(removeDuplicates(arr4)); // Expected: 3
    }
}