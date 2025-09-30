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
     */

    private int maximalRectangle(char[][] matrix) {
        //  Edge case: matrix empty
        if (matrix.length == 0) return 0;

        // Number of columns in matrix
        int n = matrix[0].length;

        // Heights array (for histogram of each row)
        int[] heights = new int[n];

        // Store global max area
        int maxArea = 0;

        // Traverse each row
        for (char[] row : matrix) {
            // -------------------------------------------
            // STEP 1: Update heights[] for this row
            // if '1' → add 1 to height, if '0' → reset 0
            // -------------------------------------------
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // -------------------------------------------
            // STEP 2: For this updated histogram,
            // find the largest rectangle area
            // -------------------------------------------
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * ====================================================
     * Helper Function: Largest Rectangle in Histogram
     * ====================================================
     * Approach:
     * - Use Monotonic Increasing Stack
     * - Each bar is processed once (push + pop)
     * - Add a sentinel '0' at the end → force pop all
     *
     * Formula for area:
     *   while currentHeight < stackTopHeight:
     *       height = popped bar height
     *       width = (rightIndex - leftIndex - 1)
     *       area  = height * width
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Extended array with extra 0 at end
        int[] extended = Arrays.copyOf(heights, heights.length + 1);

        // Traverse all bars
        for (int i = 0; i < extended.length; i++) {
            // Pop until stack top is bigger than current bar
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int height = extended[stack.pop()]; // height of popped bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // width formula
                int area = height * width;
                maxArea = Math.max(maxArea, area); // update max
            }
            // Push current bar index
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Example input
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        MaximalRectangle obj = new MaximalRectangle();
        int ans = obj.maximalRectangle(matrix);

        // ✅ Expected output: 6
        System.out.println("Maximal Rectangle Area = " + ans);
    }
}

/**
 * ===============================
 *  DRY RUN (row-wise heights)
 * ===============================
 * Row1: [1,0,1,0,0]  → max area = 1
 * Row2: [2,0,2,1,1]  → max area = 3
 * Row3: [3,1,3,2,2]  → max area = 6
 * Row4: [4,0,0,3,0]  → max area = 4
 * Global max = 6
 *
 * ===============================
 *  COMPLEXITY ANALYSIS
 * ===============================
 * Time Complexity:
 * - For each row O(C) to update heights
 * - For each row O(C) for histogram via stack
 * - Total = O(R * C)
 *
 * Space Complexity:
 * - heights[] = O(C)
 * - stack = O(C)
 * => Overall O(C)
 *
 * ===============================
 *  INTUITION STORY
 * ===============================
 * - Convert each row into histogram of 1’s
 * - Use stack to find largest rectangle in histogram
 * - Keep track of global max
 * - Sentinel 0 at end ensures all bars processed
 */
