package stack;


import java.util.Stack;

/**
 * Question: Sum of Subarray Minimums (LeetCode 907)
 *
 * Statement:
 * -------------
 * Given an array arr of integers, find the sum of min(b),
 * where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo (1e9+7).
 *
 * Example:
 * --------
 * Input: arr = [3,1,2,4]
 * Subarrays = [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]
 * Minimums =   3,   1,   2,   4,    1,     1,     2,       1,      1,         1
 * Sum = 17
 *
 * --------------------------------------------------------
 * Approaches:
 * --------------------------------------------------------
 * 1. Brute Force:
 *    - Generate all subarrays O(n^2)
 *    - For each subarray, find minimum O(n)
 *    - Total = O(n^3) → Too slow (n <= 30,000)
 *
 * 2. Optimal (Monotonic Stack):
 *    - Key Trick: Every element arr[i] contributes as "minimum"
 *                 for some subarrays → Count its contribution directly.
 *
 *    Formula:
 *    --------
 *    For each element arr[i]:
 *       d1 = i - NSL[i]   (distance to Next Smaller Left)
 *       d2 = NSR[i] - i   (distance to Next Smaller Right)
 *       totalWays = d1 * d2
 *       contribution = arr[i] * totalWays
 *
 *    Sum = Σ contribution % (1e9+7)
 *
 *    Complexity = O(n)
 *    - Because each element is pushed + popped only once in stack.
 */

public class sumSubarrayMins {

    // -------------------------------------------------
    // Brute Force Approach (for understanding only)
    // -------------------------------------------------
    public static int bruteForce(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int M = 1000000007;

        // All subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minVal = arr[i];
                // find min in arr[i..j]
                for (int k = i; k <= j; k++) {
                    minVal = Math.min(minVal, arr[k]);
                }
                sum = (sum + minVal) % M;
            }
        }
        return (int) sum;
    }

    // -------------------------------------------------
    // Optimal Approach (Monotonic Stack)
    // -------------------------------------------------

    // Find NSL (Next Smaller to Left) indexes
    private static int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop until strictly smaller is found
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    // Find NSR (Next Smaller to Right) indexes
    private static int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop until strictly smaller OR equal is found
            // (to avoid double counting equal elements)
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public static int optimal(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long d1 = i - NSL[i];    // distance to left smaller
            long d2 = NSR[i] - i;    // distance to right smaller
            long totalWays = d1 * d2;
            long contribution = (arr[i] * totalWays) % M;
            sum = (sum + contribution) % M;
        }

        return (int) sum;
    }

    // -------------------------------------------------
    // Driver Code
    // -------------------------------------------------
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        System.out.println("Brute Force Answer : " + bruteForce(arr)); // O(n^3)
        System.out.println("Optimal Answer     : " + optimal(arr));    // O(n)
    }
}

