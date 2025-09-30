package stack;

import java.util.Stack;

public class StockSpanner {

    /**
     * QUESTION:
     * - Design a class StockSpanner that calculates stock span online.
     * - Every time we call next(price), it should return the span of that day's price.
     * - Span = number of consecutive days (including today) for which stock price <= today's price.
     *
     * Example:
     * Input: [100, 80, 60, 70, 60, 75, 85]
     * Output: [1,   1,  1,  2,  1,  4,  6]
     */

    // Stack will store pairs: [price, span]
    private Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    /**
     * INTUITION / STORY:
     * - Imagine a histogram: every day you want to know how far back you can go
     *   while prices are <= current price.
     * - Instead of going back one by one (O(n)), we merge previous spans.
     * - So when we pop from stack, we don't just remove that day's price,
     *   we also add its whole span at once. (Span compression)
     *
     * FORMULA:
     * span = 1 (today) + sum of spans of consecutive days with price <= current.
     *
     * APPROACH:
     * - Maintain a monotonic decreasing stack of [price, span].
     * - While current price >= stack top price:
     *      pop and add its span.
     * - Push (current price, total span).
     * - Return span.
     *
     * TRICK:
     * - Stack doesn’t store all days, only "useful" days (previous greater elements).
     * - Instead of storing indices, we store (price, span) → efficient merging.
     *
     * KEY POINTS:
     * - Each element pushed once and popped once → amortized O(1).
     * - Stack always decreasing in terms of price.
     *
     * TIME COMPLEXITY:
     * - Amortized O(1) per query (worst-case O(n) for one call,
     *   but across n calls total O(n)).
     *
     * SPACE COMPLEXITY:
     * - O(n) in worst case (when prices are strictly decreasing).
     */
    public int next(int price) {
        int span = 1; // minimum span = 1 (today itself)

        // Merge all smaller/equal prices
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1]; // add their span
        }

        // Push current price with its span
        st.push(new int[]{price, span});

        return span;
    }

    // Testing the implementation
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}
