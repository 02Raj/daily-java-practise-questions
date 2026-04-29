package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Sort Colors (Dutch National Flag Algorithm)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/sort-colors/
📅 Solved On: 10-04-2025
🔁 Revision Due: 17-04-2025
===========================================================

📝 Problem Statement:
Given an array nums with only 0s, 1s, and 2s,
sort it IN-PLACE without using any sorting function.

Example:
Input:  [2, 0, 2, 1, 1, 0]  →  Output: [0, 0, 1, 1, 2, 2]

-----------------------------------------------------------
💡 Approach (Dutch National Flag — 3 Pointers):

Teen pointer use karte hain:
  low  → 0s yahan tak sorted hain (exclusive end)
  mid  → current element jo check kar rahe hain
  high → 2s yahan se sorted hain (exclusive start)

Loop tab tak chalta hai jab tak mid <= high

-----------------------------------------------------------
🔢 3 Cases (mid element dekho):

Case 1: nums[mid] == 0
  → 0 ko front mein chahiye
  → nums[low] aur nums[mid] swap karo
  → low++ aur mid++ (dono aage badho)

Case 2: nums[mid] == 1
  → 1 already sahi jagah pe hai (beech mein)
  → sirf mid++ karo

Case 3: nums[mid] == 2
  → 2 ko end mein chahiye
  → nums[mid] aur nums[high] swap karo
  → high-- (end se ek peeche aao)
  → mid ko mat badho! (swap ke baad naya nums[mid] check karna hai)

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ mid++ Case 1 mein kyon? low wala element 0 ya 1 hi hoga
  (low kabhi mid se aage nahi jaata)
→ mid++ Case 3 mein kyun nahi? high se aaya element unseen tha
→ Loop condition: mid <= high (mid > high pe ruko)
→ low <= mid hamesha holds true during the loop

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass — mid ek baar hi poora array traverse karta hai

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

In-place — koi extra array nahi

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Case 3 mein mid++ kyun nahi karte?
[ ] Loop mid <= high pe kyun rukta hai (mid > high pe)?
[ ] Dry run: [2,0,2,1,1,0] → expected [0,0,1,1,2,2]
[ ] Dry run: [2,0,1] → expected [0,1,2]
[ ] Dry run: [0] → expected [0] (single element)

===========================================================
*/

public class sortColors {

    public static void sortColors(int[] nums) {
        int low  = 0;           // 0s ki boundary — low se pehle sab 0 hain
        int mid  = 0;           // current pointer — isko hum check kar rahe hain
        int high = nums.length - 1; // 2s ki boundary — high ke baad sab 2 hain

        while (mid <= high) {  // mid > high hua matlab poora array sorted

            if (nums[mid] == 0) {
                // Case 1: 0 milaa → front pe bhejo
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;               // 0s boundary ek aage
                mid++;               // mid++ safe hai: low wala 0 ya 1 hi tha

            } else if (nums[mid] == 1) {
                // Case 2: 1 milaa → already sahi jagah, bas aage badho
                mid++;

            } else {
                // Case 3: 2 milaa → end pe bhejo
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;              // 2s boundary ek peeche
                // mid++ NAHI karenge! high se aaya element abhi unseen hai
            }
        }
    }

    public static void main(String[] args) {

        // Test 1: Mixed elements
        int[] arr1 = {2, 0, 2, 1, 1, 0};
        sortColors(arr1);
        System.out.print("Test 1: ");
        printArray(arr1);            // Expected: [0, 0, 1, 1, 2, 2]

        // Test 2: Already sorted
        int[] arr2 = {0, 1, 2};
        sortColors(arr2);
        System.out.print("Test 2: ");
        printArray(arr2);            // Expected: [0, 1, 2]

        // Test 3: Reverse sorted
        int[] arr3 = {2, 1, 0};
        sortColors(arr3);
        System.out.print("Test 3: ");
        printArray(arr3);            // Expected: [0, 1, 2]

        // Test 4: Single element
        int[] arr4 = {0};
        sortColors(arr4);
        System.out.print("Test 4: ");
        printArray(arr4);            // Expected: [0]
    }

    // Helper: array print karo
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
