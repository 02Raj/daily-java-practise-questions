package stack;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {

    /**
     * ✅ PROBLEM STATEMENT:
     * - Given an array arr[] and an integer k (window size).
     * - A sliding window of size k moves from left to right.
     * - For each window, return the maximum element inside it.
     *
     * Example:
     * Input:  [1, 3, -1, -3, 5, 3, 6, 7], k = 3
     * Output: [3, 3, 5, 5, 6, 7]
     *
     * --------------------------------------------------------
     * 📖 INTUITION / STORY:
     * - Brute Force: Har window ke k elements check karke max nikal lo (O(n*k)).
     * - Better: Use Next Greater Element (NGE) preprocessing:
     *   1. Har index ke liye uske next greater element ka index precompute karo.
     *   2. Window ke andar max dhoondhne ke liye jump karte raho using NGE.
     *
     * --------------------------------------------------------
     * 🎯 APPROACH (Using NGE):
     * Step 1: Create NGE array
     *   - Traverse from right to left, monotonic stack maintain karo.
     *   - nge[i] = index of next greater element to the right of i
     *   - Agar koi greater nahi mila toh nge[i] = n (array end).
     *
     * Step 2: Process each sliding window
     *   - Maintain pointer j = index of maximum inside current window.
     *   - Ensure j is always inside the window.
     *   - While nge[j] is still inside window, jump j = nge[j].
     *   - Answer for current window = arr[j].
     *
     * --------------------------------------------------------
     * 🔑 TRICKS:
     * - Precompute NGE once → each element jumps only forward.
     * - j pointer never moves backwards, so total work is O(n).
     *
     * --------------------------------------------------------
     * ⏱ TIME COMPLEXITY:
     * - O(n) → Each index pushed/popped from stack once + each index jumped once.
     *
     * 🗂 SPACE COMPLEXITY:
     * - O(n) → NGE array + stack.
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = arr.length;

        // Step 1: NGE array banao
        int[] nge = new int[n];
        Arrays.fill(nge, n); // default: agar koi next greater nahi mila toh end (n)

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop all smaller/equal elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            // If stack not empty → top is next greater index
            if (!st.isEmpty()) {
                nge[i] = st.peek();
            }
            // Push current index
            st.push(i);
        }

        // Step 2: Sliding window maximum calculate karo
        int[] ans = new int[n - k + 1];
        int j = 0; // pointer to current window max

        for (int i = 0; i <= n - k; i++) {
            // Move j inside current window if it has fallen out
            if (j < i) {
                j = i;
            }

            // Keep jumping to next greater within window
            while (nge[j] < i + k) {
                j = nge[j];
            }

            // Window ka maximum
            ans[i] = arr[j];
        }

        // Print answer
        System.out.println("Sliding Window Maximum (NGE approach): " + Arrays.toString(ans));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
