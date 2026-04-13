package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Merge Intervals
===========================================================
🔗 LeetCode: https://leetcode.com/problems/merge-intervals/
📅 Solved On: 13-04-2025
🔁 Revision Due: 20-04-2025
===========================================================

📝 Problem Statement:
Overlapping intervals diye hain — sab merge karke
non-overlapping intervals ka array return karo.

Example:
Input:  [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

Input:  [[1,4],[4,5]]
Output: [[1,5]]   ← touching intervals bhi overlap hai!

-----------------------------------------------------------
💡 Approach 1 (Brute Force):

→ Har interval ko baaki se compare karo
→ Overlap mile toh merge karo, warna skip
→ O(n²) — TLE aayega bade inputs pe

-----------------------------------------------------------
💡 Approach 2 (Optimal — Sort + Linear Scan):

Step 1: Sort by start time
  → Arrays.sort(intervals, (a, b) -> a[0] - b[0])
  → Ab guaranteed hai: next.start >= current.start

Step 2: Traverse with current interval tracking
  → OVERLAP condition:   next[0] <= current[1]
     Action: current[1] = Math.max(current[1], next[1])
  → NO OVERLAP condition: next[0] > current[1]
     Action: result mein current daalo, current = next

Step 3: Last current ko bhi result mein daalo
  (loop ke baad yeh bacha rehta hai)

-----------------------------------------------------------
🔁 Dry Run: [[1,3],[2,6],[8,10],[15,18]]

Sort → already sorted

current = [1,3]
i=1: [2,6]  → 2 <= 3? YES → current = [1, max(3,6)] = [1,6]
i=2: [8,10] → 8 <= 6? NO  → add [1,6], current = [8,10]
i=3: [15,18]→ 15<=10? NO  → add [8,10], current = [15,18]
End of loop → add [15,18]

Result: [[1,6],[8,10],[15,18]] ✓

Edge case: [[1,4],[4,5]]
current = [1,4]
i=1: [4,5] → 4 <= 4? YES (touching!) → current = [1, max(4,5)] = [1,5]
End → add [1,5]
Result: [[1,5]] ✓

-----------------------------------------------------------
⏱ Time Complexity (TC):

Sort     → O(n log n)
Traversal → O(n)

👉 Final TC = O(n log n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Result list → O(n) worst case (koi overlap na ho)
Sort in-place → O(log n) stack (Java's Arrays.sort)

👉 SC = O(n)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Sort kyun zaroori hai? Bina sort ke kya problem hogi?
[ ] Overlap condition: next[0] <= current[1] kyun <= hai, < nahi?
[ ] Math.max kyun? Sirf next[1] kyun nahi le lete?
[ ] Loop ke baad last interval daalna kyun zaroori hai?
[ ] Dry run: [[4,7],[1,4]] → expected [[1,7]]
[ ] Dry run: [[1,4],[2,3]] → expected [[1,4]] (ek andar ek!)

===========================================================
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Step 1: Sort by start time
        // Lambda (a,b) -> a[0]-b[0] = ascending order of start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Pehle interval ko current banao
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // OVERLAP: next ka start, current ke end se pehle/same hai
                // current ka end extend karo (max isliye kyunki
                // ek interval doosre ke andar bhi ho sakta hai)
                current[1] = Math.max(current[1], next[1]);

            } else {
                // NO OVERLAP: current finish, result mein daalo
                // next ab naya current banega
                result.add(current);
                current = next;
            }
        }

        // Step 3: Last current interval mat bhoolna!
        // (loop ke end mein yeh result mein add nahi hua hota)
        result.add(current);

        return result.toArray(new int[0][]);
    }

    public static void printResult(int[][] res) {
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "]");
            if (i < res.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Classic overlapping
        int[][] t1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.print("Test 1 (expected [[1,6],[8,10],[15,18]]): ");
        printResult(merge(t1));

        // Test 2: Touching intervals
        int[][] t2 = {{1,4},{4,5}};
        System.out.print("Test 2 (expected [[1,5]]): ");
        printResult(merge(t2));

        // Test 3: Unsorted input (sorting handles it)
        int[][] t3 = {{4,7},{1,4}};
        System.out.print("Test 3 (expected [[1,7]]): ");
        printResult(merge(t3));

        // Test 4: One inside another [[1,10],[2,4]]
        int[][] t4 = {{1,10},{2,4}};
        System.out.print("Test 4 (expected [[1,10]]): ");
        printResult(merge(t4));
    }
}