package stack;

import java.util.Stack;

// Class solving Trapping Rain Water problem
public class TrappingRainWater {

    // Function to calculate total trapped water
    int trap(int[] height) {
        int n = height.length;

        // WHY: If there are 0 or 1 bars, no water can be trapped
        if (n <= 1) return 0;

        int totalWater = 0;                // Initialize total trapped water to 0
        Stack<Integer> stack = new Stack<>(); // Stack stores indices of bars (potential boundaries)

        // HOW: Loop through every bar in the elevation map
        for (int i = 0; i < n; i++) {

            // WHY: Water can only be trapped if current bar is higher than previous lower bars
            // HOW: Check top of stack (last seen bar). While current bar is higher, we found a container
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottom = stack.pop();  // WHAT: Pop the bottom bar; this is the “valley” where water can collect

                // WHY: If stack becomes empty after popping, no left boundary exists, so break
                if (stack.isEmpty()) break;

                int left = stack.peek();    // WHAT: Left boundary index (bar to the left of bottom)
                int right = i;              // WHAT: Right boundary index (current bar)

                // HOW: Distance between left and right boundaries (number of positions where water can be trapped)
                int distance = right - left - 1;

                // HOW: Height of water trapped above bottom
                // WHY: Water can only rise up to the shorter of left/right minus bottom height
                int boundedHeight = Math.min(height[left], height[right]) - height[bottom];

                // WHAT: Area of trapped water = distance * boundedHeight
                totalWater += distance * boundedHeight;
            }

            // WHY: Current bar may serve as left boundary for future valleys, so push its index to stack
            stack.push(i);
        }

        // WHAT: Return the total trapped water after scanning all bars
        return totalWater;
    }

    // MAIN function to test the trap function
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Sample elevation map: array of bar heights
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // HOW & WHAT: Call trap() and print result
        // WHY: Shows total units of water trapped after raining
        System.out.println("Trapped Water: " + solution.trap(height)); // Expected: 6
    }
}
