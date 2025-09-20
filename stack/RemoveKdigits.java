package stack;

/*
===========================================================
💡 QUESTION: 402. Remove K Digits
===========================================================

Given a string num (non-negative integer as string) and
an integer k, remove k digits from the number such that
the new number is the smallest possible.

Examples:
---------
1. Input: num = "1432219", k = 3
   Output: "1219"
   Explanation: Remove 4, 3, 2 → result = 1219 (smallest)

2. Input: num = "10200", k = 1
   Output: "200"
   Explanation: Remove 1 → result = 0200 → 200

3. Input: num = "10", k = 2
   Output: "0"
   Explanation: Remove all → result = 0

-----------------------------------------------------------
🔑 INTUITION:
-----------------------------------------------------------
- Hume ek aisa number chahiye jo lexicographically sabse
  chhota ho.
- Matlab: Har jagah "bade digit ke baad agar chhota digit aata hai,
  to bada digit remove karna best hota hai."
- Isliye greedy + stack approach best hai.

-----------------------------------------------------------
🔑 APPROACH (Greedy + Stack):
-----------------------------------------------------------
1. Ek empty stack banao.
2. Traverse each digit (left to right).
   - Jab tak (stack non-empty) && (k > 0) && (stack ka top > current digit):
        → stack se pop karo (remove big digit).
        → k--.
   - Current digit ko push karo.
3. Agar traversal ke baad bhi k > 0 bacha ho:
   - Last ke k digits stack se pop kar do.
4. Ab stack ko string me convert karo.
5. Leading zeros hatao.
6. Agar empty ho jaye → return "0".

-----------------------------------------------------------
🔑 WHY STACK?
-----------------------------------------------------------
- Stack se last inserted digit (top) easily check karke remove kar sakte hain.
- Ye "remove bigger digit before smaller one" logic ko efficient banata hai.
- Stack + Greedy combo = O(n) solution.

-----------------------------------------------------------
🔑 KEY OPERATIONS:
-----------------------------------------------------------
1. `while (!stack.isEmpty() && k > 0 && stack.peek() > ch)`
   → bada digit remove karna.
2. `stack.push(ch)`
   → current digit ko add karna.
3. `while (k > 0 && !stack.isEmpty())`
   → agar abhi bhi remove bacha ho to end se pop karna.
4. Remove leading zeros using StringBuilder.
5. Agar string empty → return "0".

-----------------------------------------------------------
🔑 COMPLEXITY:
-----------------------------------------------------------
- Time: O(n)  (har digit ek baar push & pop hota hai)
- Space: O(n) (stack + StringBuilder)

===========================================================
💻 CODE IMPLEMENTATION (Java)
===========================================================
*/

import java.util.*;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            // Step 1: Greedy removal of bigger digits
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            // Step 2: Push current digit
            stack.push(ch);
        }

        // Step 3: If still k > 0, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Step 4: Convert stack to string
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        // Step 5: Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Step 6: Handle empty result
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
