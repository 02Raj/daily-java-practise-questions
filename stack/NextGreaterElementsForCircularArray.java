package stack;

import java.util.Stack;

public class NextGreaterElementsForCircularArray {
    /**
     * ✅ PROBLEM STATEMENT:
     * Given a CIRCULAR array, find the Next Greater Element (NGE) for each element.
     * - Circular means: after the last element, wrap around to the start.
     * - If no greater element exists, return -1.
     *
     * Example:
     * Input:  [4, 5, 2, 25]
     * Output: [5, 25, 25, -1]
     *
     * Explanation:
     * - For 4 → next greater is 5
     * - For 5 → next greater is 25
     * - For 2 → next greater is 25 (wraps around)
     * - For 25 → no greater → -1
     */

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>(); // stack stores candidates for NGE

        // Step 0: Initialize answer with -1
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
        }

        // 👉 Step 1: Traverse array TWICE (simulate circular behavior)
        // i ranges from (2n - 1) down to 0
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n]; // %n ensures wrap-around

            // Step 2: Pop smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            // Step 3: Fill answer only in FIRST pass (i < n)
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Step 4: Push current element (for future comparisons)
            stack.push(curr);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] result = nextGreaterElement(arr);

        System.out.print("Next Greater Elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 5 25 25 -1
    }
}

/**
 * 📖 INTUITION / STORY:
 * - Normal NGE only looks to the right.
 * - For circular, after the end we must wrap back to start.
 * - Trick: Imagine array repeated twice (linearizing the circle).
 * - Traverse 2n times from right → left.
 * - Use %n to map index back to original array.
 *
 * 🎯 APPROACH:
 * 1. Traverse from right to left, 2*n times.
 * 2. Use stack (monotonic decreasing).
 * 3. For i < n (first pass), store result.
 * 4. Use %n for circular indexing.
 *
 * 🔑 TRICK:
 * - Simulate circular array by traversing array twice.
 * - Fill answers only in first pass.
 *
 * ⏱ TIME COMPLEXITY:
 * - O(n), because each element is pushed and popped at most once
 *   (even though we loop 2n times).
 *
 * 🗂 SPACE COMPLEXITY:
 * - O(n), for stack + result array.
 */
