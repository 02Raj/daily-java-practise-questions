package neetcode.slidingwindow.variableSize;

/**
 * Yeh class subarrays se related problems ko solve karne ke liye banayi gayi hai.
 * Iska naam CountSubarrays hai, jo iske kaam ko darshata hai.
 * Iske andar LeetCode problem 2444: "Count Subarrays With Fixed Bounds" ka solution hai.
 */
public class CountSubarrays {

    /**
     * Yeh main method hai, program ka entry point (shuruaat).
     * Yahan se hum apne solution method ko test kar sakte hain.
     */
    public static void main(String[] args) {
        // Chalo apne solution ko test karte hain.
        // Yeh ek sample test case hai.
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;

        // Hum apne banaye hue method ko call karke result nikalenge.
        long result = countSubarrays(nums, minK, maxK);

        // Aur Aakhir mein result ko print karenge.
        System.out.println("Total fixed-bound subarrays ka count hai: " + result); // Expected output: 2
    }

    /**
     * Yeh tumhara LeetCode solution hai jo fixed-bound subarrays ko count karta hai.
     * Approach: Variable-Size Sliding Window
     * @param nums Input array.
     * @param minK Subarray ka required minimum element.
     * @param maxK Subarray ka required maximum element.
     * @return Total valid subarrays ka count.
     */
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        // 'ans' humara final answer store karega, yaani total valid subarrays ka count.
        long ans = 0;

        // 'minPosition' -> minK ka sabse aakhiri (latest) index store karega.
        int minPosition = -1;

        // 'maxPosition' -> maxK ka sabse aakhiri (latest) index store karega.
        int maxPosition = -1;

        // 'leftBound' -> uss element ka index jo range [minK, maxK] ke bahar tha.
        // Yeh hamari valid window ki "left" boundary hai.
        int leftBound = -1;

        // Hum array ke har element par ek-ek karke jayenge, 'i' current index hai.
        for (int i = 0; i < nums.length; i++) {

            // Step 1: Window ki boundary check karo.
            // Agar current element [minK, maxK] range ke bahar hai...
            if (nums[i] < minK || nums[i] > maxK) {
                // ...toh yeh element kisi bhi valid subarray ka hissa nahi ho sakta.
                // Isliye, hum 'leftBound' ko current index par set kar dete hain.
                leftBound = i;
            }

            // Step 2: minK aur maxK ke latest positions ko update karo.
            if (nums[i] == minK) {
                minPosition = i; // Agar current element minK hai, toh iska index note karlo.
            }
            if (nums[i] == maxK) {
                maxPosition = i; // Agar current element maxK hai, toh iska index note karlo.
            }

            // Step 3: Valid subarrays ko count karo. Yeh core logic hai.
            // Ek subarray tabhi valid hai jab uske start-point 'leftBound' ke baad ho
            // aur woh 'minPosition' aur 'maxPosition' dono ko include kare.
            // Isliye valid start-points ki ginti `min(minPosition, maxPosition) - leftBound` se milti hai.
            int count = Math.min(minPosition, maxPosition) - leftBound;

            // Agar 'count' positive hai, iska matlab hai ki humein naye valid subarrays mile hain
            // jo current index 'i' par khatam ho rahe hain.
            if (count > 0) {
                // Unn sabhi naye subarrays ke count ko final answer mein jod do.
                ans += count;
            }
        }

        // Step 4: Loop khatam hone ke baad, final total count return karo.
        return ans;
    }
}