package Algorithm.twopointer;

/*
===========================================================
🧩 Problem: Lexicographically Largest String Merge
===========================================================
📅 Solved On: 20-04-2025
🔁 Revision Due: 27-04-2025
===========================================================

📝 Problem Statement:
word1 aur word2 diye hain. Har step pe dono mein se
kisi ek ka first character merge mein add karo.
Lexicographically LARGEST merge return karo.

Example:
Input:  word1="dacaa", word2="dbaaa"  →  Output: "ddbacaaaaa"

-----------------------------------------------------------
💡 Approach: Two Pointer + String Comparison

i → word1 ka current position
j → word2 ka current position

Har step pe:
→ word1[i..end] aur word2[j..end] compare karo
→ Jo string BADI ho, uska first char lo
→ Equal hone pe kisi se bhi lo (word1 prefer karo)

-----------------------------------------------------------
🧠 Key Ideas:
→ Sirf word1[i] vs word2[j] compare mat karo!
  "dacaa" vs "dbaaa" → pehla char same 'd'
  aage dekhna padega → isliye FULL REMAINING STRING compare
→ Java mein substring(i).compareTo(substring(j)) kaam karta hai
→ Yeh greedy approach hai — har step pe best choice lo

-----------------------------------------------------------
🔁 Dry Run: word1="dacaa", word2="dbaaa"

i=0,j=0: "dacaa" vs "dbaaa" → d==d, a<b → word2 → merge="d"
i=0,j=1: "dacaa" vs "baaa"  → d>b → word1 → merge="dd"
i=1,j=1: "acaa"  vs "baaa"  → a<b → word2 → merge="ddb"
i=1,j=2: "acaa"  vs "aaa"   → a==a, c>a → word1 → merge="ddba"
i=2,j=2: "caa"   vs "aaa"   → c>a → word1 → merge="ddbac"
i=3,j=2: "aa"    vs "aaa"   → equal → word1 → merge="ddbaca"
i=4,j=2: "a"     vs "aaa"   → equal → word1 → merge="ddbacaa"
i=5,j=2: word1 khatam → word2 se baaki → merge="ddbacaaaaa" ✅

-----------------------------------------------------------
⏱ TC: O(n²) — har step mein substring compare O(n)
📦 SC: O(n) — merge string

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Sirf word1[i]==word2[j] compare kyun GALAT hai?
[ ] Remaining string compare kyun karna padta hai?
[ ] Dry run: word1="a", word2="b" → expected "ba"
[ ] Dry run: word1="abc", word2="abc" → expected "aabbcc"

===========================================================
*/

public class LexicographicallyLargestStringMerge {

    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {

            // Remaining strings compare karo — sirf ek char nahi!
            String rem1 = word1.substring(i);
            String rem2 = word2.substring(j);

            if (rem1.compareTo(rem2) >= 0) {
                // word1 bada ya equal hai → word1 se lo
                merge.append(word1.charAt(i));
                i++;
            } else {
                // word2 bada hai → word2 se lo
                merge.append(word2.charAt(j));
                j++;
            }
        }

        // Bacha hua append kar do
        while (i < word1.length()) {
            merge.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            merge.append(word2.charAt(j++));
        }

        return merge.toString();
    }

    public static void main(String[] args) {
        LexicographicallyLargestStringMerge sol =
                new LexicographicallyLargestStringMerge();

        System.out.print("Test 1: ");
        System.out.println(sol.largestMerge("dacaa", "dbaaa")); // ddbacaaaaa

        System.out.print("Test 2: ");
        System.out.println(sol.largestMerge("a", "b")); // ba

        System.out.print("Test 3: ");
        System.out.println(sol.largestMerge("abc", "abc")); // aabbcc
    }
}
