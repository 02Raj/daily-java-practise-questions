package stack;

import java.util.Stack;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};   // Input array
        int[] result = nextGreaterElement(arr); // Function call

        System.out.print("Next Greater Elements: ");
        for (int val : result) {
            System.out.print(val + " "); // Print final result
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];  // Array to store results
        Stack<Integer> stack = new Stack<>(); // Stack to track "next greater candidates"

        // Traverse array from RIGHT to LEFT
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];  // Current element

            // 1. Pop all smaller (or equal) elements
            // Because they can't be "next greater" for current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // 2. Check result
            // If stack is empty → no greater element on right → put -1
            // Else → stack.top is the next greater
            nge[i] = stack.isEmpty() ? -1 : stack.peek();

            // 3. Push current element into stack
            // Because it might be "next greater" for future (left-side) elements
            stack.push(current);
        }
        return nge; // Return result array
    }
}
