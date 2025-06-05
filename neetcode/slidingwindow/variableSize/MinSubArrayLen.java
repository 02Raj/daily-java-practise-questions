package neetcode.slidingwindow.variableSize;

import java.util.Arrays;

public class MinSubArrayLen {

    /**
     * LeetCode: https://leetcode.com/problems/minimum-size-subarray-sum/
     *
     * Problem:
     * Ek array diya hai aur ek target.
     * Hume minimum length ka contiguous subarray chahiye jiska sum >= target ho.
     * Agar nahi milta to 0 return karo.
     *
     * Approach:
     * Variable Size Sliding Window
     * - Window ko expand karte hain jab tak sum < target ho.
     * - Jab sum >= target ho jaye to window ko shrink karte hain aur minimum length update karte hain.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE; // Initially max value

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // Window me right element include karo

            // Jab sum >= target ho jaye, to window ko shrink karo
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // Minimum length update
                sum -= nums[left]; // Window ka left element remove karo
                left++;            // Left ko aage badhao
            }
        }

        // Agar koi valid subarray nahi mila to 0 return karo
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen solver = new MinSubArrayLen();

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = solver.minSubArrayLen(target, nums);
        System.out.println("🔍 Minimum length of subarray with sum >= " + target + " is: " + result);
    }
}
