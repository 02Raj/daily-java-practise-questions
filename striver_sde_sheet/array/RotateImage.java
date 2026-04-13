package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Rotate Image (90° Clockwise)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/rotate-image/
📅 Solved On: 13-04-2025
🔁 Revision Due: 20-04-2025
===========================================================

📝 Problem Statement:
n×n matrix diya hai — isse 90° clockwise rotate karo.
In-place karna hai — koi extra 2D array nahi banana.

Example:
Input:  [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

-----------------------------------------------------------
💡 Approach 1 (Brute Force — Extra Matrix):

→ Naya temp matrix banao
→ Formula: temp[j][n-1-i] = matrix[i][j]
→ Temp ko matrix mein copy karo

TC = O(n²) | SC = O(n²) — Space waste hoti hai!

-----------------------------------------------------------
💡 Approach 2 (Optimal — Transpose + Reverse):

Step 1: TRANSPOSE karo
  → matrix[i][j] aur matrix[j][i] swap karo
  → Sirf upper triangle (j > i) ke liye — double swap avoid karne
  → Diagonal elements apni jagah rahenge

Step 2: HAR ROW REVERSE karo
  → Left pointer aur right pointer se andar aao
  → Swap karte jao jab tak left < right

Kyun kaam karta hai?
  → Transpose = diagonal ke across mirror
  → Row reverse = horizontal flip
  → Dono milke = 90° clockwise rotation ✓

-----------------------------------------------------------
🔁 Dry Run: [[1,2,3],[4,5,6],[7,8,9]]

After Transpose:        After Row Reverse:
1 4 7                   7 4 1   ← Row 0 reversed ✓
2 5 8       →           8 5 2   ← Row 1 reversed ✓
3 6 9                   9 6 3   ← Row 2 reversed ✓

Transpose swap pairs: (0,1)↔(1,0) → 2↔4
                      (0,2)↔(2,0) → 3↔7
                      (1,2)↔(2,1) → 6↔8

-----------------------------------------------------------
⏱ Time Complexity (TC):

Transpose: O(n²/2) ≈ O(n²)
Row Reverse: O(n × n/2) ≈ O(n²)

👉 Final TC = O(n²)

-----------------------------------------------------------
📦 Space Complexity (SC):

Sirf ek temp variable swap ke liye

👉 SC = O(1)  ← Brute force se much better!

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Transpose mein j > i kyun? (j = i se shuru kiya toh?)
[ ] Diagonal elements kyun nahi swap hote?
[ ] Row reverse mein left < right kyun condition hai?
[ ] Dry run: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
[ ] 90° anti-clockwise kaise karein? (Transpose + Column reverse)
[ ] 180° rotate kaise karein? (Do baar 90° clockwise)

===========================================================
*/

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // =====================
        // STEP 1: TRANSPOSE
        // matrix[i][j] ↔ matrix[j][i]
        // j > i isliye — warna same pair do baar swap hoga
        // (pehle swap, phir wapas — original ho jaayega)
        // =====================
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // =====================
        // STEP 2: REVERSE EACH ROW
        // Har row mein left pointer aur right pointer
        // andar aate hain, elements swap karte hain
        // =====================
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Helper: matrix print karne ke liye
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: 3×3 matrix
        int[][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Test 1 — Before:");
        printMatrix(m1);
        rotate(m1);
        System.out.println("Test 1 — After (expected: 7 4 1 / 8 5 2 / 9 6 3):");
        printMatrix(m1);

        // Test 2: 4×4 matrix
        int[][] m2 = {{5,1,9,11},{2,4,8,10},
                {13,3,6,7},{15,14,12,16}};
        System.out.println("Test 2 — Before:");
        printMatrix(m2);
        rotate(m2);
        System.out.println("Test 2 — After (expected: 15 13 2 5 / ...):");
        printMatrix(m2);

        // Test 3: 1×1 matrix — edge case
        int[][] m3 = {{42}};
        rotate(m3);
        System.out.print("Test 3 (1×1, expected 42): ");
        System.out.println(m3[0][0]);
    }
}