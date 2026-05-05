package Algorithm.slidingwindow.fixed;



public class MinSumSubarray {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 3, 5};
        int k = 3;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int minSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            minSum = Math.min(minSum, windowSum);
        }

        System.out.println("Min Sum: " + minSum);
    }
}