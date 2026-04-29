package Algorithm.twopointer;

import java.util.ArrayList;
import java.util.List;

/*
===========================================================
🧩 Problem: Camel Match
===========================================================
🔗 LeetCode: https://leetcode.com/problems/camelcase-matching/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
Query strings ka pattern se match check karo.
Query match hogi agar:
→ Pattern ke saare chars query mein same order mein hain
→ Query mein extra UPPERCASE chars allowed nahi!
→ Extra lowercase chars allowed hain

Example:
queries=["FooBar","FooBarTest"], pattern="FB"
FooBar    → F...B... → F aur B match ✅ (o,a,r extra lowercase = ok)
FooBarTest → extra T uppercase ❌

-----------------------------------------------------------
💡 Approach: Two Pointer

Main idea:
→ Query ke har char pe:
  1. Pattern se match karta hai? → p aage badho
  2. Uppercase hai aur match nahi? → FALSE!
  3. Lowercase hai aur match nahi? → Skip (ok hai)
→ End mein p == pattern.length() hona chahiye

-----------------------------------------------------------
🧠 Key Ideas:
→ Uppercase = strict! Pattern mein hona zaroori
→ Lowercase = flexible, extra allowed
→ p = pattern pointer
→ End mein p poore pattern tak pahuncha? = match!

-----------------------------------------------------------
🔁 Dry Run: query="FooBar", pattern="FB"

i=0, qChar=F: p=0, F==F(pattern[0]) → p=1
i=1, qChar=o: p=1, o!=B, lowercase → skip
i=2, qChar=o: skip
i=3, qChar=B: p=1, B==B(pattern[1]) → p=2
i=4, qChar=a: skip
i=5, qChar=r: skip

p=2 == pattern.length()=2 → TRUE ✅

-----------------------------------------------------------
🔁 Dry Run: query="FooBarTest", pattern="FB"

i=0, F→p=1
i=1,2,3 o,o,B → B matches p=2
i=4,5 a,r → skip
i=6, T → UPPERCASE! p=2, pattern[2] nahi hai → FALSE ❌

-----------------------------------------------------------
⏱ TC: O(n×m)   📦 SC: O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Uppercase extra kyun allowed nahi?
[ ] Lowercase extra kyun allowed hai?
[ ] p == pattern.length() end mein kyun check?
[ ] Dry run: query="FooBar", pattern="FoBr"
[ ] Dry run: query="football", pattern="fb"

===========================================================
*/

public class CamelMatch {

    public List<Boolean> camelMatch(String[] queries,
                                    String pattern) {
        List<Boolean> answer = new ArrayList<>();

        // Har query ko pattern se match karo
        for (int i = 0; i < queries.length; i++) {
            answer.add(isMatch(queries[i], pattern));
        }

        return answer;
    }

    private boolean isMatch(String query, String pattern) {

        // p = pattern ka pointer
        // Kitna pattern match hua track karta hai
        int p = 0;

        for (int i = 0; i < query.length(); i++) {
            char qChar = query.charAt(i);

            if (p < pattern.length()
                    && qChar == pattern.charAt(p)) {
                // Pattern ka char match ho gaya!
                // Pattern mein aage badho
                p++;

            } else if (Character.isUpperCase(qChar)) {
                // Uppercase char hai
                // Pattern se match nahi hua → INVALID!
                // Extra uppercase allowed nahi!
                return false;

            }
            // Lowercase aur pattern se match nahi?
            // Skip karo → lowercase extra allowed hai!
        }

        // Poora pattern match hua?
        // p pattern ki end tak pahuncha = TRUE
        // Beech mein ruk gaya = FALSE
        return p == pattern.length();
    }

    public static void main(String[] args) {
        CamelMatch sol = new CamelMatch();

        // Test 1: Classic case
        System.out.print("Test 1: ");
        System.out.println(sol.camelMatch(
                new String[]{"FooBar", "FooBarTest",
                        "FootBall", "FrameBuffer",
                        "ForceFeedBack"},
                "FB"
        )); // Expected: [true,false,true,true,false]

        // Test 2: Simple match
        System.out.print("Test 2: ");
        System.out.println(sol.camelMatch(
                new String[]{"FooBar"},
                "FoBr"
        )); // Expected: [false]

        // Test 3: All lowercase extra
        System.out.print("Test 3: ");
        System.out.println(sol.camelMatch(
                new String[]{"football"},
                "fb"
        )); // Expected: [true]
    }
}