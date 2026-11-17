package frequently_asked_dsa.array;

import java.util.Arrays;

/*
 * LEETCODE 53 - MAXIMUM SUBARRAY (Medium)
 * ----------------------------------------
 *
 * PROBLEM STATEMENT:
 * Integer array nums mein se ek CONTIGUOUS (lagataar) subarray choose karo
 * jiska sum maximum ho, aur woh maximum sum return karo.
 *
 * Subarray empty nahi ho sakta: kam se kam ek element choose karna zaroori hai.
 *
 * Example:
 * nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Best subarray = [4, -1, 2, 1], sum = 6.
 *
 * =================================================================
 * SABSE IMPORTANT INTUITION - "NEGATIVE BAG KO KYON UTHAUN?"
 * =================================================================
 * Har index par decision:
 * - previous subarray ko extend karun, OR
 * - current number se fresh start karun?
 *
 * Formula:
 * currentSum = max(nums[i], currentSum + nums[i])
 *
 * Agar purana running sum current number ko help kar raha hai, carry karo.
 * Agar purana sum burden ban gaya hai, usko chhodkar current number se restart.
 *
 * maxSum har point tak mila overall best answer store karta hai.
 *
 * Memory line:
 *      "Past fayda de to saath lo; bojh bane to aaj se fresh start karo."
 *
 * =================================================================
 * APPROACH 1 - BRUTE FORCE
 * =================================================================
 * Har possible starting index se subarray grow karo aur running sum calculate
 * karke maximum update karo. Sirf contiguous elements include honge.
 *
 * Time Complexity  : O(n^2)
 * Space Complexity : O(1)
 *
 * (Agar har subarray ka sum third loop se nikala, woh O(n^3) version hoga.)
 *
 * =================================================================
 * APPROACH 2 - KADANE'S ALGORITHM (OPTIMIZED)
 * =================================================================
 * 1. currentSum = nums[0] -> current index par end hone wala best sum.
 * 2. maxSum = nums[0]     -> poore processed array ka best sum.
 * 3. Index 1 se start karke extend-vs-restart decision lo.
 * 4. Har step par maxSum update karo.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * =================================================================
 * USER CODE KA IMPORTANT EDGE-CASE FIX
 * =================================================================
 * Agar maxSum = 0 aur currentSum = 0 se start karke negative sum ko reset
 * karte hain, then all-negative input [-3,-2,-5] ka answer galat 0 aayega.
 * Empty subarray allowed nahi hai; correct answer -2 hona chahiye.
 *
 * Isliye currentSum aur maxSum ko nums[0] se initialize karna safest version
 * hai. Yeh positive, mixed aur all-negative tino cases handle karta hai.
 *
 * =================================================================
 * SMALL DRY RUN
 * =================================================================
 * nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * value | currentSum = max(value, currentSum+value) | maxSum
 *  -2   | -2                                        | -2
 *   1   | max(1, -1) = 1                           |  1  <- restart
 *  -3   | max(-3, -2) = -2                         |  1
 *   4   | max(4, 2) = 4                            |  4  <- restart
 *  -1   | max(-1, 3) = 3                           |  4
 *   2   | max(2, 5) = 5                            |  5
 *   1   | max(1, 6) = 6                            |  6
 *  -5   | max(-5, 1) = 1                           |  6
 *   4   | max(4, 5) = 5                            |  6
 *
 * Answer = 6.
 *
 * =================================================================
 * KEY TO REMEMBER ALWAYS
 * =================================================================
 * "Maximum Subarray = Kadane = har index par EXTEND ya RESTART."
 *
 * Common mistakes:
 * - maxSum = 0 rakhna, jis se all-negative case fail hota hai;
 * - subsequence samajhna (elements contiguous/saath-saath hone chahiye);
 * - currentSum aur maxSum ko same meaning samajhna;
 * - currentSum reset/update karna but maxSum update bhool jana;
 * - empty array assume karna (LeetCode constraint nums.length >= 1 hai).
 */
public class MaximumSubarray {

    /** O(n^2) brute-force learning version. */
    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum = nums[0];

        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;

            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    /** Optimized Kadane's algorithm - LeetCode submission method. */
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Previous sum ko extend karo ya current element se fresh start karo.
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Overall best answer ko update karo.
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /*
     * Important test categories: mixed values, one value, all positive,
     * all negative, zero, alternating values, and best subarray at the end.
     */
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        runTest(solution, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);
        runTest(solution, new int[]{1}, 1);
        runTest(solution, new int[]{5, 4, -1, 7, 8}, 23);
        runTest(solution, new int[]{-3, -2, -5}, -2);
        runTest(solution, new int[]{0}, 0);
        runTest(solution, new int[]{-2, 1}, 1);
        runTest(solution, new int[]{1, -2, 3, 4, -1}, 7);
        runTest(solution, new int[]{-5, 4, -1, 7, 8}, 18);

        System.out.println("All Maximum Subarray tests passed.");
    }

    private static void runTest(MaximumSubarray solution, int[] nums, int expected) {
        int optimizedActual = solution.maxSubArray(nums);
        int bruteForceActual = solution.maxSubArrayBruteForce(nums);

        if (optimizedActual != expected || bruteForceActual != expected) {
            throw new AssertionError(
                    "Failed for nums=" + Arrays.toString(nums)
                            + ", expected=" + expected
                            + ", optimized=" + optimizedActual
                            + ", bruteForce=" + bruteForceActual);
        }

        System.out.println("PASS nums=" + Arrays.toString(nums)
                + " -> " + optimizedActual);
    }
}
