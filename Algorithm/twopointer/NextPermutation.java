package Algorithm.twopointer;

/*
===========================================================
🧩 Problem: Next Permutation
===========================================================
🔗 LeetCode: https://leetcode.com/problems/next-permutation/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
Array ki next permutation find karo.
Next permutation = thoda bada arrangement.
Agar last permutation hai toh first pe wrap karo.
In-place modify karo!

Example:
Input:  [1,2,3]   →  Output: [1,3,2]
Input:  [3,2,1]   →  Output: [1,2,3]  (wrap around!)
Input:  [1,1,5]   →  Output: [1,5,1]

-----------------------------------------------------------
💡 Approach: 3 Steps

Step 1: Peeche se "dip" dhundo
        nums[i] < nums[i+1] wala pehla i

Step 2: Dip element se bada dhundo
        Peeche se pehla j jahan nums[j] > nums[i]

Step 3: Swap + Reverse
        nums[i] aur nums[j] swap karo
        i+1 se end tak reverse karo

-----------------------------------------------------------
🧠 Key Ideas:
→ Dip = chhota element jo increase hoga
→ j = usse thoda bada (peeche se pehla)
→ Reverse kyun? Descending tha → ascending karo
→ All descending = last permutation → poora reverse

-----------------------------------------------------------
🔁 Dry Run: [1, 3, 2]

Step 1: Dip dhundo (peeche se)
  i=1: nums[1]=3 >= nums[2]=2 → aage badho
  i=0: nums[0]=1 < nums[1]=3 ✅ → i=0

Step 2: j dhundo (peeche se bada)
  j=2: nums[2]=2 > nums[0]=1 ✅ → j=2

Step 3: Swap + Reverse
  Swap i=0, j=2: [2, 3, 1]
  Reverse i+1=1 to end: [2, 1, 3]

👉 Answer: [2,1,3] ✅

-----------------------------------------------------------
🔁 Dry Run: [3,2,1] (Last permutation)

Step 1: Dip dhundo
  i=1: 2 >= 1 → aage
  i=0: 3 >= 2 → aage
  i=-1: Loop band! i=-1

Step 2: i<0 → skip!

Step 3: Reverse poora array
  [3,2,1] → [1,2,3]

👉 Answer: [1,2,3] ✅ (wrap around!)

-----------------------------------------------------------
⏱ TC: O(n)   📦 SC: O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Dip kyun dhundte hain peeche se?
[ ] j peeche se kyun dhundte hain?
[ ] Reverse kyun karte hain i+1 se?
[ ] [3,2,1] mein kya hoga?
[ ] Dry run: [1,2,3] → expected [1,3,2]
[ ] Dry run: [1,5,1] → expected [1,1,5]

===========================================================
*/

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // ─────────────────────────────────────
        // Step 1: Peeche se "dip" dhundo
        // nums[i] < nums[i+1] wala pehla i
        // ─────────────────────────────────────
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i = -1 matlab poora array descending tha
        // e.g. [3,2,1] → last permutation!

        // ─────────────────────────────────────
        // Step 2: i mila toh j dhundo
        // Peeche se pehla j jahan nums[j] > nums[i]
        // ─────────────────────────────────────
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap karo i aur j
            swap(nums, i, j);
        }

        // ─────────────────────────────────────
        // Step 3: i+1 se end tak reverse karo
        // Descending tha → ascending banao
        // Smallest tail chahiye!
        // ─────────────────────────────────────
        reverse(nums, i + 1, n - 1);
    }

    // Helper: Swap
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Helper: Reverse
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();

        // Test 1: Simple case
        int[] arr1 = {1, 2, 3};
        sol.nextPermutation(arr1);
        System.out.print("Test 1: ");
        System.out.println(java.util.Arrays.toString(arr1));
        // Expected: [1, 3, 2]

        // Test 2: Last permutation → wrap around
        int[] arr2 = {3, 2, 1};
        sol.nextPermutation(arr2);
        System.out.print("Test 2: ");
        System.out.println(java.util.Arrays.toString(arr2));
        // Expected: [1, 2, 3]

        // Test 3: Middle case
        int[] arr3 = {1, 3, 2};
        sol.nextPermutation(arr3);
        System.out.print("Test 3: ");
        System.out.println(java.util.Arrays.toString(arr3));
        // Expected: [2, 1, 3]

        // Test 4: Duplicates
        int[] arr4 = {1, 1, 5};
        sol.nextPermutation(arr4);
        System.out.print("Test 4: ");
        System.out.println(java.util.Arrays.toString(arr4));
        // Expected: [1, 5, 1]

        // Test 5: Single element
        int[] arr5 = {1};
        sol.nextPermutation(arr5);
        System.out.print("Test 5: ");
        System.out.println(java.util.Arrays.toString(arr5));
        // Expected: [1]
    }
}