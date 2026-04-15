package striver_sde_sheet.array;

import java.util.*;

/*
===========================================================
🧩 Problem: Majority Element II
===========================================================
🔗 LeetCode: https://leetcode.com/problems/majority-element-ii/
📅 Solved On: 15-04-2025
🔁 Revision Due: 22-04-2025
===========================================================

📝 Problem Statement:
Given an integer array of size n, find ALL elements that
appear MORE THAN ⌊n/3⌋ times.

Example:
Input:  nums = [3,2,3]           →  Output: [3]
Input:  nums = [1,2]             →  Output: [1,2]
Input:  nums = [1,1,1,3,3,2,2,2] → Output: [1,2]

-----------------------------------------------------------
🔄 Pehli Problem Se Kya Badla? (Must Read!)

          | Majority Element I    | Majority Element II
----------|----------------------|----------------------
Threshold | n/2                  | n/3
Answer    | Sirf 1 element       | 0, 1, ya 2 elements
Return    | int                  | List<Integer>
Early     | ✅ Possible          | ❌ Nahi — sab check
Return?   | (ek milte hi return) |   karne padte hain

-----------------------------------------------------------
🧠 Sabse Pehle Yeh Samjho — Max 2 Answers Kyun?

Socho logically:
→ Agar 3 elements hote jo n/3 se ZYADA baar aate, toh:
   count1 > n/3
   count2 > n/3
   count3 > n/3
   Total  > n/3 + n/3 + n/3 = n

→ Lekin array mein sirf n elements hain!
→ CONTRADICTION! Toh 3 aisa elements ho hi NAHI sakte.
→ Therefore: answer mein hamesha MAX 2 elements honge ✅

Pattern yaad rakho:
  n/2 threshold → max 1 answer  (Problem I)
  n/3 threshold → max 2 answers (Problem II)
  n/4 threshold → max 3 answers (Pattern!)

-----------------------------------------------------------
💡 Approach (HashMap — Frequency Count):

Main idea:
→ Pehle POORE array ki frequency count karo HashMap mein
→ Phir check karo — jiska count > n/3, woh result mein jaayega

Step 1: threshold = n / 3 calculate karo

Step 2: Poora array traverse karo:
        → freqMap mein har element ki count badhao

Step 3: freqMap ke entries check karo:
        → Agar count > threshold → result list mein add karo

Step 4: result return karo

⚠️  Pehli problem mein loop ke andar hi check karte the (early return)
    Yahan DO ALAG loops chahiye — kyun?
    Kyunki ek element n/3 bar aane ke baad bhi
    AAGE aa sakta hai — sab count hone chahiye pehle!

-----------------------------------------------------------
🔁 Dry Run: [1, 1, 1, 3, 3, 2, 2, 2]  →  n=8, threshold=2

Step 1 — Frequency Count:
  num=1 → {1=1}
  num=1 → {1=2}
  num=1 → {1=3}
  num=3 → {1=3, 3=1}
  num=3 → {1=3, 3=2}
  num=2 → {1=3, 3=2, 2=1}
  num=2 → {1=3, 3=2, 2=2}
  num=2 → {1=3, 3=2, 2=3}

Final freqMap: {1=3, 3=2, 2=3}

Step 2 — Check threshold (count > 2):
  1 → count=3 → 3>2 ✅ → result add
  3 → count=2 → 2>2 ❌ → skip
  2 → count=3 → 3>2 ✅ → result add

👉 Answer: [1, 2] ✅

-----------------------------------------------------------
🔁 Dry Run: [1, 2]  →  n=2, threshold=0

freqMap: {1=1, 2=1}

Check threshold (count > 0):
  1 → count=1 → 1>0 ✅ → result add
  2 → count=1 → 1>0 ✅ → result add

👉 Answer: [1, 2] ✅

-----------------------------------------------------------
⏱ Time Complexity (TC):

Loop 1 (frequency count) → O(n)
Loop 2 (map traversal)   → O(n) worst case (n distinct elements)

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

HashMap mein at most n distinct elements → O(n)
Result list mein at most 2 elements      → O(1)

👉 SC = O(n)

-----------------------------------------------------------
💡 Better Approach (Bonus — Extended Moore's Voting):

→ O(n) time aur O(1) space mein solve hota hai
→ Pehli problem mein 1 candidate track karte the
→ Yahan 2 candidates track karte hain (kyunki max 2 answers!)
→ Aage is approach ko bhi seekhna — extended Moore's Voting!

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] n/3 threshold pe max 2 answers kyun? (Proof explain karo)
[ ] Pehli problem mein early return tha — yahan kyun nahi kar sakte?
[ ] Dry run: [3,2,3] → expected [3]
[ ] Dry run: [1,2] → expected [1,2]
[ ] threshold = n/3 hai, toh [1,1] (n=2) mein threshold=0, count=2 > 0 ✅
[ ] Extended Moore's Voting se kaise solve hoga? (2 candidates)

===========================================================
*/

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // Pehli problem mein n/2 tha — ab n/3 hai
        int threshold = n / 3;

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 1: Poore array ki frequency count karo
        // (Pehli problem mein loop ke andar hi check karte the — early return)
        // (Yahan pehle SARI frequencies count karni hain, phir check)
        for (int num : nums) {
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);
        }

        // Step 2: Ab check karo kaun threshold cross karta hai
        // Pehli problem mein: ek int return karte the
        // Yahan: List mein add karo — 0, 1, ya 2 elements ho sakte hain
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Test 1: Sirf ek majority element
        int[] arr1 = {3, 2, 3};
        System.out.println("Test 1: " + majorityElement(arr1)); // Expected: [3]

        // Test 2: Single element — khud hi majority hai
        int[] arr2 = {1};
        System.out.println("Test 2: " + majorityElement(arr2)); // Expected: [1]

        // Test 3: Dono elements qualify karte hain
        int[] arr3 = {1, 2};
        System.out.println("Test 3: " + majorityElement(arr3)); // Expected: [1, 2]

        // Test 4: Do alag majority elements
        int[] arr4 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Test 4: " + majorityElement(arr4)); // Expected: [1, 2]

        // Test 5: Koi bhi qualify nahi karta (theoretically possible)
        int[] arr5 = {1, 2, 3};
        System.out.println("Test 5: " + majorityElement(arr5)); // Expected: []
    }
}