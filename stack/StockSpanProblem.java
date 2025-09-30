package stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        // QUESTION:
        // Given stock prices for N days, find the "Stock Span" for each day.
        // Span = consecutive days (including today)
        //        for which price <= today's price.
        //
        // Example: prices[] = {100, 80, 60, 70, 60, 75, 85}
        // Output span[]   = {1,   1,  1,  2,  1,  4,  6}

        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int span[] = new int[n];

        calculateSpan(prices, n, span);

        // OUTPUT
        System.out.println("Day wise Stock Span:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }

    /**
     * INTUITION / STORY:
     * - Imagine you stand on day 'i' with price[i].
     * - Look backwards until you find a higher price.
     * - Span[i] = distance between current day and that higher price.
     * - If no higher price exists, span[i] = i+1 (whole range from start).
     *
     * FORMULA:
     * span[i] = i - last_greater_element_index
     * if no greater element exists → span[i] = i+1
     *
     * APPROACH:
     * - Brute Force: For every day, check backwards → O(n^2).
     * - Optimized: Use Stack to keep track of indices of useful elements.
     *   Stack stores indices in *decreasing* order of price.
     *   → Each element pushed and popped at most once → O(n).
     *
     * KEY POINTS TO REMEMBER:
     * - Stack contains indices, not values (so that we can calculate span easily).
     * - If stack is empty → span = i+1.
     * - Else span = i - stack.peek().
     * - Always push current index after calculating span.
     *
     * TRICK:
     * - This is same as "Next Greater Element" type problems.
     * - Instead of finding *next*, we are using stack to find *previous greater*.
     *
     * TIME COMPLEXITY:
     * - O(n) → Each index is pushed and popped at most once.
     *
     * SPACE COMPLEXITY:
     * - O(n) → Stack stores at most n indices in worst case.
     */
    static void calculateSpan(int price[], int n, int span[]) {
        // Stack to store indices of days
        Stack<Integer> st = new Stack<>();

        // First day → span is always 1
        span[0] = 1;
        st.push(0); // push index 0

        // Traverse for remaining days
        for (int i = 1; i < n; i++) {

            // Pop elements until stack top has greater price
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            // If stack empty → no greater element on left
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // span = distance between current index and last greater price index
                span[i] = i - st.peek();
            }

            // Push current index in stack
            st.push(i);
        }
    }
}
