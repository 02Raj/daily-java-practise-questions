package stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    /**
     * ============================
     *  Problem: Maximal Rectangle
     * ============================
     *
     * Given a binary matrix filled with 0's and 1's,
     * find the largest rectangle containing only 1's
     * and return its area.
     *
     * -----------------------------------------------
     * 🔥 This problem is a COMBINATION of:
     * 1. Largest Rectangle in Histogram (LeetCode 84)
     * 2. Dynamic Programming on matrix (row-by-row heights)
     * -----------------------------------------------
     *
     * APPROACH STORY:
     * - Think of each row as the base of a histogram.
     * - Build "heights" array where each column keeps
     *   track of consecutive '1's from top to current row.
     * - For each row, solve "Largest Rectangle in Histogram"
     *   using a stack.
     * - Keep global maximum area.
     */

    private int maximalRectangle(char[][] matrix) {
        // ✅ Edge case: empty matrix
        if (matrix.length == 0) return 0;

        // Number of columns
        int n = matrix[0].length;

        // Heights array for histogram
        int[] heights = new int[n];

        // Global maximum area
        int maxArea = 0;

        // Traverse each row of the matrix
        for (char[] row : matrix) {
            // Step 1: Update heights based on current row
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    heights[j] += 1;   // Increase height if '1'
                } else {
                    heights[j] = 0;    // Reset if '0'
                }
            }

            // Step 2: Calculate largest rectangle in this histogram row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * ====================================================
     * Helper Function: Largest Rectangle in Histogram
     * ====================================================
     * - Standard monotonic stack approach
     * - Complexity: O(n)
     * - Trick: add a "sentinel bar of height 0" at the end
     *   so that all bars are popped and processed
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Extended array with one extra '0' at the end
        int[] extended = Arrays.copyOf(heights, heights.length + 1);

        // Traverse bars
        for (int i = 0; i < extended.length; i++) {
            // While current bar is smaller → pop from stack
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int height = extended[stack.pop()]; // height of popped bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Example matrix
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        MaximalRectangle obj = new MaximalRectangle();
        int ans = obj.maximalRectangle(matrix);

        System.out.println("Maximal Rectangle Area = " + ans); // ✅ Expected: 6
    }
}
