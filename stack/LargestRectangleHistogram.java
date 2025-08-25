package stack;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();  // yaha hum ek stack banate hain jisme indexes store karenge
        int maxArea = 0;                       // rectangle ka max area track karne ke liye
        int n = heights.length;                // heights array ka size

        // loop chalate hain 0 se n tak (n included kyonki last mein cleanup karna hai)
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            // agar i == n hai toh h = 0 set karte hain (taaki stack clean ho jaye aur baki bache hue rectangles process ho jayein)

            // jab tak current height (h) chhoti hai stack ke top ki height se
            // iska matlab ab rectangle yahin tak ban sakta hai, usko calculate karo
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];  // stack ka top nikala, uski height li

                // width calculate karte hain
                // agar stack empty ho gaya toh iska matlab yeh height shuru se lekar i-1 tak extend ho rahi thi
                // warna width = (i - stack.peek() - 1) hoga
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                // ab area = height * width nikalte hain
                maxArea = Math.max(maxArea, height * width);
            }

            // current index ko stack mein daal dete hain
            stack.push(i);
        }

        return maxArea;  // sabse bada rectangle ka area return karte hain
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};  // histogram bars ki height
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
        // Output: 10 (5 aur 6 ki bar se rectangle banta hai width=2, height=5 => area = 10)
    }
}