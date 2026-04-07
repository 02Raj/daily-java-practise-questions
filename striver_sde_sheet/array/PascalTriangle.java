package striver_sde_sheet.array;

import java.util.ArrayList;
import java.util.List;

/*
===========================================================
🧩 Problem: Pascal's Triangle
===========================================================
🔗 LeetCode: https://leetcode.com/problems/pascals-triangle/
📅 Solved On: 07-04-2025
🔁 Revision Due: 14-04-2025
===========================================================

📝 Problem Statement:
Given an integer numRows, return the first numRows of Pascal's
triangle.
In Pascal's triangle:
- Each number = sum of two numbers directly above it
- Edges are always 1

Example:
Input:  numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

-----------------------------------------------------------
💡 Approach (Optimal):

Step 1: Create result list → List<List<Integer>> result
Step 2: Create prev list → starts empty
Step 3: Outer loop i = 0 to numRows-1  → each ROW
Step 4:   Create new curr list for this row
Step 5:   Inner loop j = 0 to i        → each CELL in row
Step 6:     if j==0 OR j==i → edge → add 1
            else            → middle → add prev[j-1] + prev[j]
Step 7:   result.add(curr)
Step 8:   prev = curr   ← CRITICAL: current row becomes prev for next
Step 9: return result

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ "Outer loop = row,  Inner loop = cell in that row"
→ "Edge cells (j==0 or j==i) are ALWAYS 1"
→ "Middle cells = prev[j-1] + prev[j]"
→ "prev = curr at end of each row — never forget this!"
→ Inner loop runs j = 0 to i (NOT 0 to numRows)
   because row i has exactly (i+1) elements

-----------------------------------------------------------
⏱ Time Complexity (TC):

Outer loop  → O(numRows)
Inner loop  → O(i) per row → total = 1+2+3+...+n = O(n²)

👉 Final TC = O(numRows²)

-----------------------------------------------------------
📦 Space Complexity (SC):

result list stores all cells → O(numRows²)
prev + curr → O(numRows) extra

👉 SC = O(numRows²)  [for output storage]
   SC = O(n) extra space (prev/curr only)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Why does inner loop go j <= i (not j < numRows)?
[ ] What happens if you forget prev = curr?
[ ] Why do edge cells not need prev?
[ ] Dry run for numRows = 4

===========================================================
*/

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        // Final answer — list of all rows
        List<List<Integer>> result = new ArrayList<>();

        // Previous row — needed to calculate middle elements
        List<Integer> prev = new ArrayList<>();

        // Outer loop: i = row number (0 to numRows-1)
        for (int i = 0; i < numRows; i++) {

            // Fresh list for current row
            List<Integer> curr = new ArrayList<>();

            // Inner loop: j = column index (0 to i)
            // Row i has exactly (i+1) elements
            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    // Edge cell → always 1
                    curr.add(1);
                } else {
                    // Middle cell → sum of two elements above
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }

            result.add(curr);   // Save this row
            prev = curr;        // This row becomes prev for next iteration
        }

        return result;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        PascalTriangle obj = new PascalTriangle();

        int numRows = 5;
        List<List<Integer>> triangle = obj.generate(numRows);

        System.out.println("Pascal's Triangle (" + numRows + " rows):");
        printTriangle(triangle);
    }

    // 🔥 Helper: print triangle nicely
    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}