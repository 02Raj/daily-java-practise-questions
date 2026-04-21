package Algorithm.twopointer;

import java.util.Arrays;
import java.util.HashMap;

/*
===========================================================
🧩 Problem: Number of Ways Where Square of Number is
            Equal to Product of Two Numbers
===========================================================
🔗 LeetCode: https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
📅 Solved On: 21-04-2025
🔁 Revision Due: 28-04-2025
===========================================================

📝 Problem Statement:
Do arrays diye hain nums1 aur nums2.
Valid triplets count karo:

Type 1: nums1[i]² == nums2[j] * nums2[k]  (j < k)
Type 2: nums2[i]² == nums1[j] * nums1[k]  (j < k)

Example:
Input:  nums1=[6,3], nums2=[2,3,5,7]  →  Output: 1
Input:  nums1=[2,2], nums2=[2,2,2]    →  Output: 9

===========================================================
💡 APPROACH 1: BRUTE FORCE
===========================================================
Teen nested loops - sab kuch try karo!

Step 1: nums1 ka har element lo, square nikalo
Step 2: nums2 ke saare pairs check karo
Step 3: Same cheez Type 2 ke liye

🔁 Dry Run: nums1=[2,2], nums2=[2,2,2]
i=0, sq=4 → (0,1)→4✅ (0,2)→4✅ (1,2)→4✅ count=3
i=1, sq=4 → same 3 pairs                   count=6  ← Type1
i=0, sq=4 → nums1 pair(0,1)→4✅            count=7
i=1, sq=4 → same pair                      count=8
i=2, sq=4 → same pair                      count=9  ← Type2
Total = 9

⏱ TC: O(n × m²)   📦 SC: O(1)

===========================================================
💡 APPROACH 2: HASHMAP
===========================================================
Pehle DIARY banao → phir seedha dekho!

Step 1: nums2 ke saare pairs ki diary banao {product → count}
Step 2: nums1[i]² diary mein dekho → seedha count milega
Step 3: Same for Type 2

🔁 Dry Run: nums2=[2,2,2]
map2 = {4→3}  (teen pairs, sab ka product 4)
nums1[0]=2, sq=4 → map2.get(4)=3 → count+=3
nums1[1]=2, sq=4 → map2.get(4)=3 → count+=3  → Type1=6
nums2 map1={4→1}  (ek hi pair)
nums2[0,1,2] sq=4 → map1.get(4)=1 each → Type2=3
Total = 9

⏱ TC: O(n×m)   📦 SC: O(n+m)

===========================================================
💡 APPROACH 3: TWO POINTER
===========================================================
Sort karo → Left aur Right se aao andar!

Step 1: Dono arrays sort karo
Step 2: Har element ka square lo
Step 3: Sorted array mein two pointer se pairs dhundho
        product < square → left++
        product > square → right--
        product == square → count karo (duplicates handle!)

🔁 Dry Run: nums1=[2,2], nums2=[2,2,2] sorted
Type1: sq=4, arr=[2,2,2]
  left=0, right=2 → arr[0]==arr[2] (saare same!)
  len=3 → pairs = 3×2/2 = 3 → count+=3 (×2 nums1) = 6
Type2: sq=4, arr=[2,2]
  left=0, right=1 → arr[0]==arr[1]
  len=2 → pairs = 2×1/2 = 1 → count+=1 (×3 nums2) = 3
Total = 9 ✅

⏱ TC: O(n×m)   📦 SC: O(1)

===========================================================
🧠 Key Ideas:
→ (long) cast zaroori! 10000×10000 int overflow karta
→ j+1 se k start → j<k automatically satisfy
→ Two Pointer mein duplicates ka formula: n*(n-1)/2
→ HashMap approach interview favourite!

===========================================================
🔁 Revision Checklist:
[ ] Type1 aur Type2 mein kya difference hai?
[ ] long cast kyun zaroori hai?
[ ] HashMap mein getOrDefault(key, 0L) kyun?
[ ] Two Pointer mein saare same elements ka formula kya?
[ ] Dry run: nums1=[1,1], nums2=[1,1,1] → expected?
===========================================================
*/

public class NumTriplets {

    // ═══════════════════════════════════════════════════════
    // APPROACH 1 : BRUTE FORCE
    // TC: O(n × m²)  SC: O(1)
    // ═══════════════════════════════════════════════════════
    public int bruteForce(int[] nums1, int[] nums2) {
        int count = 0;

        // TYPE 1 → nums1 se square, nums2 se pair
        for (int i = 0; i < nums1.length; i++) {
            long square = (long) nums1[i] * nums1[i];
            //             ↑ long! int overflow rokne ke liye

            for (int j = 0; j < nums2.length; j++) {
                for (int k = j + 1; k < nums2.length; k++) {
                    //              ↑ j+1 → j<k automatic!
                    long product = (long) nums2[j] * nums2[k];
                    if (product == square) count++;
                }
            }
        }

        // TYPE 2 → nums2 se square, nums1 se pair
        for (int i = 0; i < nums2.length; i++) {
            long square = (long) nums2[i] * nums2[i];

            for (int j = 0; j < nums1.length; j++) {
                for (int k = j + 1; k < nums1.length; k++) {
                    long product = (long) nums1[j] * nums1[k];
                    if (product == square) count++;
                }
            }
        }

        return count;
    }

    // ═══════════════════════════════════════════════════════
    // APPROACH 2 : HASHMAP
    // TC: O(n×m)  SC: O(n+m)
    // ═══════════════════════════════════════════════════════
    public int hashMap(int[] nums1, int[] nums2) {

        // Dono arrays ki diary banao
        HashMap<Long, Long> map1 = banaoMap(nums1); // nums1 pairs
        HashMap<Long, Long> map2 = banaoMap(nums2); // nums2 pairs

        long count = 0;

        // TYPE 1 → nums1[i]² ko map2 mein dhundho
        for (int num : nums1) {
            long square = (long) num * num;
            count += map2.getOrDefault(square, 0L);
            //            ↑ nahi mila → 0, error nahi!
        }

        // TYPE 2 → nums2[i]² ko map1 mein dhundho
        for (int num : nums2) {
            long square = (long) num * num;
            count += map1.getOrDefault(square, 0L);
        }

        return (int) count;
    }

    // Helper: array ke saare pairs ke products ki diary
    private HashMap<Long, Long> banaoMap(int[] arr) {
        HashMap<Long, Long> map = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                long product = (long) arr[j] * arr[k];
                // diary mein likho: pehle se hai → +1, nahi → 1
                map.put(product, map.getOrDefault(product, 0L) + 1);
            }
        }

        return map;
    }

    // ═══════════════════════════════════════════════════════
    // APPROACH 3 : TWO POINTER
    // TC: O(n×m)  SC: O(1)
    // ═══════════════════════════════════════════════════════
    public int twoPointer(int[] nums1, int[] nums2) {

        // Pehle sort karo - Two Pointer ke liye zaroori!
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        long count = 0;

        // TYPE 1 → nums1 ka square, nums2 mein two pointer
        for (int num : nums1) {
            count += findPairs(nums2, (long) num * num);
        }

        // TYPE 2 → nums2 ka square, nums1 mein two pointer
        for (int num : nums2) {
            count += findPairs(nums1, (long) num * num);
        }

        return (int) count;
    }

    // Helper: sorted array mein target product ke pairs dhundho
    private long findPairs(int[] arr, long target) {
        long count = 0;
        int left  = 0;
        int right = arr.length - 1;

        while (left < right) {
            long product = (long) arr[left] * arr[right];

            if (product == target) {

                // CASE 1: Saare same elements
                // ex: [2,2,2,2] target=4
                if (arr[left] == arr[right]) {
                    long len = right - left + 1;
                    count += (len * (len - 1)) / 2;
                    // formula: n*(n-1)/2 = total pairs
                    // [2,2,2] → 3*2/2 = 3 pairs ✅
                    break;
                }

                // CASE 2: Alag elements with duplicates
                // ex: [2,2,3,3] target=6
                int leftCount  = 1;
                int rightCount = 1;

                // Left duplicates count karo
                while (left + 1 < right
                        && arr[left] == arr[left + 1]) {
                    left++;
                    leftCount++;
                }

                // Right duplicates count karo
                while (right - 1 > left
                        && arr[right] == arr[right - 1]) {
                    right--;
                    rightCount++;
                }

                // Har left wala, har right wale se pair ban sakta
                count += (long) leftCount * rightCount;
                left++;
                right--;

            } else if (product < target) {
                left++;  // chota hai → left badhao
            } else {
                right--; // bada hai → right ghataao
            }
        }

        return count;
    }

    // ═══════════════════════════════════════════════════════
    // MAIN → Teeno Approaches Test Karo
    // ═══════════════════════════════════════════════════════
    public static void main(String[] args) {
        NumTriplets sol = new NumTriplets();

        int[][] n1 = { {6,3},  {2,2},  {1,1} };
        int[][] n2 = { {2,3,5,7}, {2,2,2}, {1,1,1} };
        int[]   ex = { 1,          9,       9 };

        System.out.println("Test | BruteForce | HashMap | TwoPtr | Expected");
        System.out.println("─────────────────────────────────────────────────");

        for (int t = 0; t < n1.length; t++) {
            System.out.printf(" %d   |     %d      |    %d    |   %d    |    %d%n",
                    t + 1,
                    sol.bruteForce(n1[t].clone(), n2[t].clone()),
                    sol.hashMap   (n1[t].clone(), n2[t].clone()),
                    sol.twoPointer(n1[t].clone(), n2[t].clone()),
                    ex[t]
            );
        }
    }
}