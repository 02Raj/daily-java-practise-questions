package Algorithm.slidingwindow.fixed;

public class AverageOfSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        double[] result = new double[arr.length - k + 1];

        // Step 1: first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        result[0] = (double) windowSum / k;

        // Step 2: slide window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];

            result[i - k + 1] = (double) windowSum / k; //
        }

        // print result
        for (double avg : result) {
            System.out.println(avg);
        }
    }
}