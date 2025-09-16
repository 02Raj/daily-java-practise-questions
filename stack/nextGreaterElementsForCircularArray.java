package stack;

import java.util.Stack;

public class nextGreaterElementsForCircularArray {
    // ✅ Problem Statement:
    // Given a circular array, find the next greater element for each element.
    // Circular means after the last element, wrap around to the start.
    //
    // Example:
    // Input: [4, 5, 2, 25]
    // Output: [5, 25, 25, -1]

    public static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize result with -1
        for (int i = 0; i < n; i++){
            nge[i] = -1;
        }

        // 👉 Trick: Traverse array TWICE (simulate circular)
        for (int i = 2 * n - 1; i >= 0; i--){
            int curr = arr[i % n];  // i % n → wrap around index

            // Pop smaller elements
            while(!stack.isEmpty() && stack.peek() <= curr){
                stack.pop();
            }

            // Fill answer only in FIRST pass (i < n)
            if (i < n){
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Push current for future
            stack.push(curr);
        }
        return  nge;
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