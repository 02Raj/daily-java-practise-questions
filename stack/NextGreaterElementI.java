package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    /**
     * ✅ PROBLEM STATEMENT:
     * - nums1 is a subset of nums2.
     * - For each element in nums1, find the Next Greater Element (NGE) in nums2.
     * - If no greater element exists → return -1.
     *
     * Example:
     * nums1 = [4,1,2]
     * nums2 = [1,3,4,2]
     * Output = [-1, 3, -1]
     *
     * Explanation:
     * - For 4 → nums2 = [1,3,4,2], after 4 no bigger → -1
     * - For 1 → next greater in nums2 is 3
     * - For 2 → no bigger after it → -1
     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store NGE of every element in nums2
        Map<Integer, Integer> ngMap = new HashMap<>();
        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // 👉 Step 1: Traverse nums2 from RIGHT to LEFT
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            // Pop smaller/equal elements (useless for NGE)
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            // If stack empty → no NGE, else → top of stack is NGE
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            ngMap.put(curr, nextGreater);

            // Push current element for future reference
            stack.push(curr);
        }

        // 👉 Step 2: Lookup answers for nums1 using precomputed map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngMap.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.print("Result: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
        // Output: -1 3 -1
    }
}

/**
 * 📖 INTUITION / STORY:
 * - We want NGE for nums1 elements, but nums1 is a subset of nums2.
 * - Instead of recomputing for nums1, we preprocess nums2 using a stack
 *   and build a map {element → NGE}.
 * - Then, for nums1 we just do a lookup in O(1).
 *
 * 🎯 APPROACH:
 * 1. Traverse nums2 from right → left.
 * 2. Use a decreasing stack:
 *      - Pop all smaller/equal elements.
 *      - Top of stack (if any) = NGE.
 * 3. Store in HashMap for quick access.
 * 4. For nums1, just lookup answers.
 *
 * 🔑 TRICK:
 * - Stack ensures amortized O(1) per element.
 * - Map allows direct O(1) lookup for nums1.
 *
 * ⏱ TIME COMPLEXITY:
 * - O(n + m), where n = nums2.length, m = nums1.length.
 *   (Process nums2 in O(n), lookup for nums1 in O(m))
 *
 * 🗂 SPACE COMPLEXITY:
 * - O(n) for stack + hashmap.
 */
