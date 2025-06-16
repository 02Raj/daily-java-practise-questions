package neetcode.slidingwindow.fixedsize;


//Input: arr = [2, 1, 5, 1, 3, 2], k = 3
//Output: 9
//Explanation: Subarray [5,1,3] has the maximum sum 9

public class MaxSubarraySum {

    // Function to calculate max sum of any subarray of size k
    public int maxSum(int[] arr, int k) {
        int windowSum = 0; // Current window sum
        int left = 0;      // Left boundary of the window
        int right = 0;     // Right boundary of the window
        int maxSum = 0;    // Final answer

        // Loop until right pointer reaches end of array
        while (right < arr.length) {
            windowSum += arr[right]; // Add current element to window

            // Check if window size == k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum); // Update max sum
                windowSum -= arr[left];  // Shrink window from left
                left++; // Move left pointer
            }

            right++; // Expand window from right
        }

        return maxSum;
    }

    // Main method to run the test case
    public static void main(String[] args) {
        MaxSubarraySum obj = new MaxSubarraySum();
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        // Output: 9 -> [5, 1, 3]
        System.out.println("Maximum sum of subarray of size " + k + " is: " + obj.maxSum(arr, k));
    }
}