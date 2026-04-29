package striver_sde_sheet.array;

import java.util.HashMap;

/*
===========================================================
🧩 Problem: Two Sum
===========================================================
🔗 LeetCode: https://leetcode.com/problems/two-sum/
📅 Solved On: 16-04-2025
🔁 Revision Due: 23-04-2025
===========================================================

📝 Problem Statement:
Given an integer array nums and an integer target,
return indices of the two numbers that add up to target.
Exactly one solution exists. Same element cannot be used twice.

Example:
Input:  nums = [2,7,11,15], target = 9   →  Output: [0,1]
        (nums[0] + nums[1] = 2 + 7 = 9)
Input:  nums = [3,2,4], target = 6       →  Output: [1,2]
Input:  nums = [3,3], target = 6         →  Output: [0,1]

===========================================================
💡 APPROACH 1 — HashMap (Optimal)
===========================================================

🧠 Intuition:
→ Brute force mein hum har pair check karte — O(n²)
→ Better idea: agar mujhe pata ho ki mujhe kya chahiye (complement),
  toh kya main pehle se store kar sakta hoon jo dekha hai?
→ HashMap exactly yahi karta hai — O(1) lookup mein batata hai
  ki complement pehle aaya tha ya nahi

Main Idea:
→ Har element pe ek sawaal poochho:
  "Mera complement (target - num) kya pehle aa chuka hai?"
→ Haan → answer mil gaya, indices return karo
→ Nahi → apne aap ko map mein store karo {num → index}

Step 1: complement = target - nums[i] nikalo
Step 2: map mein check karo → containsKey(complement)?
Step 3: Haan → return {map.get(complement), i}
        Nahi → map.put(nums[i], i) karke aage badho

⚠️ Key Trick:
→ PEHLE check karo, PHIR put karo
→ Agar pehle put karo toh [3,3] target=6 mein
  same index do baar return ho sakta hai (bug!)

-----------------------------------------------------------
🔁 Dry Run — HashMap: nums = [2, 7, 11, 15], target = 9
-----------------------------------------------------------

i  | num | complement | map has it? | Action          | map state
---|-----|------------|-------------|-----------------|------------------
0  |  2  |   9-2=7    |     No      | store {2:0}     | {2:0}
1  |  7  |   9-7=2    |     YES!    | return [0, 1]   | ✅ Done

👉 Answer: [0, 1]   (nums[0]+nums[1] = 2+7 = 9)

-----------------------------------------------------------
⏱ Time Complexity (TC) — HashMap:

→ Ek hi loop, har element ek baar process hota hai → O(n)
→ HashMap lookup & insert → O(1) average

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC) — HashMap:

→ Extra HashMap store kar raha hai worst case n elements

👉 SC = O(n)

===========================================================
💡 APPROACH 2 — Two Pointer
===========================================================

🧠 Intuition:
→ Sorted array mein ek smart observation:
  - L + R > target → R ko left laao (sum chota karo)
  - L + R < target → L ko right laao (sum bada karo)
  - L + R = target → answer!
→ Ye "squeeze" technique sirf sorted array pe kaam karti hai

⚠️ Problem with this approach here:
→ Sort karne se ORIGINAL INDICES kho jaate hain
→ Indices track karne ke liye extra array chahiye
→ Isliye LeetCode Two Sum pe HashMap preferred hai
→ Two Pointer tab use karo jab array pehle se sorted ho
   aur sirf values chahiye (indices nahi)

Step 1: Indices array banao {0,1,2,...n-1}
Step 2: Indices ko nums values ke hisaab se sort karo
Step 3: L=0, R=n-1 se shuru karo
Step 4: sum check karo aur L/R move karo accordingly

-----------------------------------------------------------
🔁 Dry Run — Two Pointer: nums = [3, 2, 4], target = 6
-----------------------------------------------------------

After sorting by value → indices[] = [1, 0, 2]
                          values    =  2  3  4

L  | R  | nums[L] | nums[R] | sum | Action
---|-----|---------|---------|-----|--------
1  |  2  |    2    |    4    |  6  | = target ✅

👉 Answer: [indices[0], indices[2]] = [1, 2]

-----------------------------------------------------------
⏱ Time Complexity (TC) — Two Pointer:

→ Sorting  → O(n log n)
→ Two pointer loop → O(n)

👉 Final TC = O(n log n)   ← HashMap se slow

-----------------------------------------------------------
📦 Space Complexity (SC) — Two Pointer:

→ Extra indices[] array → O(n)

👉 SC = O(n)

-----------------------------------------------------------
🧠 Key Points (Must Remember):
[ ] HashMap mein PEHLE check, PHIR put — warna same index bug
[ ] map mein {num → index} store hota hai, na ki {index → num}
[ ] Two Pointer sirf sorted array pe kaam karta hai
[ ] LeetCode Two Sum pe HashMap best hai — unsorted + indices both needed
[ ] complement = target - nums[i] — yahi core idea hai
[ ] [3,3] target=6 edge case → map.get(3) = 0, current i = 1 → [0,1] ✅

-----------------------------------------------------------
🆚 Comparison:

Approach      | TC         | SC   | Works on unsorted? | Gives indices?
--------------|------------|------|--------------------|-----------------
HashMap       | O(n)       | O(n) | ✅ Yes             | ✅ Yes
Two Pointer   | O(n log n) | O(n) | ❌ No (needs sort) | ⚠️ Extra tracking

===========================================================
*/

public class TwoSum {

    // =========================================================
    // APPROACH 1: HashMap — O(n) TC | O(n) SC
    // =========================================================
    public static int[] twoSumHashMap(int[] nums, int target) {

        // {num → uska index} store karta hai
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Mujhe kya chahiye?
            int complement = target - nums[i];

            // Kya wo pehle aa chuka hai?
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Nahi aaya — khud ko future ke liye store karo
            // NOTE: put BAAD mein — warna [3,3] jaisi cases mein bug
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // Problem guarantees solution exists
    }

    // =========================================================
    // APPROACH 2: Two Pointer — O(n log n) TC | O(n) SC
    // =========================================================
    public static int[] twoSumTwoPointer(int[] nums, int target) {

        int n = nums.length;

        // Original indices track karo — sort ke baad bhi mile
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        // nums ke values ke hisaab se indices sort karo
        java.util.Arrays.sort(indices, (a, b) -> nums[a] - nums[b]);

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = nums[indices[left]] + nums[indices[right]];

            if (sum == target) {
                return new int[]{indices[left], indices[right]};

            } else if (sum < target) {
                left++;   // Sum chota → left aage badhao

            } else {
                right--;  // Sum bada → right peeche laao
            }
        }

        return new int[]{-1, -1};
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        // Test 1: Basic case
        int[] arr1 = {2, 7, 11, 15};
        System.out.print("Test 1 HashMap:      "); printResult(twoSumHashMap(arr1, 9));    // [0,1]
        System.out.print("Test 1 Two Pointer:  "); printResult(twoSumTwoPointer(arr1, 9)); // [0,1]

        // Test 2: Answer not at start
        int[] arr2 = {3, 2, 4};
        System.out.print("Test 2 HashMap:      "); printResult(twoSumHashMap(arr2, 6));    // [1,2]
        System.out.print("Test 2 Two Pointer:  "); printResult(twoSumTwoPointer(arr2, 6)); // [1,2]

        // Test 3: Duplicate elements — tricky edge case
        int[] arr3 = {3, 3};
        System.out.print("Test 3 HashMap:      "); printResult(twoSumHashMap(arr3, 6));    // [0,1]
        System.out.print("Test 3 Two Pointer:  "); printResult(twoSumTwoPointer(arr3, 6)); // [0,1]
    }

    private static void printResult(int[] res) {
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}