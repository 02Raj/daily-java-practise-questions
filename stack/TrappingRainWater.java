package stack;

import java.util.Stack;

/**
 * Question: Trapping Rain Water (LeetCode 42 / GFG)
 *
 * Problem:
 * ----------
 * Ek array diya hai jo buildings ki height batata hai (bars).
 * Bars ke beech mein kitna paani ruk sakta hai, wo calculate karna hai.
 *
 * Example:
 * ----------
 * Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Subarrays ka visualization (bar graph socho):
 * Yaha valleys (gaddhe) ke upar water store hoga.
 *
 * --------------------------------------------------------
 * Approaches:
 * --------------------------------------------------------
 * 1. Brute Force (O(n^2) / O(n^3)):
 *    - Har bar ke liye left max aur right max nikal ke check karo.
 *    - Water[i] = min(leftMax, rightMax) - height[i].
 *    - Bahut slow, bade input pe TLE.
 *
 * 2. Prefix-Suffix Array (O(n) time, O(n) space):
 *    - Pehle ek array banao jo har index ke liye leftMax store kare.
 *    - Dusra array rightMax store kare.
 *    - Fir formula use karo.
 *
 * 3. Optimal Stack Approach (O(n) time, O(n) space):
 *    - Ek monotonic stack use karo jo bars ke indices store kare.
 *    - Jab current bar stack ke top se bada ho jata hai,
 *      matlab ek valley (gaddha) mil gaya jisme paani store hoga.
 *    - Pop karo valley, left aur right boundary find karo,
 *      aur trapped water calculate karo.
 *
 * Formula:
 * --------
 * For valley at "bottom":
 *   distance = right - left - 1
 *   boundedHeight = min(height[left], height[right]) - height[bottom]
 *   trappedWater = distance * boundedHeight
 */

public class TrappingRainWater {

    // Function jo total trapped water calculate karega
    int trap(int[] height) {
        int n = height.length;

        // Agar 0 ya 1 bar h to water trap nahi hoga
        if (n <= 1) return 0;

        int totalWater = 0;                   // Answer store karne ke liye
        Stack<Integer> stack = new Stack<>(); // Stack indices rakhega

        // Har bar ko traverse karo
        for (int i = 0; i < n; i++) {

            // Jab tak current bar bada hai stack ke top se,
            // matlab paani fill ho sakta hai
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottom = stack.pop(); // Ye valley (beech ka gaddha) hai

                // Agar stack empty ho gaya to left boundary nahi hai
                if (stack.isEmpty()) break;

                int left = stack.peek(); // Left boundary index
                int right = i;           // Right boundary index

                // Left aur right ke beech ka distance
                int distance = right - left - 1;

                // Water ki height = dono boundary ka min - bottom ki height
                int boundedHeight = Math.min(height[left], height[right]) - height[bottom];

                // Area add karo
                totalWater += distance * boundedHeight;
            }

            // Current bar ko stack me daal do future ke liye
            stack.push(i);
        }

        return totalWater;
    }

    // Driver code
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Output expected = 6
        System.out.println("Trapped Water: " + solution.trap(height));
    }
}
