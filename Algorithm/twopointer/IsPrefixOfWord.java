package Algorithm.twopointer;

/*
===========================================================
🧩 Problem: Is Prefix of Word
===========================================================
🔗 LeetCode: https://leetcode.com/problems/is-prefix-of-word/
📅 Solved On: 20-04-2025
🔁 Revision Due: 27-04-2025
===========================================================

📝 Problem Statement:
Given a sentence (words separated by spaces) and a searchWord,
return the 1-indexed position of the FIRST word in sentence
that has searchWord as a prefix.
Return -1 if no such word exists.

Example:
Input:  sentence = "i love eating burger", searchWord = "burg"  →  Output: 4
Input:  sentence = "i love eating burger", searchWord = "i"     →  Output: 1
Input:  sentence = "i love eating burger", searchWord = "none"  →  Output: -1

-----------------------------------------------------------
💡 Approach (Two Pointer / Manual Traversal):

Main idea:
→ Sentence ko word by word traverse karo — split() use mat karo
→ Har word ke saath searchWord ko char by char compare karo
→ Agar pura searchWord match ho jaaye → wordIndex return karo

Step 1: Outer loop — jab tak sentence khatam na ho, chalta rahe
Step 2: Inner loop — current word aur searchWord ke chars compare karo
        (4 conditions ek saath check hoti hain — ek bhi false → stop)
Step 3: Agar j == searchWord.length() → prefix mila → return wordIndex
Step 4: Skip loop — current word ke baaki bache chars skip karo
Step 5: i++ (space jump karo), wordIndex++ (next word)

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ wordIndex 1 se start hota hai (1-indexed answer chahiye)
→ Inner loop mein 4 conditions:
    1. i < n              (sentence boundary)
    2. sentence[i] != ' ' (word boundary — space pe ruko)
    3. j < searchWord.length() (searchWord boundary)
    4. sentence[i] == searchWord[j] (char match)
→ j == searchWord.length() check ZAROOR karo inner loop ke baad
→ Skip loop — agar match fail hua toh remaining word chars skip karo
→ start variable declare hua hai lekin use nahi hua — remove kar sakte ho

-----------------------------------------------------------
🔁 Dry Run: sentence = "i love burger", searchWord = "bu"

i=0, wordIndex=1, Word = "i"
  Inner Loop: 'i' != 'b' → MISMATCH → j=0
  j(0) != searchWord.length()(2) → no return
  Skip Loop: skip 'i' → i=1 (space)
  i++ → i=2, wordIndex=2

i=2, wordIndex=2, Word = "love"
  Inner Loop: 'l' != 'b' → MISMATCH → j=0
  j(0) != 2 → no return
  Skip Loop: skip 'l','o','v','e' → i=6 (space)
  i++ → i=7, wordIndex=3

i=7, wordIndex=3, Word = "burger"
  Inner Loop:
    'b'=='b' ✅ → i=8, j=1
    'u'=='u' ✅ → i=9, j=2
    j=2 == searchWord.length() → STOP
  j(2) == 2 → ✅ return wordIndex = 3

👉 Answer: 3

-----------------------------------------------------------
⏱ Time Complexity (TC):

Outer loop → O(n) — har char ek baar visit hota hai

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Koi extra array nahi, sirf variables (i, j, wordIndex)

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Inner loop mein 4 conditions kyun hain? Ek bhi hatao toh kya hoga?
[ ] Skip loop kyun zaroori hai? Bina iske kya problem hogi?
[ ] All words mismatch ho toh kya return hoga?
[ ] Dry run: "hello world" + searchWord = "wor" → expected 2
[ ] Dry run: "love me" + searchWord = "loved" → expected -1
[ ] start variable ka koi use hai? (Hint: nahi — dead code hai)

===========================================================
*/

public class IsPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length();
        int wordIndex = 1;
        int i = 0;

        while (i < n) {
            int j = 0;

            // Step 1: Current word ko searchWord se char by char compare karo
            // 4 conditions ek saath — ek bhi false → loop band
            while (i < n && sentence.charAt(i) != ' '
                    && j < searchWord.length()
                    && sentence.charAt(i) == searchWord.charAt(j)) {
                i++;
                j++;
            }

            // Step 2: Pura searchWord match ho gaya?
            if (j == searchWord.length()) {
                return wordIndex; // 1-indexed position return karo
            }

            // Step 3: Current word ke remaining chars skip karo
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }

            // Step 4: Space jump karo, next word pe jao
            i++;
            wordIndex++;
        }

        return -1; // Koi word prefix nahi tha
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {
        IsPrefixOfWord sol = new IsPrefixOfWord();

        // Test 1: Classic case
        System.out.print("Test 1: ");
        System.out.println(sol.isPrefixOfWord("i love eating burger", "burg")); // Expected: 4

        // Test 2: First word match
        System.out.print("Test 2: ");
        System.out.println(sol.isPrefixOfWord("i love eating burger", "i")); // Expected: 1

        // Test 3: No match
        System.out.print("Test 3: ");
        System.out.println(sol.isPrefixOfWord("i love eating burger", "none")); // Expected: -1

        // Test 4: searchWord longer than any word
        System.out.print("Test 4: ");
        System.out.println(sol.isPrefixOfWord("love me", "loved")); // Expected: -1

        // Test 5: Exact word match (prefix of itself)
        System.out.print("Test 5: ");
        System.out.println(sol.isPrefixOfWord("hello world", "wor")); // Expected: 2
    }
}