package stack;

import java.util.Stack;

public class NextGreaterElement {

    /**
     * ✅ PROBLEM STATEMENT:
     * Given an array, for each element find the "Next Greater Element (NGE)" on its right.
     * If no such element exists, return -1.
     *
     * Example:
     * Input:  [4, 5, 2, 25]
     * Output: [5, 25, 25, -1]
     *
     * Meaning:
     * - For 4 → next greater is 5
     * - For 5 → next greater is 25
     * - For 2 → next greater is 25
     * - For 25 → no greater element → -1
     */

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];   // answer array
        Stack<Integer> stack = new Stack<>(); // stack will store "potential NGEs"

        // 👉 Traverse array from RIGHT to LEFT
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];

            // Step 1: Pop all smaller or equal elements
            // (they can never be NGE for current or any element to the left)
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Step 2: If stack empty → no NGE
            // Else → top of stack is the NGE
            nge[i] = stack.isEmpty() ? -1 : stack.peek();

            // Step 3: Push current element → may act as NGE for elements to the left
            stack.push(current);
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
 * - We want to find "next bigger number" on the right.
 * - If we go left to right, we don’t know future elements → tricky.
 * - If we go right to left:
 *      → we maintain a stack of "candidates for NGE".
 *      → before processing current element, remove all smaller/equal (useless).
 *      → top of stack (if any) is the next greater.
 *
 * 🎯 TRICK:
 * - Use stack to keep track of useful elements in decreasing order.
 * - Always traverse from right to left in NGE problems.
 *
 * 🔑 KEY POINTS:
 * - Pop until a strictly greater element remains.
 * - If no element → answer is -1.
 * - Stack ensures each element is pushed and popped at most once.
 *
 * ⏱ TIME COMPLEXITY:
 * - O(n) → each element pushed and popped at most once.
 *
 * 🗂 SPACE COMPLEXITY:
 * - O(n) → stack + answer array.
 */
