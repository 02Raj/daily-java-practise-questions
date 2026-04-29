package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Find the Duplicate Number
===========================================================
🔗 LeetCode: https://leetcode.com/problems/find-the-duplicate-number/
📅 Solved On: 14-04-2025
🔁 Revision Due: 21-04-2025
===========================================================

📝 Problem Statement:
n+1 integers ka array diya hai jisme har number
1 se n ke beech hai. Exactly ek number duplicate hai.
Woh duplicate number return karo.

Example:
Input:  nums = [1,3,4,2,2]  →  Output: 2
Input:  nums = [3,1,3,4,2]  →  Output: 3
Input:  nums = [3,3,3,3,3]  →  Output: 3

-----------------------------------------------------------
💡 Approach 1 (Brute Force — Sorting):

→ Array sort karo
→ Adjacent elements compare karo
→ Agar nums[i] == nums[i-1] → duplicate mil gaya

TC = O(n log n) | SC = O(1)
Problem: Array modify ho jaata hai

-----------------------------------------------------------
💡 Approach 2 (Better — HashSet):  ← Aaj solve kiya

Main idea:
→ Ek set banao — visited numbers track karne ke liye
→ Har element ko set mein add karne se pehle check karo
→ Agar pehle se set mein hai → yahi duplicate hai!

Step 1: Empty HashSet banao
Step 2: Loop chalao array pe
Step 3: Agar current element set mein already hai → return karo
Step 4: Warna set mein add karo, aage badho

TC = O(n) | SC = O(n)  ← extra set ki wajah se space laagti hai

-----------------------------------------------------------
💡 Approach 3 (Optimal — Floyd's Cycle Detection):

→ Array ko linked list ki tarah treat karo
→ nums[i] = next node ka index
→ Duplicate hone pe cycle banta hai
→ Slow aur fast pointer se cycle detect karo

TC = O(n) | SC = O(1)  ← Best approach!
(Revision ke liye mark karo — baad mein seekhna hai)

-----------------------------------------------------------
🔁 Dry Run (HashSet Approach): [1, 3, 4, 2, 2]

i  | nums[i] | set before      | action
---|---------|-----------------|-------------------------
0  |    1    | {}              | add 1 → set = {1}
1  |    3    | {1}             | add 3 → set = {1,3}
2  |    4    | {1,3}           | add 4 → set = {1,3,4}
3  |    2    | {1,3,4}         | add 2 → set = {1,3,4,2}
4  |    2    | {1,3,4,2}       | 2 already hai! → return 2

👉 Answer: 2 ✓

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass through array → O(n)
HashSet contains() aur add() → O(1) average

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

HashSet mein worst case n elements → O(n)

👉 SC = O(n)  ← Optimal approach (Floyd's) mein O(1) hota

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] HashSet ka contains() O(1) kyun hai?
[ ] Agar set ki jagah array use karo toh kya hoga? TC/SC?
[ ] Floyd's Cycle Detection kyun O(1) space leta hai?
[ ] Dry run: [3,1,3,4,2] → expected 3
[ ] Dry run: [3,3,3,3,3] → expected 3 (multiple duplicates)
[ ] Optimal approach (Floyd's) baad mein implement karna hai

===========================================================
*/

import java.util.HashSet;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {

        // Set banao visited numbers track karne ke liye
        // HashSet O(1) average time mein add aur lookup karta hai
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                // Pehle se set mein hai → yahi duplicate hai
                return nums[i];
            }

            // Pehli baar dekha → set mein add karo
            set.add(nums[i]);
        }

        // Problem guarantee karta hai duplicate hoga
        // yahan tak aana nahi chahiye
        return -1;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.print("Test 1: ");
        System.out.println(findDuplicate(arr1)); // Expected: 2

        // Test 2: Duplicate at different positions
        int[] arr2 = {3, 1, 3, 4, 2};
        System.out.print("Test 2: ");
        System.out.println(findDuplicate(arr2)); // Expected: 3

        // Test 3: All same elements
        int[] arr3 = {3, 3, 3, 3, 3};
        System.out.print("Test 3: ");
        System.out.println(findDuplicate(arr3)); // Expected: 3

        // Test 4: Duplicate at the end
        int[] arr4 = {1, 2, 3, 4, 4};
        System.out.print("Test 4: ");
        System.out.println(findDuplicate(arr4)); // Expected: 4
    }
}