package stack;

import java.util.Stack;

public class NextGreaterElement {

    // ✅ Problem Statement:
    // Given an array, for each element find the next greater element (NGE) on its right.
    // If no such element, return -1.
    //
    // Example:
    // Input: [4, 5, 2, 25]
    // Output: [5, 25, 25, -1]

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 👉 Traverse from RIGHT to LEFT (reverse)
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];

            // Step 1: Pop all smaller or equal elements (they can't be NGE)
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Step 2: If stack empty → no greater element on right → -1
            // Else → top of stack is the next greater
            nge[i] = stack.isEmpty() ? -1 : stack.peek();

            // Step 3: Push current element for future reference
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
    }
}
