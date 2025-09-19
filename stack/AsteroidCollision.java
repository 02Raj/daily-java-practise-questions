package stack;

import java.util.Stack;

/**
 * Question: Asteroid Collision (LeetCode 735)
 *
 * Problem Statement:
 * -------------------
 * Ek array `asteroids[]` diya hai jo ek row me asteroids ko represent karta hai.
 *  - Absolute value = asteroid ka size
 *  - Sign (+ / -) = direction (positive = right, negative = left)
 *
 * Har asteroid same speed se move karta hai.
 *
 * Collision Rules:
 * ----------------
 * 1. Agar ek asteroid right ja raha hai (positive) aur agla left aa raha hai (negative),
 *    to takraenge ✅
 * 2. Agar dono takraaye:
 *      - Chhota size wala destroy ho jayega
 *      - Agar size equal → dono destroy
 *      - Agar same direction → kabhi takraenge hi nahi
 *
 * Output: Collision ke baad final bache hue asteroids return karo.
 *
 * Example 1:
 * ----------
 * Input:  [5,10,-5]
 * Step:   10 vs -5 → 10 bacha
 * Output: [5,10]
 *
 * Example 2:
 * ----------
 * Input:  [8,-8]
 * Step:   8 vs -8 → dono destroy
 * Output: []
 *
 * Example 3:
 * ----------
 * Input:  [10,2,-5]
 * Step:   2 vs -5 → -5 bacha
 *         10 vs -5 → 10 bacha
 * Output: [10]
 *
 * --------------------------------------------------------
 * Approaches:
 * --------------------------------------------------------
 * 1. Brute Force:
 *    - Har asteroid ke liye next asteroids check karo → collisions simulate karo.
 *    - Complexity O(n^2), bada input slow.
 *
 * 2. Optimal (Stack Approach) O(n):
 *    - Stack use karo jo "currently safe asteroids" ko store karega.
 *    - Jab ek naya asteroid aata hai:
 *        - Agar stack empty hai → push
 *        - Agar direction same hai (both + or both -) → push
 *        - Agar stack.top positive aur current negative → collision hoga
 *             * Compare size (absolute value)
 *             * Chhota destroy, bada bacha
 *             * Equal ho to dono destroy
 *             * Jab tak collisions ho rahe hain, loop chalate raho
 *    - End me stack me jo bache wahi answer hai.
 *
 * WHY Stack?
 * ----------
 *  - Kyunki hamesha sirf "pichle asteroid" (last safe one) ke saath hi naya asteroid collide karega.
 *  - Isliye stack best data structure hai.
 *
 * Formula / Trick:
 * ----------------
 *  - Only collide when: stack.top > 0 (right ja raha hai) AND asteroid < 0 (left aa raha hai)
 *  - Collision Outcome:
 *        |top| < |curr| → pop top (curr abhi bhi alive hai)
 *        |top| == |curr| → pop top (curr bhi destroy)
 *        |top| > |curr| → curr destroy (alive = false)
 *
 * Intuition:
 * ----------
 * - Collision sirf tab hoga jab ek right moving asteroid ke baad ek left moving aaye.
 * - Sirf "last asteroid" ke saath hi collision possible hai → isliye stack use karte hain.
 * - Rules:
 *    1. Agar top ka size chhota hai → top destroy, curr alive
 *    2. Agar top == curr → dono destroy
 *    3. Agar top > curr → curr destroy
 * - Agar koi collision nahi hua → push curr to stack.
 */

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // Loop through all asteroids
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i]; // current asteroid
            boolean alive = true;        // flag to check if current asteroid survives

            // WHILE: Check collisions
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && alive) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(asteroid)) {
                    // WHY: Top chhota hai → destroy ho jayega
                    stack.pop();
                    // asteroid abhi bhi zinda hai → loop continue
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    // WHY: Same size → dono destroy
                    stack.pop();
                    alive = false; // current bhi destroy
                } else {
                    // WHY: Top bada hai → current asteroid destroy
                    alive = false;
                }
            }

            // Agar abhi bhi asteroid alive hai to stack me push kar do
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert Stack → int[]
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
