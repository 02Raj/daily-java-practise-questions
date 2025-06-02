package neetcode.slidingwindow;
/**
 * Leetcode: Best Time to Buy and Sell Stock
 * Difficulty: Easy
 *
 * Problem:
 * Tumhe ek array diya gaya hai jisme prices[i] NeetCoin ka price hai i-th day par.
 * Tumhe ek hi baar buy aur sell karne ka option hai — ek din buy karo aur kisi future din becho.
 * Maksimum profit return karo. Agar profit possible nahi hai toh 0 return karo.
 *
 * Example:
 * Input: [10,1,5,6,7,1] => Output: 6  (Buy at 1, Sell at 7)
 * Input: [10,8,7,5,2]   => Output: 0  (No profitable transaction)
 *
 * Constraints:
 * 1 <= prices.length <= 100
 * 0 <= prices[i] <= 100
 */

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {10, 1, 5, 6, 7, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }

    /**
     * Approach (Tarika):
     * Ek hi pass mein solve karenge. Har step pe minimum price track karenge
     * aur har din ke price se max profit calculate karte rahenge.
     *
     * Time Complexity: O(n) – ek baar loop chalana hai
     * Space Complexity: O(1) – koi extra space use nahi kar rahe
     */
    public static int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else {
                int profit = prices[i] - min_price;
                max_profit = Math.max(max_profit, profit);
            }
        }

        return max_profit;
    }
}

