package neetcode.slidingwindow.fixedsize;

import java.util.Arrays;

public class GetAverages {

    /**
     * Question:
     * Given an array of integers and a number k (radius),
     * For each element in the array, calculate the average of the element
     * and its k neighbors on both sides.
     *
     * If an element does not have enough k neighbors on either side,
     * then place -1 at that index.
     *
     * Example:
     * Input:
     * nums = [7, 4, 3, 9, 1, 8, 5, 2, 6]
     * k = 3
     *
     * Step by step:
     * - Index 0,1,2 → Not enough left neighbors → -1
     * - Index 3 → Window = [7,4,3,9,1,8,5] → Average = (7+4+3+9+1+8+5)/7 = 37/7 = 5
     * - Index 4 → Window = [4,3,9,1,8,5,2] → Average = (32)/7 = 4
     * - Index 5 → Window = [3,9,1,8,5,2,6] → Average = (34)/7 = 4
     * - Index 6,7,8 → Not enough right neighbors → -1
     *
     * Output:
     * [-1, -1, -1, 5, 4, 4, -1, -1, -1]
     *
     * Explanation of Output:
     * - First 3 and last 3 elements are -1 because k=3 neighbors are not available.
     * - Middle values are calculated averages as explained above.
     */

    // Method to get k-radius averages using fixed-size sliding window
    public int[] getAveragesWithFixedWindow(int[] nums, int k) {
        int n = nums.length;

        // Q: Agar k = 0 ho to kya karein?
        // A: Tab koi radius nahi hai, sirf khud ka element hi average hoga.
        //    Is case mein har element ka average wahi element hai.
        if (k == 0) {
            return nums;
        }

        // Q: Result array kyu banaya aur -1 se fill kyu kiya?
        // A: Har index ke liye ek answer chahiye. Jahan valid average nahi banega (start/end par),
        //    wahan -1 store karna hai. Isiliye Arrays.fill(result, -1).
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Q: Window size kya hota hai aur yahan kyu 2k+1 hai?
        // A: Har element ke liye left mein k + right mein k + khud element = 2k+1
        int windowSize = 2 * k + 1;

        // Q: Agar array length < windowSize ho to kya hoga?
        // A: Matlab kisi bhi element ke paas k left + k right elements available hi nahi honge.
        //    To answer sirf -1 hi rahega sab jagah.
        if (n < windowSize) {
            return result;
        }

        long windowSum = 0;

        // Q: Pehle window ka sum kyu calculate karna hai?
        // A: Kyunki sliding window ke liye base sum chahiye hota hai (nums[0]..nums[windowSize-1]).
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        // Q: Pehla valid average kis index par milega?
        // A: Index = k, kyunki uske left aur right mein k elements available hain.
        result[k] = (int) (windowSum / windowSize);

        // Q: Ab loop window slide karte hue kyu chal raha hai?
        // A: Har step pe ek naya element window mein enter karega (cameToWindow),
        //    aur ek purana element window se bahar nikal jaayega (outOfWindow).
        //    Window sum update karke naya average calculate karenge.
        for (int right = windowSize; right < n; right++) {
            int cameToWindow = nums[right];             // New element add ho raha hai
            int outOfWindow = nums[right - windowSize]; // Old element remove ho raha hai

            // Q: Window sum update kyu kar rahe hain?
            // A: Pehle total sum mein se old hatao, naya add karo.
            windowSum = windowSum + cameToWindow - outOfWindow;

            // Q: Naya average kis index par place hoga?
            // A: Har baar center = right - k hota hai (window ka beech wala element).
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

        // Expected output:
        // [-1, -1, -1, 5, 4, 4, -1, -1, -1]
        System.out.println(Arrays.toString(result));
    }
}
