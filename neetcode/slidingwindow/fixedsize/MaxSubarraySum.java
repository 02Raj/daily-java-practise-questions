package neetcode.slidingwindow.fixedsize;

public class MaxSubarraySum {

    public int maxSum(int[] arr, int k) {
        int windowSum = 0;
        int left = 0;
        int right = 0;
        int maxSum = 0;

        while(right < arr.length){
            windowSum += arr[right];

            if(right - left + 1 == k){
                maxSum = Math.max(maxSum,windowSum);
                windowSum -= arr[left];
                left++;
            }

            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        MaxSubarraySum obj = new MaxSubarraySum();
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + obj.maxSum(arr, k));
    }
}