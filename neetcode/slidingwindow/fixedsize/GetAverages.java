package neetcode.slidingwindow.fixedsize;

import java.util.Arrays;

public class GetAverages {

    /**
     * Question: Given an array, calculate the average of each element with its k-radius neighbors.
     * If there are not enough elements on either side, place -1 at that position.
     *
     * Kya karna hai?
     * Har element ke liye uske left aur right mein 'k' elements ka average nikalna hai.
     * Agar k elements available nahi hai (starting or ending mein), to wahan -1 rakhna hai.
     */

    // Method to get k-radius averages using fixed-size sliding window
    public int[] getAveragesWithFixedWindow(int[] nums, int k) {
        int n = nums.length;

        // Q: Agar k = 0 ho to kya karein?
        // A: Tab koi radius nahi hai, sirf khud ka element hi average hoga. So, return original array.
        if (k == 0) {
            return nums;
        }

        // Result array same length ka bana rahe hain, jisme initially sab values -1 se fill karte hain
        // Kyun? Jahan valid average calculate nahi ho sakta wahan default value -1 chahiye
        int[] result = new int[n];
        Arrays.fill(result, -1);  // All elements initialized with -1

        // Sliding window size = 2k + 1
        int windowSize = 2 * k + 1;

        // Q: Agar input array ki length window size se chhoti ho to?
        // A: Koi bhi full window ban hi nahi sakta, to return result as it is (filled with -1)
        if (n < windowSize) {
            return result;
        }

        long windowSum = 0;

        // Pehle window ka sum calculate karte hain: nums[0] to nums[windowSize - 1]
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        // First valid average ka index hoga 'k', kyunki uske left aur right mein k elements honge
        result[k] = (int) (windowSum / windowSize);

        // Ab window ko slide karte hain aage ki taraf
        for (int right = windowSize; right < n; right++) {
            int cameToWindow = nums[right];                      // New element jo window mein aa gaya
            int outOfWindow = nums[right - windowSize];          // Old element jo window se nikal gaya

            // Window sum update: new aaya + old gaya
            windowSum = windowSum + cameToWindow - outOfWindow;

            // New average store karo jiska center hoga (right - k)
            result[right - k] = (int) (windowSum / windowSize);
        }

        return result;
    }

    // Main method to test our logic
    public static void main(String[] args) {
        GetAverages ga = new GetAverages();
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};  // Sample input
        int k = 3;                                 // Radius

        // Function call and result print
        int[] result = ga.getAveragesWithFixedWindow(nums, k);
        System.out.println(Arrays.toString(result));  // Expected output: [-1, -1, -1, 5, 4, 4, -1, -1, -1]
    }
}
