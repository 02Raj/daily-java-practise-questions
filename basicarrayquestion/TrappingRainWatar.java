package basicarrayquestion;

/*
 📌 Problem Statement:
   Trapping Rain Water
   -------------------
   Given n non-negative integers representing the elevation map where the width of each bar is 1,
   compute how much water it can trap after raining.

   Example:
   Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
   Output: 6

   Visual:
   |        #
   |    #~~~##~#
   | #~##~######
   ---------------
   -> Water trapped = 6 units

 ------------------------------------------------------------
 📌 Approaches (Step by Step Thinking)
 ------------------------------------------------------------
 1️⃣ Brute Force (O(n^2))
   - For each index, find max to the left and max to the right by scanning every time.
   - Water = min(leftMax, rightMax) - height[i].
   - Very slow, not efficient.

 2️⃣ Prefix Arrays (O(n) time, O(n) space) ✅ (Our Implementation)
   - Precompute leftMax[] = maximum height on the left for every index.
   - Precompute rightMax[] = maximum height on the right for every index.
   - Then for each index:
        water[i] = min(leftMax[i], rightMax[i]) - height[i].
   - Add all water[i] to get total.
   - Space = O(n) for leftMax + rightMax.

 3️⃣ Two-Pointer (Optimized, O(n) time, O(1) space)
   - Use two pointers (left & right) and two variables (leftMax, rightMax).
   - Move the smaller side inward, calculate water on the fly.
   - Saves space, but logic is trickier.
   - Interviewers love if you mention this optimization.

 ------------------------------------------------------------
 👉 In this file, we are implementing Approach 2 (Prefix Arrays)
 ------------------------------------------------------------
*/

public class TrappingRainWatar {

    public static void main(String[] args) {
        // Example input array -> building heights
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Call trapWater method
        int ans = trapWater(height);

        // Print the result
        System.out.println("Total trapped water = " + ans); // Expected: 6
    }

    // 👉 Method to calculate trapped rain water using LeftMax & RightMax arrays
    public static int trapWater(int[] height) {
        int n = height.length;

        // Edge case: agar sirf 0 ya 1 bar hai to paani trap nahi hoga
        if (n == 0 || n == 1) return 0;

        /*
         STEP 1: Left Max array banate hain
         -----------------------------------
         - leftMax[i] = i ke left side tak ki max height
         - Traverse from left → right
        */
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        /*
         STEP 2: Right Max array banate hain
         -----------------------------------
         - rightMax[i] = i ke right side tak ki max height
         - Traverse from right → left
        */
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        /*
         STEP 3: Har index par water calculate karo
         -------------------------------------------
         - Formula:
             water[i] = min(leftMax[i], rightMax[i]) - height[i]
         - Agar negative value aati hai, iska matlab waha paani nahi hoga.
        */
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterAtI = Math.min(leftMax[i], rightMax[i]) - height[i];

            if (waterAtI > 0) {
                totalWater += waterAtI;
            }
        }

        // STEP 4: Return final answer
        return totalWater;
    }
}
