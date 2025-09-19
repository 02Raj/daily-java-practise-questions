package stack;

import java.util.Stack;

/**
 * Question: Sum of Subarray Ranges (LeetCode 2104)
 *
 * Problem Statement:
 * ------------------
 * Ek array nums diya hai. Har subarray ka "range" define hai as:
 *    range = (max element - min element)
 *
 * Task: Saare subarrays ke ranges ka sum return karo.
 *
 * Example:
 * --------
 * Input: [1,2,3]
 * Subarrays:
 *   [1] → max=1, min=1 → range=0
 *   [2] → 0
 *   [3] → 0
 *   [1,2] → 2-1=1
 *   [2,3] → 3-2=1
 *   [1,2,3] → 3-1=2
 * Answer = 4
 *
 * ---------------------------------------------------------
 * Approaches:
 * ---------------------------------------------------------
 * 1. Brute Force (O(n^2) - O(n^3)):
 *    - Har subarray generate karo
 *    - Uska max aur min nikal kar (max-min) add kar do
 *    - Time bahut slow ho jayega (n=10^5 possible)
 *
 * 2. Optimal Approach (O(n)):
 *    - Trick: Range = (sum of subarray maximums) - (sum of subarray minimums)
 *    - Har element ka contribution count karo as MIN aur as MAX
 *
 *    Formula:
 *    --------
 *    For each arr[i]:
 *       - As maximum: contribution = arr[i] * (left choices) * (right choices)
 *       - As minimum: contribution = arr[i] * (left choices) * (right choices)
 *
 *    Answer = (totalMaxContribution - totalMinContribution)
 *
 * WHY Stack?
 * ----------
 * - Humko har element ke left/right me "next smaller/greater" indices chahiye.
 * - Stack monotonic tarike se ye O(n) me dila deta hai.
 *
 * Intuition:
 * ----------
 * - Har element apna contribution karta hai jitne subarrays me wo min ya max hai.
 * - NSL/NSR → bataata hai ki element kitna stretch kar sakta hai as MIN
 * - NGL/NGR → bataata hai ki element kitna stretch kar sakta hai as MAX
 * - Multiply karke count nikal lo, phir arr[i] * count add/subtract kar do.
 */
public class SubarrayRanges {

    // ---------- Helper: Next Greater to Left ----------
    private static int[] getNGL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    // ---------- Helper: Next Greater to Right ----------
    private static int[] getNGR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek(); // right not found → n
            st.push(i);
        }
        return result;
    }

    // ---------- Helper: Next Smaller to Left ----------
    private static int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    // ---------- Helper: Next Smaller to Right ----------
    private static int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek(); // right not found → n
            st.push(i);
        }
        return result;
    }

    // ---------- Main Optimal Function ----------
    public static long subArrayRanges(int[] arr) {
        int n = arr.length;

        int[] NGL = getNGL(arr, n);
        int[] NGR = getNGR(arr, n);
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < n; i++) {
            // As MAX
            long leftGreater = i - NGL[i];
            long rightGreater = NGR[i] - i;
            maxSum += (long) arr[i] * leftGreater * rightGreater;

            // As MIN
            long leftSmaller = i - NSL[i];
            long rightSmaller = NSR[i] - i;
            minSum += (long) arr[i] * leftSmaller * rightSmaller;
        }

        return maxSum - minSum; // Ranges = MaxSum - MinSum
    }

    // ---------- Driver Code ----------
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 3, 3};
        int[] nums3 = {4, -2, -3, 4, 1};

        System.out.println("Example 1 Output: " + subArrayRanges(nums1)); // 4
        System.out.println("Example 2 Output: " + subArrayRanges(nums2)); // 4
        System.out.println("Example 3 Output: " + subArrayRanges(nums3)); // 59
    }
}
