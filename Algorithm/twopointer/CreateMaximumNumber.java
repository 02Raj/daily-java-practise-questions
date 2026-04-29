package Algorithm.twopointer;

import java.util.Arrays;

/*
===========================================================
🧩 Problem: Create Maximum Number
===========================================================
🔗 LeetCode: https://leetcode.com/problems/create-maximum-number/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
Do arrays se k digits lo → maximum number banao
Order maintain karna zaroori hai!

Example:
nums1=[3,4,6,5], nums2=[9,1,2,5,8,3], k=5
Output: [9,8,6,5,3]

-----------------------------------------------------------
💡 Approach: Split + Best + Merge

Step 1: Saare splits try karo
        (nums1 se i, nums2 se k-i)
Step 2: Har array se best digits nikalo
        (Monotonic stack — chhota hatao bade ke liye)
Step 3: Dono merge karo
        (Bada pehle aaye)
Step 4: Sabse bada candidate = answer!

-----------------------------------------------------------
🧠 Key Ideas:
→ canRemove = kitne hata sakte hain
→ Stack ka top chhota hai current se → hatao!
→ Merge mein equal hone pe puri array compare karo
→ isGreater → lexicographic comparison

-----------------------------------------------------------
🔁 Dry Run: nums1=[3,4,6,5], k=2

canRemove = 4-2 = 2
digit=3: stack=[3]
digit=4: 3<4 → hatao! stack=[4] canRemove=1
digit=6: 4<6 → hatao! stack=[6] canRemove=0
digit=5: canRemove=0 → stack=[6,5]

Best 2 = [6,5] ✅

-----------------------------------------------------------
⏱ TC: O(k×(m+n))   📦 SC: O(k)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] canRemove kyun = length - k?
[ ] Stack ka top hatane ka reason?
[ ] Merge mein equal pe kya karte hain?
[ ] Dry run: nums1=[3,4,6,5], k=3
[ ] Saare splits kyun try karte hain?

===========================================================
*/

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1,
                           int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        // Abhi tak ka sabse bada candidate
        int[] best = new int[k];

        // Saare possible splits try karo
        // nums1 se i digits, nums2 se k-i digits
        for (int i = Math.max(0, k - n);
             i <= Math.min(k, m); i++) {

            // Step 1: Dono arrays se best digits nikalo
            int[] part1 = maxFromOne(nums1, i);
            int[] part2 = maxFromOne(nums2, k - i);

            // Step 2: Dono ko merge karo
            int[] candidate = merge(part1, part2);

            // Step 3: Abhi tak ke best se compare karo
            if (isGreater(candidate, 0, best, 0)) {
                best = candidate;
                // Naya best mila!
            }
        }
        return best;
    }

    // Ek array se best k digits nikalo
    // Chhota hatao bade ke liye! (Monotonic Stack)
    private int[] maxFromOne(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0;

        // Kitne digits hata sakte hain
        int canRemove = nums.length - k;

        for (int digit : nums) {

            // Chhota top aur bada digit aaya?
            // Top ko hatao!
            while (top > 0
                    && canRemove > 0
                    && stack[top - 1] < digit) {
                top--;        // Top hatao
                canRemove--;  // Ek hataya
            }

            if (top < k) {
                // Stack mein jagah hai → daalo
                stack[top++] = digit;
            } else {
                // Stack full → skip karo
                // Skip = hatane jaisa
                canRemove--;
            }
        }
        return stack;
    }

    // Dono arrays merge karo — bada pehle!
    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, idx = 0;

        while (i < a.length && j < b.length) {
            // Kaun bada hai? Woh pehle aayega
            if (isGreater(a, i, b, j)) {
                res[idx++] = a[i++]; // a bada
            } else {
                res[idx++] = b[j++]; // b bada
            }
        }

        // Jo bacha copy karo
        while (i < a.length) res[idx++] = a[i++];
        while (j < b.length) res[idx++] = b[j++];

        return res;
    }

    // a[i...] > b[j...] hai?
    // Equal hone pe aage dekho!
    private boolean isGreater(int[] a, int i,
                              int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) return true;  // a bada
            if (a[i] < b[j]) return false; // b bada
            i++; j++; // Equal → aage dekho
        }
        // a zyada lamba → a bada!
        return i < a.length;
    }

    public static void main(String[] args) {
        CreateMaximumNumber sol = new CreateMaximumNumber();

        // Test 1: Classic case
        System.out.print("Test 1: ");
        System.out.println(Arrays.toString(sol.maxNumber(
                new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3},
                5
        ))); // Expected: [9,8,6,5,3]

        // Test 2: Dono arrays se sab lo
        System.out.print("Test 2: ");
        System.out.println(Arrays.toString(sol.maxNumber(
                new int[]{6, 7},
                new int[]{6, 0, 4},
                5
        ))); // Expected: [6,7,6,0,4]

        // Test 3: Simple case
        System.out.print("Test 3: ");
        System.out.println(Arrays.toString(sol.maxNumber(
                new int[]{3, 9},
                new int[]{8, 9},
                3
        ))); // Expected: [9,8,9]
    }
}