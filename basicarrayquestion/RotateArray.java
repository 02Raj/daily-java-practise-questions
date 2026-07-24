package basicarrayquestion;

/*
 * ====================================================================
 * PROBLEM STATEMENT:
 * ====================================================================
 * Ek array diya hai, usko "right" rotate karna hai by k positions.
 * Matlab last k elements front mein aa jayenge, baaki sab peeche shift honge.
 *
 * Example:
 * arr = {1, 2, 3, 4, 5, 6, 7}, k = 3
 * Output = {5, 6, 7, 1, 2, 3, 4}
 *
 * ====================================================================
 * WHY THIS PROBLEM IS IMPORTANT (pattern recognition ke liye):
 * ====================================================================
 * Jab bhi tumhe dikhe "rotate", "shift circular", "rearrange without extra space"
 * — dimaag mein turant "REVERSAL TRICK" aana chahiye. Ye ek classic array
 * pattern hai jo interviews mein baar baar ghoom phir ke aata hai
 * (rotate array, rotate matrix rows, string rotation check, etc.)
 */

public class RotateArray {

    /*
     * ====================================================================
     * BRUTE FORCE APPROACH (samajhne ke liye pehle ye socho)
     * ====================================================================
     * Intuition: Ek temp array bana lo, jo bhi element jaha jaana chahiye
     * uska naya index calculate karo formula se: newIndex = (i + k) % n
     * Fir temp array ko wapas original array mein copy kar do.
     *
     * Why it works: Har element ko uski sahi final position pe directly
     * daal rahe hain, bina kisi shifting ke.
     *
     * Time Complexity: O(n)   -> ek baar poora array traverse karte hain
     * Space Complexity: O(n)  -> extra temp array use ho raha hai
     *
     * Problem: Extra space chahiye, agar interviewer bole "in-place karo"
     * to ye approach reject ho jayegi. Isi wajah se optimal approach seekhna
     * zaroori hai (neeche wala reversal trick).
     *
     * private static void rotateBrute(int[] arr, int k) {
     *     int n = arr.length;
     *     k = k % n;
     *     int[] temp = new int[n];
     *     for (int i = 0; i < n; i++) {
     *         temp[(i + k) % n] = arr[i];   // har element ki nayi jagah
     *     }
     *     for (int i = 0; i < n; i++) {
     *         arr[i] = temp[i];             // copy back
     *     }
     * }
     */


    /*
     * ====================================================================
     * HELPER FUNCTION: reverse a portion of array (in-place)
     * ====================================================================
     * Ye ek generic utility hai — do pointers (left, right) leke
     * unko swap karte jao jab tak left < right.
     *
     * Isko yaad rakhne ka trick: "Do finger technique"
     * - ek finger left se start
     * - ek finger right se start
     * - dono ko andar ki taraf laate jao aur swap karte jao
     *
     * TC: O(range)  SC: O(1)  -> koi extra space nahi lagta
     */
    public static void reverse(int[] arr, int left , int right){
        while(left < right){
            int temp = arr[left];
            arr[left]= arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /*
     * ====================================================================
     * OPTIMAL APPROACH: "REVERSAL ALGORITHM" (in-place, O(1) space)
     * ====================================================================
     * INTUITION (ye wala part hamesha yaad rakhna, ye core trick hai):
     *
     * Agar tum array ko 2 parts mein todo:
     *   Part A = first (n-k) elements
     *   Part B = last k elements
     *
     * To rotate karne ka matlab hai Part B ko Part A ke aage laana:
     *   Original: [A][B]  ->  Result: [B][A]
     *
     * Trick: [A][B] ko [B][A] mein convert karne ka easiest tareeka:
     *   1) A ko reverse kardo         -> [A'][B]
     *   2) B ko reverse kardo          -> [A'][B']
     *   3) Poore array ko reverse kardo -> [B][A]  <- yehi answer hai!
     *
     * Isko yaad rakhne ka trick (mnemonic):
     *   "Reverse Reverse Reverse" — REV(part1) + REV(part2) + REV(whole)
     *   Bilkul waise hi jaise string rotation check karte waqt bhi
     *   yehi concept use hota hai.
     *
     * WHY THIS WORKS (proof intuition):
     *   Reverse karne se relative order ulta ho jata hai. Jab hum dono
     *   parts ko individually reverse karke fir pura reverse karte hain,
     *   to dono baar ka "ulta" cancel ho jata hai within each part,
     *   lekin parts ka POSITION (kaun aage kaun peeche) swap ho jata hai.
     *   Yehi wo mathematical trick hai jo O(1) space mein rotation kar deta hai.
     *
     * TC: O(n)  -> teeno reverse calls milke total n elements hi touch karte
     * SC: O(1)  -> koi extra array nahi, sirf in-place swapping
     *
     * NOTE: k ko hamesha n se mod karo (k = k % n) kyunki agar k > n ho
     * (ya negative ho) to bhi wraparound sahi se handle ho jaye.
     */
    public static void rotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;          // agar k array size se bada hai to wraparound
        if(k < 0){
            k += n;          // negative k (left rotation) ko bhi handle kar lo
        }

        // Step 1: Reverse first part (0 to n-k-1) -> ye wo part hai jo peeche jayega
        reverse(arr, 0, n - k - 1);

        // Step 2: Reverse second part (n-k to n-1) -> ye wo part hai jo aage aayega
        reverse(arr, n - k, n - 1);

        // Step 3: Reverse the whole array -> dono parts ki position swap ho jayegi
        reverse(arr, 0 , n - 1);
    }

    public static void main(String[] args) {
        int[] arr =  {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(arr, k);

        // Output to verify -> expected: 5 6 7 1 2 3 4
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}

/*
 * ====================================================================
 * QUICK REVISION CHEAT-SHEET (agli baar ye dekh ke revise kar lena):
 * ====================================================================
 * Pattern:        Rotate Array
 * Brute Force:     Extra array, newIndex = (i+k)%n         -> O(n) time, O(n) space
 * Optimal:         Reverse(A) + Reverse(B) + Reverse(Whole) -> O(n) time, O(1) space
 * Trigger words:   "rotate", "in-place", "no extra space", "circular shift"
 * Core trick name: Reversal Algorithm / 3-step reversal
 * Edge cases:      k > n (mod it), k negative (add n), k == 0 or k == n (no-op)
 */