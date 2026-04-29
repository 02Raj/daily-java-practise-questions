package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Search a 2D Matrix
===========================================================
🔗 LeetCode: https://leetcode.com/problems/search-a-2d-matrix/
📅 Solved On: 14-04-2025
🔁 Revision Due: 21-04-2025
===========================================================

📝 Problem Statement:
m×n matrix diya hai jisme:
  → Har row left se right sorted hai
  → Har row ka pehla element pichli row ke last element se bada hai
  (matlab poora matrix ek sorted array ki tarah hai!)

Target number dhoondho — true/false return karo.

Example:
Matrix:         Target: 3
 1  3  5  7
10 11 16 20     Output: true (3 present hai)
23 30 34 60

Matrix:         Target: 13
 1  3  5  7
10 11 16 20     Output: false
23 30 34 60

-----------------------------------------------------------
💡 Approach 1 — Brute Force (Nested Loop):

→ Har element check karo — row by row, col by col
→ Agar mil gaya → true, loop khatam hone pe → false

TC = O(m × n)   ← poora matrix scan
SC = O(1)

Kyun suboptimal hai?
→ Matrix ki sorted property ka bilkul fayda nahi uthaya
→ Bilkul aisa ki sorted array mein bhi linear search karo
→ Interview mein brute force batao, phir turant bolo
  "Better kar sakte hain kyunki matrix sorted hai"

-----------------------------------------------------------
💡 Approach 2 — Optimal (Binary Search on Virtual Array):

Key Insight:
→ Matrix ko ek 1D sorted array ki tarah imagine karo
→ Total elements = m × n
→ Virtual index 'mid' ko actual (row, col) mein convert karo:
     row = mid / n
     col = mid % n

Kyun yeh kaam karta hai?
→ Matrix mein guarantee hai:
   har row sorted + agle row ka start > pichli row ka end
→ Matlab [0][0] sabse chota, [m-1][n-1] sabse bada
→ Yeh exactly ek sorted 1D array jaise behave karta hai!
→ Toh Binary Search directly apply ho jaata hai

Step 1: low = 0, high = m*n - 1
Step 2: mid = (low + high) / 2
Step 3: mid ko (row, col) mein convert karo
Step 4: matrix[row][col] == target → true!
        matrix[row][col] < target  → low = mid + 1
        matrix[row][col] > target  → high = mid - 1

TC = O(log(m × n))   ← log of total elements
SC = O(1)

-----------------------------------------------------------
🔁 Dry Run (Optimal): matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

n = 4 (columns), low = 0, high = 11

Iteration 1:
  mid = (0+11)/2 = 5
  row = 5/4 = 1, col = 5%4 = 1
  matrix[1][1] = 11 > 3 → high = 4

Iteration 2:
  mid = (0+4)/2 = 2
  row = 2/4 = 0, col = 2%4 = 2
  matrix[0][2] = 5 > 3 → high = 1

Iteration 3:
  mid = (0+1)/2 = 0
  row = 0/4 = 0, col = 0%4 = 0
  matrix[0][0] = 1 < 3 → low = 1

Iteration 4:
  mid = (1+1)/2 = 1
  row = 1/4 = 0, col = 1%4 = 1
  matrix[0][1] = 3 == 3 → return true ✓

-----------------------------------------------------------
📊 Brute vs Optimal — Comparison:

                Brute Force     Optimal (BS)
TC              O(m × n)        O(log(m × n))
SC              O(1)            O(1)
Matrix 1000×1000  10^6 ops      ~20 ops!

Kyun itna fark?
→ 1000×1000 = 10,00,000 elements
→ log2(10,00,000) ≈ 20
→ Binary Search 50,000x faster ho sakta hai!

-----------------------------------------------------------
⏱ Time Complexity:

Brute Force → O(m × n)
Optimal     → O(log(m × n))

-----------------------------------------------------------
📦 Space Complexity:

Dono approaches → O(1)  (koi extra space nahi)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] row = mid/n aur col = mid%n — yeh formula kyun kaam karta hai?
[ ] Agar matrix ki guarantee na ho (sirf har row sorted ho) toh?
     → Yeh approach kaam nahi karegi (LeetCode 240 alag problem hai)
[ ] Dry run: target = 13 → expected false
[ ] Dry run: 1×1 matrix [[5]], target = 5 → expected true
[ ] Dry run: 1×1 matrix [[5]], target = 2 → expected false
[ ] Binary Search ka low <= high condition kyun? low < high kyun nahi?

===========================================================
*/

public class SearchMatrix {

    // =============================================
    // APPROACH 1: BRUTE FORCE — Nested Loop
    // TC: O(m × n)  |  SC: O(1)
    // =============================================
    public static boolean searchMatrixBrute(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == target) {
                    return true;  // mil gaya!
                }
            }
        }

        return false;  // poora scan kiya, nahi mila
    }

    // =============================================
    // APPROACH 2: OPTIMAL — Binary Search
    // TC: O(log(m × n))  |  SC: O(1)
    //
    // Key trick: 2D matrix ko virtual 1D sorted
    // array maano, mid se (row, col) nikalo:
    //   row = mid / n
    //   col = mid % n
    // =============================================
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {

        int m = matrix.length;       // rows ki count
        int n = matrix[0].length;    // columns ki count

        int low  = 0;
        int high = m * n - 1;       // virtual last index

        while (low <= high) {
            int mid = (low + high) / 2;

            // Virtual index → actual (row, col) conversion
            // mid=5, n=4 → row=1, col=1 (matlab matrix[1][1])
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;

            } else if (matrix[row][col] < target) {
                low = mid + 1;   // target daayein taraf hai

            } else {
                high = mid - 1;  // target baayein taraf hai
            }
        }

        return false;  // target matrix mein nahi hai
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        int[][] matrix = {
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        // Test 1: Target present
        System.out.println("--- Target = 3 ---");
        System.out.print("Brute:   ");
        System.out.println(searchMatrixBrute(matrix, 3));   // true
        System.out.print("Optimal: ");
        System.out.println(searchMatrixOptimal(matrix, 3));  // true

        // Test 2: Target absent
        System.out.println("--- Target = 13 ---");
        System.out.print("Brute:   ");
        System.out.println(searchMatrixBrute(matrix, 13));   // false
        System.out.print("Optimal: ");
        System.out.println(searchMatrixOptimal(matrix, 13));  // false

        // Test 3: First element
        System.out.println("--- Target = 1 ---");
        System.out.print("Brute:   ");
        System.out.println(searchMatrixBrute(matrix, 1));    // true
        System.out.print("Optimal: ");
        System.out.println(searchMatrixOptimal(matrix, 1));   // true

        // Test 4: Last element
        System.out.println("--- Target = 60 ---");
        System.out.print("Brute:   ");
        System.out.println(searchMatrixBrute(matrix, 60));   // true
        System.out.print("Optimal: ");
        System.out.println(searchMatrixOptimal(matrix, 60));  // true
    }
}