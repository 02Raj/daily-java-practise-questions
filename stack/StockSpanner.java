package stack;

import java.util.Stack;

public class StockSpanner {

    // Stack will store pairs of (price, span)
    private Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1; // minimum span = 1 (today itself)

        // jab tak stack mein prices <= current price hain, unhe merge kar lo
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1]; // add their span
        }

        // current price with its span ko stack mein push karo
        st.push(new int[]{price, span});

        return span;
    }

    // 👇 main method for testing
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
