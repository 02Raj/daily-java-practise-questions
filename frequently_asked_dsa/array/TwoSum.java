package frequently_asked_dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 1 - TWO SUM (Easy, but very important interview pattern)
 * -----------------------------------------------------------------
 *
 * PROBLEM STATEMENT:
 * Humein ek integer array nums aur ek integer target diya hai.
 * Aise do ALAG elements ke indices return karne hain jinka sum target ho.
 *
 * Rules:
 * 1. Har input mein exactly one valid answer hoga.
 * 2. Ek hi element/index ko do baar use nahi kar sakte.
 * 3. Answer kisi bhi order mein return kar sakte hain.
 *
 * Example:
 * nums = [2, 7, 11, 15], target = 9
 * answer = [0, 1], because nums[0] + nums[1] = 2 + 7 = 9
 *
 * =================================================================
 * SABSE IMPORTANT INTUITION - "MUJHE PARTNER CHAHIYE"
 * =================================================================
 * Current number = nums[i]
 * Uska required partner (complement) = target - nums[i]
 *
 * Example: target 9 hai aur current number 7 hai.
 * Required partner = 9 - 7 = 2.
 * Bas check karo: kya 2 pehle dekha tha? Agar haan, answer mil gaya.
 *
 * Memory line:
 *      "Current ko target banane ke liye jo kami hai, wahi complement hai."
 *
 * =================================================================
 * TWO POINTER KYON NAHI?
 * =================================================================
 * Two pointers tab naturally useful hote hain jab array SORTED ho, because:
 * - sum chhota ho -> left++
 * - sum bada ho   -> right--
 *
 * Yahan nums unsorted hai aur humein ORIGINAL INDICES return karne hain.
 * Sirf array sort kar diya to original indices lost/change ho jayenge.
 * Isliye direct two-pointer solution is question ke liye suitable nahi hai.
 *
 * Sorting ke saath (value, originalIndex) pairs bana kar two pointers laga
 * sakte hain, lekin uski time complexity O(n log n) hogi. HashMap O(n) mein
 * same kaam karta hai, isliye optimized interview solution HashMap hai.
 *
 * Quick decision rule:
 * - Sorted array + pair/value search       -> Two pointers socho.
 * - Unsorted array + original indices      -> HashMap socho.
 *
 * =================================================================
 * APPROACH 1 - BRUTE FORCE
 * =================================================================
 * Har possible pair (i, j) check karo, where j = i + 1.
 * j ko i + 1 se start karne ke do benefits:
 * - same index dobara use nahi hoga;
 * - same pair reverse order mein repeat nahi hoga.
 *
 * Time Complexity  : O(n^2)
 * Space Complexity : O(1)
 *
 * =================================================================
 * APPROACH 2 - HASHMAP (OPTIMIZED)
 * =================================================================
 * Map stores: number -> us number ka index
 *
 * Har nums[i] ke liye:
 * 1. complement = target - nums[i]
 * 2. Check karo complement map mein pehle se hai ya nahi.
 * 3. Hai -> complement ka index aur current i return karo.
 * 4. Nahi -> current number aur index map mein store karo.
 *
 * IMPORTANT ORDER: pehle CHECK, phir PUT.
 * Agar pehle put karenge, target = 6 aur current nums[i] = 3 par same index
 * ko khud ke partner ki tarah use kar sakte hain. Check-before-put automatically
 * ensure karta hai ki do different indices use hon.
 *
 * Average Time Complexity : O(n)
 * Space Complexity        : O(n)
 * HashMap lookup/insert average O(1) hota hai.
 *
 * =================================================================
 * SMALL DRY RUN
 * =================================================================
 * nums = [3, 2, 4], target = 6
 *
 * i=0, value=3, complement=3, map={}        -> not found -> put (3,0)
 * i=1, value=2, complement=4, map={3=0}     -> not found -> put (2,1)
 * i=2, value=4, complement=2, map={3=0,2=1} -> found 2 at index 1
 * Return [1,2].
 *
 * Duplicate case: nums=[3,3], target=6
 * First 3 store hota hai. Second 3 ko pehle 3 ka index milta hai -> [0,1].
 * Isi wajah se duplicates bhi correctly handle hote hain.
 *
 * =================================================================
 * KEY TO REMEMBER ALWAYS
 * =================================================================
 * "Unsorted Two Sum + indices = ek pass HashMap.
 *  Pehle complement CHECK karo, phir current number PUT karo."
 *
 * Common mistakes:
 * - map.put() ko containsKey() se pehle karna;
 * - value return kar dena jab question indices maang raha ho;
 * - bina original indices preserve kiye array sort karna;
 * - duplicates ya negative numbers ko special case samajhna (zarurat nahi);
 * - no-solution return par confuse hona (LeetCode exactly one solution deta hai).
 */
public class TwoSum {

    /**
     * Brute-force version: concept samajhne aur interviewer ko progression
     * dikhane ke liye. LeetCode submission ke liye optimized method use karo.
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // Given constraint ke according yeh line execute nahi hogi.
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Optimized one-pass HashMap solution - LeetCode ke liye submit this method.
     */
    public int[] twoSum(int[] nums, int target) {
        // Key = pehle dekhi hui value, Value = us value ka original index
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Pehle partner search karo, taaki current index khud se match na ho.
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            // Partner abhi nahi mila, current value ko future ke liye yaad rakho.
            seen.put(nums[i], i);
        }

        // Problem exactly one solution guarantee karta hai, so this is unreachable.
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
     * REVISION TEST CASES:
     * LeetCode ke hidden test cases visible nahi hote. Neeche unki important
     * categories cover hain: normal input, unsorted input, duplicates, negative
     * values, zero, answer at far ends, and repeated values.
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        runTest(solution, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        runTest(solution, new int[]{3, 2, 4}, 6, new int[]{1, 2});
        runTest(solution, new int[]{3, 3}, 6, new int[]{0, 1});
        runTest(solution, new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2});
        runTest(solution, new int[]{0, 4, 3, 0}, 0, new int[]{0, 3});
        runTest(solution, new int[]{5, 1, 8, 2, 7}, 12, new int[]{0, 4});
        runTest(solution, new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4});
        runTest(solution, new int[]{1, 5, 1, 5}, 10, new int[]{1, 3});

        System.out.println("All Two Sum test cases passed.");
    }

    /** Checks both returned indices as an unordered pair. */
    private static void runTest(TwoSum solution, int[] nums, int target, int[] expected) {
        int[] optimizedActual = solution.twoSum(nums, target);
        int[] bruteForceActual = solution.twoSumBruteForce(nums, target);

        boolean optimizedPassed = isExpectedPair(optimizedActual, expected)
                && optimizedActual[0] != optimizedActual[1]
                && nums[optimizedActual[0]] + nums[optimizedActual[1]] == target;
        boolean bruteForcePassed = isExpectedPair(bruteForceActual, expected)
                && bruteForceActual[0] != bruteForceActual[1]
                && nums[bruteForceActual[0]] + nums[bruteForceActual[1]] == target;

        if (!optimizedPassed || !bruteForcePassed) {
            throw new AssertionError(
                    "Failed for nums=" + Arrays.toString(nums)
                            + ", target=" + target
                            + ", expected=" + Arrays.toString(expected)
                            + ", optimized=" + Arrays.toString(optimizedActual)
                            + ", bruteForce=" + Arrays.toString(bruteForceActual));
        }

        System.out.println("PASS nums=" + Arrays.toString(nums)
                + ", target=" + target
                + " -> " + Arrays.toString(optimizedActual));
    }

    private static boolean isExpectedPair(int[] actual, int[] expected) {
        return actual.length == 2
                && ((actual[0] == expected[0] && actual[1] == expected[1])
                || (actual[0] == expected[1] && actual[1] == expected[0]));
    }

}
