package stack;

import java.util.*;

/**
 * Problem: Sliding Window Maximum
 * --------------------------------
 * Question:
 *  - You are given an integer array nums, and an integer k (window size).
 *  - There is a sliding window of size k moving from left to right.
 *  - At each step, return the maximum in the current window.
 *
 * Example:
 * nums = [1,3,-1,-3,5,3,6,7], k=3
 * Output = [3,3,5,5,6,7]
 *
 * --------------------------------------------------------
 * 🔹 Intuition
 * 1. Brute Force:
 *    - Har window ke liye manually max nikaalo.
 *    - Simple hai but har baar puri window traverse karni padti hai.
 *
 * 2. Optimal (Deque / Monotonic Queue):
 *    - Har window heavily overlap karti hai.
 *    - Har step me puri window scan karna waste hai.
 *    - Deque use karke hamesha decreasing order maintain karo,
 *      taaki front pe hamesha max rahe.
 *
 * --------------------------------------------------------
 * 🔹 Time & Space Complexity Analysis
 *
 * Brute Force:
 * - Outer loop: (n - k + 1) windows ≈ O(n)
 * - Inner loop: har window ke k elements scan ≈ O(k)
 * - Total = O(n * k)
 * - Space = O(1) (extra space nahi lagta, sirf result array)
 *
 * Optimal (Deque):
 * - Har element max 1 baar insert aur 1 baar remove hota hai → O(n)
 * - Deque size max k hi ho sakti hai
 * - Time = O(n)
 * - Space = O(k)
 *
 * --------------------------------------------------------
 * 🔹 TC / SC calculation logic (important for revision)
 * - Brute Force:
 *   #windows = n-k+1 ≈ O(n)
 *   per window scan = k
 *   Total work = (n-k+1) * k = O(n*k)
 *
 * - Optimal:
 *   Each index added once + removed once = O(2n) ≈ O(n)
 *   Deque max k size = O(k)
 */

public class MaxSlidingWindow {

    /**
     * --------------------------------
     * 1️⃣ Brute Force Approach
     * --------------------------------
     */
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // For each window of size k
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;

            // Traverse the k elements inside this window
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            // Store max for this window
            result[i] = max;
        }

        return result;
    }

    /**
     * --------------------------------
     * 2️⃣ Optimal Approach (Deque)
     * --------------------------------
     */
    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        Deque<Integer> deq = new LinkedList<>(); // will store indices
        int[] result = new int[n - k + 1];
        int ri = 0;

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of window
            while (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]) {
                deq.pollLast();
            }

            // 3. Insert current index
            deq.offerLast(i);

            // 4. Add to result (when window is complete)
            if (i >= k - 1) {
                result[ri++] = nums[deq.peekFirst()];
            }
        }

        return result;
    }

    /**
     * --------------------------------
     * 🔹 Main method for testing     *
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Test Brute Force
        System.out.println("Brute Force Output: " +
                Arrays.toString(maxSlidingWindowBruteForce(nums, k)));

        // Test Optimal
        System.out.println("Optimal (Deque) Output: " +
                Arrays.toString(maxSlidingWindowOptimal(nums, k)));
    }
}

