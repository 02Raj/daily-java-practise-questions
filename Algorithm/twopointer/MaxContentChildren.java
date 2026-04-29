package Algorithm.twopointer;

import java.util.Arrays;

/*
===========================================================
🧩 Problem: Assign Cookies (Cookie Distribution)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/assign-cookies/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
Tumhare paas bacche hain aur cookies hain.
Har bacha ek minimum size ki cookie chahta hai (greed factor).
Maximize karo kitne bacche khush ho sakte hain.

Rule: s[j] >= g[i] → cookie j, child i ko de sakte ho

Example:
Input:  g=[1,2,3], s=[1,1]     →  Output: 1
Input:  g=[1,2,3], s=[1,2,3]   →  Output: 3
Input:  g=[2,3],   s=[2,3,4]   →  Output: 2

-----------------------------------------------------------
💡 Approach: Greedy + Sorting (Two Pointer)

Main idea:
→ Sabse chote bache ko sabse choti
  kaam aane wali cookie do!
→ Badi cookie chote bache ko dena = WASTE!

Step 1: Dono arrays sort karo
Step 2: Two pointers — child aur cookie
Step 3: Cookie kaam aayi → child khush → child aage badho
        Cookie kaam aayi ya nahi → cookie aage badho

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ Sort karna ZAROORI hai — warna galat assignment hogi
→ Cookie hamesha aage badhti — chhoti cookie bade
  bache ke kaam nahi aayegi kabhi!
→ child pointer = kitne bacche khush hue (answer!)
→ Greedy = har step pe best choice karo

-----------------------------------------------------------
❌ Galat Approach (Tumhara Pehla Solution):

boolean[] used = new boolean[s.length];
for (int i = 0; i < g.length; i++) {
    for (int j = 0; j < s.length; j++) {
        if (!used[j] && s[j] >= g[i]) { ... }
    }
}

Problem:
g=[1,3], s=[2,1]
Child 1 (greed=1) → size=2 cookie mili (WASTE!)
Child 2 (greed=3) → size=1 cookie → kaam nahi aai
Answer = 1 ❌

Sahi hota:
Child 1 → size=1 cookie
Child 2 → size=2 cookie
Answer = 2 ✅

-----------------------------------------------------------
🔁 Dry Run: g=[1,2,3], s=[1,2,3]

Sort karo:
g = [1, 2, 3]
s = [1, 2, 3]

child=0, cookie=0:
  s[0]=1 >= g[0]=1 ✅ → child=1, cookie=1
  khushBacche = 1

child=1, cookie=1:
  s[1]=2 >= g[1]=2 ✅ → child=2, cookie=2
  khushBacche = 2

child=2, cookie=2:
  s[2]=3 >= g[2]=3 ✅ → child=3, cookie=3
  khushBacche = 3

👉 Answer: 3 ✅

-----------------------------------------------------------
🔁 Dry Run 2: g=[1,3], s=[1,2]

Sort karo:
g = [1, 3]
s = [1, 2]

child=0, cookie=0:
  s[0]=1 >= g[0]=1 ✅ → child=1, cookie=1
  khushBacche = 1

child=1, cookie=1:
  s[1]=2 >= g[1]=3 ❌ → sirf cookie aage
  cookie=2

cookie=2 → s.length=2 → loop band!

👉 Answer: 1 ✅

-----------------------------------------------------------
⏱ Time Complexity (TC):

Sorting       → O(n log n + m log m)
Two pointer   → O(n + m)

👉 Final TC = O(n log n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Sirf 2 pointers — koi extra array nahi

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Sort kyun karna zaroori hai?
[ ] Cookie pointer hamesha aage kyun badhta hai?
[ ] child pointer hi answer kyun hai?
[ ] Dry run: g=[1,2], s=[1,2,3] → expected 2
[ ] Dry run: g=[1,2,3], s=[1,1] → expected 1
[ ] Tumhara pehla solution kyun fail hua?

===========================================================
*/

public class MaxContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        // Step 1: Dono arrays sort karo
        // Chote bache ko choti cookie!
        Arrays.sort(g);
        Arrays.sort(s);

        // Step 2: Two pointers banao
        int child = 0;   // g[child] = is bache ki greed
        int cookie = 0;  // s[cookie] = is cookie ki size

        // Step 3: Dono pointers chalao
        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                // Cookie kaam aayi!
                // Bacha khush → agla bacha dekho
                child++;
            }

            // Cookie kaam aayi ya nahi
            // Yeh cookie toh gayi → agli cookie dekho
            cookie++;
        }

        // child = total kitne bacche khush hue
        return child;
    }

    public static void main(String[] args) {
        MaxContentChildren sol = new MaxContentChildren();

        // Test 1: Classic case
        System.out.print("Test 1: ");
        System.out.println(sol.findContentChildren(
                new int[]{1,2,3},
                new int[]{1,1}
        )); // Expected: 1

        // Test 2: Sab khush ho sakte hain
        System.out.print("Test 2: ");
        System.out.println(sol.findContentChildren(
                new int[]{1,2,3},
                new int[]{1,2,3}
        )); // Expected: 3

        // Test 3: Extra cookies hain
        System.out.print("Test 3: ");
        System.out.println(sol.findContentChildren(
                new int[]{2,3},
                new int[]{2,3,4}
        )); // Expected: 2

        // Test 4: Tumhara pehla solution fail hota tha yahan!
        System.out.print("Test 4: ");
        System.out.println(sol.findContentChildren(
                new int[]{1,3},
                new int[]{2,1}
        )); // Expected: 2

        // Test 5: Koi cookie kaam nahi aati
        System.out.print("Test 5: ");
        System.out.println(sol.findContentChildren(
                new int[]{5,6,7},
                new int[]{1,2,3}
        )); // Expected: 0
    }
}