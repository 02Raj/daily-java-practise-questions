package Algorithm.twopointer;

import java.util.Arrays;

/*
===========================================================
🧩 Problem: Heaters (Find Minimum Radius)
===========================================================
🔗 LeetCode: https://leetcode.com/problems/heaters/
📅 Solved On: 27-04-2025
🔁 Revision Due: 04-05-2025
===========================================================

📝 Problem Statement:
Houses aur heaters ek line pe hain.
Minimum radius kya ho jisse saare houses warm ho jayein?

Example:
Input: houses=[1,2,3], heaters=[2]   → Output: 1
Input: houses=[1,2,3,4], heaters=[1,4] → Output: 1
Input: houses=[1,5], heaters=[2]     → Output: 3

-----------------------------------------------------------
💡 Approach: Sort + Two Pointer (Greedy)

Main idea:
→ Har house ke liye CLOSEST heater dhundo
→ Us distance ko track karo
→ Sabse badi distance = minimum radius!

Kyun? Kyunki:
  Radius itna bada hona chahiye ki
  sabse door wala house bhi cover ho!

Step 1: Dono sort karo
Step 2: Har house ke liye:
        Current heater ya next heater?
        Jo closer ho usse lo!
Step 3: Maximum distance = answer!

-----------------------------------------------------------
🧠 Key Ideas:
→ Sort kyun? Greedy ke liye order chahiye
→ j pointer kabhi peeche nahi jaata
  (sorted hai toh pichla heater kabhi better nahi hoga)
→ nextDist <= currDist → next heater better ya equal
→ answer = max of all minimum distances

-----------------------------------------------------------
🔁 Dry Run: houses=[1,2,3,4], heaters=[1,4]

Sort: houses=[1,2,3,4], heaters=[1,4]
j=0 (heater=1)

house=1: curr=|1-1|=0, next=|4-1|=3 → 3>0 no move, dist=0
house=2: curr=|1-2|=1, next=|4-2|=2 → 2>1 no move, dist=1
house=3: curr=|1-3|=2, next=|4-3|=1 → 1<=2 j++, dist=1
house=4: curr=|4-4|=0, dist=0

answer = max(0,1,1,0) = 1 ✅

-----------------------------------------------------------
⏱ TC: O(n log n)   📦 SC: O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] Sort kyun karna zaroori hai?
[ ] j pointer peeche kyun nahi jaata?
[ ] Maximum distance kyun leni hai?
[ ] Dry run: houses=[1,5], heaters=[2] → 3
[ ] Dry run: houses=[1,2,3], heaters=[2] → 1

===========================================================
*/

public class FindRadius {

    public int findRadius(int[] houses, int[] heaters) {

        // Step 1: Dono sort karo
        // Greedy ke liye order zaroori hai!
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int j = 0;       // Heater pointer
        int answer = 0;  // Minimum radius track karo

        // Step 2: Har house ke liye closest heater dhundo
        for (int i = 0; i < houses.length; i++) {

            // Current heater se distance
            int currDist = Math.abs(heaters[j] - houses[i]);

            // Kya next heater closer hai?
            while (j + 1 < heaters.length) {
                int nextDist = Math.abs(heaters[j + 1] - houses[i]);

                if (nextDist <= currDist) {
                    // Next heater closer hai ya equal!
                    // Aage badho
                    j++;
                    currDist = nextDist;
                } else {
                    // Current heater better hai
                    // Aage mat badho
                    break;
                }
            }

            // Step 3: Sabse badi minimum distance = answer
            // Kyunki radius itna bada chahiye ki
            // sabse door wala house bhi cover ho!
            answer = Math.max(answer, currDist);
        }

        return answer;
    }

    public static void main(String[] args) {
        FindRadius sol = new FindRadius();

        // Test 1: Single heater middle mein
        System.out.print("Test 1: ");
        System.out.println(sol.findRadius(
                new int[]{1, 2, 3},
                new int[]{2}
        )); // Expected: 1

        // Test 2: Do heaters corners pe
        System.out.print("Test 2: ");
        System.out.println(sol.findRadius(
                new int[]{1, 2, 3, 4},
                new int[]{1, 4}
        )); // Expected: 1

        // Test 3: Heater door hai
        System.out.print("Test 3: ");
        System.out.println(sol.findRadius(
                new int[]{1, 5},
                new int[]{2}
        )); // Expected: 3
    }
}