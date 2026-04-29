package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Set Matrix Zeroes
===========================================================

📝 Problem Statement:
Given an m x n matrix, if an element is 0, set its entire row
and column to 0. You must do it in-place.

-----------------------------------------------------------
💡 Approach (Optimal - O(1) Space):

Step 0:
- Check if first row has any 0 → firstRowZero
- Check if first column has any 0 → firstColZero

Step 1:
- Traverse from (1,1)
- If matrix[i][j] == 0:
    → mark row: matrix[i][0] = 0
    → mark col: matrix[0][j] = 0

Step 2:
- Again traverse from (1,1)
- If row or column is marked:
    → matrix[i][j] = 0

Step 3:
- If firstRowZero → make entire first row 0
- If firstColZero → make entire first column 0

-----------------------------------------------------------
🧠 Key Idea:
- First row & column are used as markers
- Avoid extra space (no extra arrays)

-----------------------------------------------------------
⏱ Time Complexity (TC):

Step 0 → O(n) + O(m)
Step 1 → O(m * n)
Step 2 → O(m * n)
Step 3 → O(n) + O(m)

👉 Final TC = O(m * n)

-----------------------------------------------------------
📦 Space Complexity (SC):

- Only 2 variables used (firstRowZero, firstColZero)

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Notes:
- Always remember:
  → "First row & column = markers"
- Don't forget to handle first row & column separately
- Start traversal from (1,1) to avoid overwrite

===========================================================
*/

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 0: check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 0: check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 1: set markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 3: first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        SetMatrixZero obj = new SetMatrixZero();

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println("Before:");
        printMatrix(matrix);

        obj.setZeroes(matrix);

        System.out.println("\nAfter:");
        printMatrix(matrix);
    }

    // 🔥 Helper method (print matrix)
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}