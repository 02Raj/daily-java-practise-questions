package stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    /**
     * ✅ PROBLEM STATEMENT:
     * - Given an array heights[] where heights[i] is the height of the i-th bar in a histogram.
     * - Find the area of the largest rectangle that can be formed inside the histogram.
     *
     * Example:
     * Input:  [2, 1, 5, 6, 2, 3]
     * Output: 10
     * Explanation:
     * - Largest rectangle is between bars 5 and 6 → width = 2, height = 5 → area = 10.
     */

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // stack stores indices
        int maxArea = 0;                      // track maximum rectangle area
        int n = heights.length;

        // 👉 Trick: run loop till n (one extra step to flush stack at the end)
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // at i == n, force h=0 to empty stack

            // While current height is smaller → calculate area for taller bars
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // height of popped bar

                // Width calculation:
                // - If stack is empty → this bar extended from index 0 to i-1
                // - Else → width = (i - stack.peek() - 1)
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                // Update max area
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index into stack
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
        // Output: 10
    }
}

/**
 * 📖 INTUITION / STORY:
 * - Imagine histogram bars.
 * - For each bar, we want to know:
 *   "How far can this bar extend left and right without hitting a smaller bar?"
 * - That determines the width of rectangle with this bar as height.
 * - Brute force: For each bar, expand left & right → O(n^2).
 * - Optimized: Use a stack to track increasing heights.
 *
 * 🎯 APPROACH:
 * 1. Traverse histogram from left to right (0 to n).
 * 2. Maintain an increasing stack of indices.
 * 3. If current height < stack top → process rectangles with stack top as height.
 * 4. Width calculation:
 *    - If stack empty → rectangle spans from 0 to i-1.
 *    - Else → rectangle spans from (stack.peek()+1) to (i-1).
 * 5. Continue until all bars processed.
 * 6. Add extra 0-height bar at the end to flush stack.
 *
 * 🔑 TRICKS:
 * - Push indices, not heights → easier width calculation.
 * - Use sentinel (h=0 at end) to simplify cleanup.
 * - Each bar is pushed and popped at most once → O(n).
 *
 * ⏱ TIME COMPLEXITY:
 * - O(n) → Each bar processed at most twice.
 *
 * 🗂 SPACE COMPLEXITY:
 * - O(n) for stack.
 */
