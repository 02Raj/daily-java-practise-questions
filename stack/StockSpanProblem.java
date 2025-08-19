package stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int span[] = new int[n];

        calculateSpan(prices, n, span);

        // Output
        System.out.println("Day wise Stock Span:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }

    // Function to calculate stock span
    static void calculateSpan(int price[], int n, int span[]) {
        // Stack store karega index (day ka number)
        Stack<Integer> st = new Stack<>();

        // Pehle din ka span hamesha 1 hota hai
        span[0] = 1;
        st.push(0); // pehla index dal diya stack mein

        // Traverse all days
        for (int i = 1; i < n; i++) {
            // Jab tak stack empty nahi ho jata aur
            // current price >= price at stack top, pop karte jao
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            // Agar stack empty ho gaya → iska matlab current price sabse bada hai ab tak
            // span = i+1 (kyunki 0-based index hai)
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Warna span = current day index - last greater element ka index
                span[i] = i - st.peek();
            }

            // Current index ko stack mein push kar do
            st.push(i);
        }
    }
}
