package frequently_asked_dsa.array;

import java.util.Arrays;

/*
 * LEETCODE 121 - BEST TIME TO BUY AND SELL STOCK (Easy)
 * -----------------------------------------------------
 *
 * PROBLEM STATEMENT:
 * prices[i] = day i par stock ki price.
 * Ek din BUY aur uske BAAD kisi future day par SELL karke maximum profit
 * return karna hai. Sirf one transaction allowed hai: one buy + one sell.
 * Agar profit possible nahi hai, 0 return karo.
 *
 * Example:
 * prices = [7, 1, 5, 3, 6, 4]
 * Buy at 1, sell at 6 -> maximum profit = 5.
 *
 * IMPORTANT:
 * Pehle sell aur baad mein buy nahi kar sakte. Array ko left-to-right process
 * karna isi time-order rule ko automatically maintain karta hai.
 *
 * =================================================================
 * SABSE IMPORTANT INTUITION - "AAJ SELL KARUN TO BEST BUY KYA THA?"
 * =================================================================
 * Har current price ko possible SELL price samjho.
 * Usse pehle dekhi hui sabse kam price ko BUY price rakho.
 *
 * currentProfit = today's price - minimum price seen so far
 * maxProfit     = best profit seen so far
 *
 * Memory story:
 * - minPrice = ab tak ka sabse sasta buying chance
 * - maxProfit = ab tak ki sabse achhi deal
 *
 * Memory line:
 *      "Past ka minimum buy yaad rakho, aaj bechne ka profit check karo."
 *
 * =================================================================
 * APPROACH 1 - BRUTE FORCE
 * =================================================================
 * Har buy day i ke saath har future sell day j check karo.
 * j = i + 1 rakhenge, isliye sell hamesha buy ke baad hoga.
 *
 * Time Complexity  : O(n^2)
 * Space Complexity : O(1)
 *
 * =================================================================
 * APPROACH 2 - ONE PASS / RUNNING MINIMUM (OPTIMIZED)
 * =================================================================
 * 1. minPrice ko bahut badi value se initialize karo.
 * 2. Left-to-right har price visit karo.
 * 3. Nayi lower price mile -> minPrice update karo.
 * 4. Otherwise, current price par sell karne ka profit calculate karo.
 * 5. maxProfit ko maximum profit se update karo.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 *
 * =================================================================
 * SMALL DRY RUN
 * =================================================================
 * prices = [7, 1, 5, 3, 6, 4]
 *
 * price | minPrice | currentProfit | maxProfit
 *   7   |    7     |      -        |    0
 *   1   |    1     |      -        |    0
 *   5   |    1     |    5-1=4      |    4
 *   3   |    1     |    3-1=2      |    4
 *   6   |    1     |    6-1=5      |    5
 *   4   |    1     |    4-1=3      |    5
 *
 * Answer = 5.
 *
 * Falling case [7,6,4,3,1]: minPrice baar-baar kam hota rahega, lekin koi
 * positive profit nahi milega. maxProfit 0 hi rahega, so answer 0.
 *
 * =================================================================
 * KEY TO REMEMBER ALWAYS
 * =================================================================
 * "Har day ko SELL day samjho; usse pehle ka cheapest BUY yaad rakho."
 *
 * Common mistakes:
 * - future ki minimum price se current day par sell karna (order invalid);
 * - array sort kar dena (days ka order destroy ho jayega);
 * - maxProfit ko negative banana, jab no transaction ka answer 0 hai;
 * - multiple buy/sell transactions karna (is problem mein only one allowed);
 * - minPrice ke jagah previous-day price se compare karna (global best miss hoga).
 */
public class BestTimeToBuyAndSellStock {

    /** Brute-force learning version. */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < prices.length - 1; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                int profit = prices[sellDay] - prices[buyDay];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    /** Optimized LeetCode submission method. */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Aaj tak ka sabse cheap buying opportunity mila.
                minPrice = price;
            } else {
                // Aaj sell karein to kitna profit hoga?
                int currentProfit = price - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }

    /*
     * Important test categories: normal profit, continuously falling prices,
     * single day, two days, flat prices, late minimum, and large late profit.
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        runTest(solution, new int[]{7, 1, 5, 3, 6, 4}, 5);
        runTest(solution, new int[]{7, 6, 4, 3, 1}, 0);
        runTest(solution, new int[]{1}, 0);
        runTest(solution, new int[]{1, 2}, 1);
        runTest(solution, new int[]{2, 1}, 0);
        runTest(solution, new int[]{3, 3, 3, 3}, 0);
        runTest(solution, new int[]{2, 4, 1}, 2);
        runTest(solution, new int[]{3, 2, 6, 5, 0, 3}, 4);

        System.out.println("All Best Time to Buy and Sell Stock tests passed.");
    }

    private static void runTest(BestTimeToBuyAndSellStock solution,
                                int[] prices,
                                int expected) {
        int optimizedActual = solution.maxProfit(prices);
        int bruteForceActual = solution.maxProfitBruteForce(prices);

        if (optimizedActual != expected || bruteForceActual != expected) {
            throw new AssertionError(
                    "Failed for prices=" + Arrays.toString(prices)
                            + ", expected=" + expected
                            + ", optimized=" + optimizedActual
                            + ", bruteForce=" + bruteForceActual);
        }

        System.out.println("PASS prices=" + Arrays.toString(prices)
                + " -> " + optimizedActual);
    }
}
