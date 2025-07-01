package neetcode.slidingwindow.variablesize;
/*
🔍 Problem Statement:
You're given an array `nums` of positive integers and an integer `k`.

🎯 Goal:
Find the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`.

🧪 Example:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation:
The 8 subarrays that have product < 100 are:
[10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]
*/

/*
🧠 Approach (Sliding Window):
- Since all elements are positive, if product becomes >= k, we can shrink window from left.
- Keep a running product, and use two pointers (left & right) to maintain a valid window.
- At each step, number of subarrays ending at `right` = (right - left + 1)
*/

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // 📛 Since product of any positive number will be ≥ 1

        int prod = 1;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            // ❌ Shrink window until product is less than k
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }

            // ✅ All subarrays ending at `right` and starting from `left` are valid
            count += (right - left + 1);
        }

        return count;  // 🎯 Total number of valid subarrays
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK solver = new NumSubarrayProductLessThanK();

        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int result = solver.numSubarrayProductLessThanK(nums, k);
        System.out.println("Number of valid subarrays: " + result);  // Output: 8
    }
}
