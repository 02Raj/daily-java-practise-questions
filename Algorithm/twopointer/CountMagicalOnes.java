package Algorithm.twopointer;

/*
===========================================================
🧩 Problem: Count Magical Ones
===========================================================
🔗 LeetCode: https://leetcode.com/problems/
📅 Solved On: 22-04-2026
🔁 Revision Due: 29-04-2026
===========================================================

📝 Problem Statement:
Magical string s = "1221121221221121122..."
Sirf 1 aur 2 se bani hai.
String khud apne aap ko describe karti hai!

Groups: 1 | 22 | 11 | 2 | 1 | 22 ...
Sizes:  1    2   2   1   1   2  ← same string!

Given n → pehle n elements mein kitne '1' hain?

Example:
n=6  → "122112" → 3 ones
n=1  → "1"      → 1 one

===========================================================
💡 APPROACH 1: BRUTE FORCE
===========================================================
Puri string banao, phir count karo!

Step 1: Seed se shuru karo [1,2,2]
Step 2: Read pointer se instruction lo
Step 3: Write pointer se likho
Step 4: Pehle n elements mein 1 count karo

⏱ TC: O(n)   📦 SC: O(n)

===========================================================
💡 APPROACH 2: TWO POINTER
===========================================================
Read aur Write — do pointer ek saath!

READ  pointer → instruction deta hai (kitna likhna)
WRITE pointer → wahan likhta hai

Step 1: Seed [1,2,2] se shuru
Step 2: read=2, write=3 set karo
Step 3: s[read] se count lo
Step 4: count baar next likho (write pointer se)
Step 5: toggle next, read aage badho

🔁 Dry Run: n=6
s    = [1, 2, 2, _, _, _]
read=2 → s[2]=2 → 2 baar '1' likho
s    = [1, 2, 2, 1, 1, _]  ones=3
read=3 → s[3]=1 → 1 baar '2' likho
s    = [1, 2, 2, 1, 1, 2]
return ones = 3 ✅

⏱ TC: O(n)   📦 SC: O(n)

===========================================================
🧠 Key Ideas:
→ write >= n check zaroori! Warna extra count hoga
→ ones=1 isliye kyunki s[0]=1 pehle se hai
→ next = 3-next → elegant toggle (1→2, 2→1)
→ Seed hamesha [1,2,2] fixed hota hai

===========================================================
🔁 Revision Checklist:
[ ] Read pointer kya karta hai?
[ ] Write pointer kya karta hai?
[ ] ones=1 kyun initialize kiya?
[ ] write >= n check kyun lagaya?
[ ] 3-next trick kaise kaam karti hai?
===========================================================
*/

public class CountMagicalOnes {

    // ═══════════════════════════════════════════════════════
    // APPROACH 1 : BRUTE FORCE
    // TC: O(n)  SC: O(n)
    // ═══════════════════════════════════════════════════════
    public int bruteForce(int n) {
        if (n <= 3) return 1;

        int[] s = new int[n + 1];
        s[0] = 1; s[1] = 2; s[2] = 2;

        int head = 2;
        int next = 1;

        // Puri string banao
        while (s.length <= n) {
            int count = s[head];
            for (int i = 0; i < count; i++) {
                if (head + i + 1 < s.length) {
                    s[head + i + 1] = next;
                }
            }
            next = 3 - next;
            head++;
        }

        // Count karo
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 1) ones++;
        }
        return ones;
    }

    // ═══════════════════════════════════════════════════════
    // APPROACH 2 : TWO POINTER ← OPTIMAL
    // TC: O(n)  SC: O(n)
    // ═══════════════════════════════════════════════════════
    public int twoPointer(int n) {
        if (n <= 3) return 1;

        int[] s = new int[n + 1];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int read  = 2;  // instructor - kitna likhna hai
        int write = 3;  // builder    - yahan likhna hai
        int next  = 1;  // 1 ya 2
        int ones  = 1;  // s[0]=1 pehle se count

        while (write < n) {
            int count = s[read];  // instruction lo

            for (int i = 0; i < count; i++) {
                if (write >= n) break;  // n se bahar mat jao!
                s[write] = next;
                if (next == 1) ones++;  // 1 mila → count karo
                write++;
            }

            next = 3 - next;  // toggle: 1→2 ya 2→1
            read++;            // agli instruction
        }

        return ones;
    }

    // ═══════════════════════════════════════════════════════
    // MAIN → Dono Approaches Test Karo
    // ═══════════════════════════════════════════════════════
    public static void main(String[] args) {
        CountMagicalOnes sol = new CountMagicalOnes();

        int[] inputs   = {1, 6, 10, 13};
        int[] expected = {1, 3,  5,  6};

        System.out.println("n  | BruteForce | TwoPointer | Expected");
        System.out.println("─────────────────────────────────────────");

        for (int t = 0; t < inputs.length; t++) {
            System.out.printf(
                    "%-2d |     %-6d |     %-6d |    %d%n",
                    inputs[t],
                    sol.bruteForce(inputs[t]),
                    sol.twoPointer(inputs[t]),
                    expected[t]
            );
        }
    }
}