package stack;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = arr.length;

        // Step 1: NGE array banao
        int[] nge = new int[n];
        Arrays.fill(nge, n); // default: agar koi next greater nahi mila toh end (n)

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // stack se chhote elements hata do
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        // Step 2: Sliding window maximum calculate karo
        int[] ans = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i <= n - k; i++) {
            // j ko at least current window ke andar le aao
            if (j < i) {
                j = i;
            }

            // jab tak j window ke andar hai aur uske aage aur bada element bhi window ke andar hai
            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans[i] = arr[j]; // window ka maximum
        }

        // Print answer
        System.out.println(Arrays.toString(ans));
    }
}