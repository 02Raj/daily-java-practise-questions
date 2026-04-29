package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Best Time to Buy and Sell Stock
===========================================================
🔗 LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
📅 Solved On: 13-04-2025
🔁 Revision Due: 20-04-2025
===========================================================

📝 Problem Statement:
Ek array prices[] diya gaya hai jahan prices[i] = stock ka
price i-th din pe.
Tujhe max profit kamana hai — ek hi baar buy aur ek hi baar
sell kar sakta hai.
Agar koi profit nahi ho sakta toh 0 return karo.

Example:
Input:  prices = [7,1,5,3,6,4]  →  Output: 5  (buy=1, sell=6)
Input:  prices = [7,6,4,3,1]    →  Output: 0  (no profit possible)
Input:  prices = [2,4,1]        →  Output: 2  (buy=2, sell=4)

-----------------------------------------------------------
💡 Approach (Optimal — One Pass Greedy):

Main idea:
→ Ek hi pass mein do cheezein track karo:
  1. Ab tak ka sabse chhota price (min_price) — best buy day
  2. Ab tak ka max profit (max_profit)

Step 1: Agar current price < min_price hai
        → min_price update karo (aaj buy karna better hai)

Step 2: Warna profit calculate karo
        → profit = prices[i] - min_price
        → max_profit = Math.max(profit, max_profit)

Key Insight:
→ Sell hamesha buy ke BAAD hoti hai
→ Isliye left se right jaao — min_price hamesha current
  index se pehle ka hoga (valid buy day guaranteed)

-----------------------------------------------------------
🧠 Key Ideas (Must Remember):
→ min_price = Integer.MAX_VALUE se start karo (koi bhi
  pehla element min ban jaayega)
→ max_profit = 0 se start karo (worst case: no transaction)
→ Ek hi pass mein solve hota hai — O(n)
→ DP approach se bhi solve hota hai (practice ke liye)
→ Yeh problem "Best Time II" se alag hai — wahan multiple
  transactions allowed hain

-----------------------------------------------------------
🔁 Dry Run: [7, 1, 5, 3, 6, 4]

i | price | min_price | profit | max_profit | Action
--|-------|-----------|--------|------------|------------------
0 |   7   |     7     |   -    |     0      | New min
1 |   1   |     1     |   -    |     0      | New min
2 |   5   |     1     |   4    |     4      | Profit updated
3 |   3   |     1     |   2    |     4      | No change
4 |   6   |     1     |   5    |     5      | Profit updated ← MAX
5 |   4   |     1     |   3    |     5      | No change

👉 Answer: 5  (Buy at 1, Sell at 6)

-----------------------------------------------------------
⏱ Time Complexity (TC):

Single pass through array → O(n)

👉 Final TC = O(n)

-----------------------------------------------------------
📦 Space Complexity (SC):

Sirf 2 variables — min_price aur max_profit

👉 SC = O(1)

-----------------------------------------------------------
🔁 Revision Checklist:
[ ] min_price ko Integer.MAX_VALUE se kyun initialize karte?
[ ] max_profit ko 0 se kyun initialize karte (not MIN_VALUE)?
[ ] All-decreasing array mein kya hoga? e.g. [7,6,4,3,1] → 0
[ ] Dry run: [2,4,1] → expected 2
[ ] Dry run: [1,2] → expected 1
[ ] Is approach mein sell before buy kyun nahi hoga?

===========================================================
*/

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        // Integer.MAX_VALUE isliye — taaki pehla element
        // hamesha min_price ban jaaye
        int min_price = Integer.MAX_VALUE;

        // 0 isliye — agar koi profitable day na mile,
        // toh 0 return karo (no transaction = no loss)
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min_price) {
                // Aaj ka price sabse sasta hai — best buy day
                min_price = prices[i];
            } else {
                // Aaj sell karne se kitna profit? Check karo
                int profit = prices[i] - min_price;
                max_profit = Math.max(profit, max_profit);
            }
        }

        return max_profit;
    }

    // 🔥 MAIN METHOD (run from here)
    public static void main(String[] args) {

        // Test 1: Classic case
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        System.out.print("Test 1: ");
        System.out.println(maxProfit(arr1)); // Expected: 5

        // Test 2: All decreasing — no profit possible
        int[] arr2 = {7, 6, 4, 3, 1};
        System.out.print("Test 2: ");
        System.out.println(maxProfit(arr2)); // Expected: 0

        // Test 3: Buy then sell immediately next day
        int[] arr3 = {2, 4, 1};
        System.out.print("Test 3: ");
        System.out.println(maxProfit(arr3)); // Expected: 2

        // Test 4: Single element — can't trade
        int[] arr4 = {1};
        System.out.print("Test 4: ");
        System.out.println(maxProfit(arr4)); // Expected: 0
    }
}