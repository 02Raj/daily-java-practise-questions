package Algorithm.twopointer;

import java.util.Arrays;

/*
===========================================================
🧩 Problem: Push Dominoes
===========================================================
🔗 LeetCode: https://leetcode.com/problems/push-dominoes/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
n dominoes line mein khade hain.
Kuch R (right), kuch L (left), kuch . (seedhe) hain.
Final state kya hoga?

Example:
Input:  "RR.L"          →  Output: "RR.L"
Input:  ".L.R...LR..L." →  Output: "LL.RR.LLRRLL."

-----------------------------------------------------------
💡 Approach: Forces (Two Pass)

Main idea:
→ Har domino pe do forces ladte hain:
  Right force (R se aati) → positive
  Left force  (L se aati) → negative

→ Net force > 0 → R
→ Net force < 0 → L
→ Net force = 0 → . (tie!)

Step 1: Left→Right pass → R ki force calculate karo
Step 2: Right→Left pass → L ki force calculate karo
Step 3: Net force se answer banao

-----------------------------------------------------------
🧠 Key Ideas:
→ R milte hi force = n (maximum)
→ L milte hi force = 0 (reset)
→ Har step pe force-1 (decay — door jaane pe kam hoti)
→ Same array mein += aur -= karte hain
→ Dono forces ek hi array mein store → net nikal aata!

-----------------------------------------------------------
🔁 Dry Run: "R...L"

Pass 1 (L→R):           Pass 2 (R→L):
R → force=5 → +5        R → force=0
. → force=4 → +4        . → force=0
. → force=3 → +3        . → force=3 → -3
. → force=2 → +2        . → force=4 → -4
L → force=0 → +0        L → force=5 → -5

forces = [5,4,3,2,0]
forces = [5,4,0,-2,-5]  (after pass 2)

Result: R R . L L ✅

-----------------------------------------------------------
⏱ TC: O(n)   📦 SC: O(n)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Force decay kyun hoti hai?
[ ] R milne pe force=n kyun? 0 se kyun nahi?
[ ] Net=0 matlab tie kyun?
[ ] Dry run: ".L.R...LR..L."
[ ] Dry run: "RR.L"

===========================================================
*/

public class PushDominoes {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        // Har position ki net force store karenge
        // Positive = Right force, Negative = Left force
        int[] forces = new int[n];

        // ─────────────────────────────────────
        // PASS 1: Left → Right
        // R ki rightward force calculate karo
        // ─────────────────────────────────────
        int force = 0;
        for (int i = 0; i < n; i++) {

            if (dominoes.charAt(i) == 'R') {
                force = n;
                // R mila! Force maximum pe set karo
                // n isliye kyunki n se zyada decay nahi hogi

            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
                // L mila! R ki rightward force band!
                // L ek wall ki tarah kaam karta hai

            } else {
                force = Math.max(force - 1, 0);
                // '.' mila → force ek kam karo (decay)
                // Math.max → 0 se neeche mat jaane do
            }

            forces[i] += force;
            // Is position ki right force save karo
        }

        // ─────────────────────────────────────
        // PASS 2: Right → Left (ULTA chalenge!)
        // L ki leftward force calculate karo
        // ─────────────────────────────────────
        force = 0;
        for (int i = n - 1; i >= 0; i--) {

            if (dominoes.charAt(i) == 'L') {
                force = n;
                // L mila! Force maximum pe set karo

            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
                // R mila! L ki leftward force band!

            } else {
                force = Math.max(force - 1, 0);
                // '.' mila → force decay
            }

            forces[i] -= force;
            // MINUS! Kyunki yeh LEFT force hai
            // Right force positive, Left force negative
        }

        // ─────────────────────────────────────
        // FINAL: Net force se answer banao
        // ─────────────────────────────────────
        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) sb.append('R');
                // Right force jeet gayi
            else if (f < 0) sb.append('L');
                // Left force jeet gayi
            else sb.append('.');
            // Tie! Dono equal → khada rahega
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes sol = new PushDominoes();

        // Test 1: Simple R aur L
        System.out.print("Test 1: ");
        System.out.println(sol.pushDominoes("RR.L"));
        // Expected: RR.L

        // Test 2: Complex case
        System.out.print("Test 2: ");
        System.out.println(sol.pushDominoes(".L.R...LR..L."));
        // Expected: LL.RR.LLRRLL.

        // Test 3: Sirf R
        System.out.print("Test 3: ");
        System.out.println(sol.pushDominoes("R..."));
        // Expected: RRRR

        // Test 4: Sirf L
        System.out.print("Test 4: ");
        System.out.println(sol.pushDominoes("...L"));
        // Expected: LLLL

        // Test 5: R aur L aamnay samnay
        System.out.print("Test 5: ");
        System.out.println(sol.pushDominoes("R...L"));
        // Expected: RR.LL
    }
}