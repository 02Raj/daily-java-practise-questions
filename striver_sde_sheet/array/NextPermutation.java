package striver_sde_sheet.array;

/*
===========================================================
🧩 Problem: Next Permutation
===========================================================
🔗 LeetCode: https://leetcode.com/problems/next-permutation/
📅 Solved On: 09-04-2025
🔁 Revision Due: 16-04-2025
===========================================================

📝 Problem Statement:
Given an array nums, rearrange it into the next lexicographically
greater permutation. If no such arrangement exists (array is
descending), rearrange to the lowest order (ascending).
Must be done IN-PLACE with O(1) extra space.

Example:
Input:  nums = [1,2,3]  →  Output: [1,3,2]
Input:  nums = [3,2,1]  →  Output: [1,2,3]
Input:  nums = [1,1,5]  →  Output: [1,5,1]

-----------------------------------------------------------
🧠 PEHLE SAMJHO — INTUITION KYA HAI?

Soch: numbers [1, 2, 3] hain.
Saare permutations order mein:
  [1,2,3] → [1,3,2] → [2,1,3] → [2,3,1] → [3,1,2] → [3,2,1]

"Next permutation" matlab → sirf ek step aage jaana lexicographically.

KEY OBSERVATION:
  Array ka right side (suffix) jab tak DESCENDING hai,
  tab tak woh apni MAXIMUM arrangement mein hai.
  Wahan kuch bhi karo — koi bada permutation nahi banega.

  Example: [1, 3, 2]
           suffix [3,2] is descending → yeh MAX arrangement hai
           toh change karna padega LEFT wala part

  Toh hum right se scan karte hain jab tak descending hai,
  aur ruk jaate hain jab INCREASE milta hai — wahi "dip" hai.

-----------------------------------------------------------
💡 Approach (Optimal — 3 Steps):

Step 1: Right se left jao, pehla "dip" dhundho
        → pehli jagah jahan nums[i] < nums[i+1]
        → yahi PIVOT hai (i)

Step 2: Agar pivot mila (i >= 0):
        → Right se pehla element dhundho jo nums[i] se bada ho (j)
        → nums[i] aur nums[j] ko swap karo

Step 3: i+1 se end tak reverse karo
        → Yeh hissa hamesha descending hota hai
        → Reverse karke smallest banana hai

-----------------------------------------------------------
⏱ Time Complexity: O(n)
📦 Space Complexity: O(1)
===========================================================
*/

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // =====================================================
        // STEP 1: Pehla "dip" dhundho (PIVOT)
        // =====================================================
        //
        // WHY i = n-2 se shuru?
        // ----------------------
        // Hum nums[i] aur nums[i+1] compare kar rahe hain.
        // Agar i = n-1 hota, toh nums[i+1] = nums[n] → OUT OF BOUNDS!
        // nums ka last valid index n-1 hai, toh comparison ke liye
        // hume ek peeche se shuru karna padega → i = n-2.
        //
        // Example: nums = [1, 2, 3],  n = 3
        //   i = n-2 = 1
        //   nums[1]=2, nums[2]=3 → compare hoga ✅
        //   agar i = n-1 = 2 hota → nums[3] → CRASH 💥
        //
        // WHY while loop mein i >= 0?
        // ----------------------------
        // Jab array FULLY DESCENDING hota hai (e.g. [3,2,1]),
        // koi dip milta hi nahi. Loop chalte chalte i = -1 ho jaata hai.
        // i >= 0 check isliye hai taaki loop -1 pe RUKE aur crash na ho.
        // i = -1 matlab: koi pivot nahi mila → poora array reverse karna hai.
        //
        // WHY condition nums[i] >= nums[i+1]?
        // -------------------------------------
        // Hum tab tak AAGE jaate hain jab suffix DESCENDING ya EQUAL hai.
        // Jab nums[i] < nums[i+1] milega → INCREASE mila → yahi PIVOT hai → RUKO.
        // >= isliye (na sirf >) kyunki equal elements pe bhi aage badhna hai
        // (duplicates ke case mein galat pivot na pakdo)
        //
        //   [1, 2, 3]:  i=1 → nums[1]=2 < nums[2]=3 → RUK GAYE, i=1 ✅
        //   [3, 2, 1]:  i=1 → 2>=1 → i=0 → 3>=2 → i=-1 → loop khatam
        //   [1, 1, 5]:  i=1 → nums[1]=1 < nums[2]=5 → RUK GAYE, i=1 ✅

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // =====================================================
        // STEP 2: Pivot se thoda bada element dhundho → SWAP
        // =====================================================
        //
        // WHY sirf tab karo jab i >= 0?
        // --------------------------------
        // Agar i = -1 hai, matlab koi pivot nahi mila.
        // Array fully descending tha (e.g. [3,2,1]).
        // Iss case mein koi swap nahi karna — seedha Step 3 pe jaao
        // jo poora array reverse kar dega → [1,2,3] (smallest permutation).
        //
        // WHY j = n-1 se scan karte hain (right se)?
        // --------------------------------------------
        // Pivot ke right ka hissa HAMESHA DESCENDING hota hai
        // (isliye hi toh loop Step 1 mein ruka tha).
        //
        // Hume chahiye: nums[i] se SIRF THODA BADA element.
        // Right se scan karne pe PEHLA jo milega woh smallest-greater hoga.
        // Left se scan karte toh sabse bada milta — woh galat hoga.
        //
        // Example: nums = [1, 3, 2],  pivot i=0 (nums[0]=1)
        //   Right se scan: j=2 → nums[2]=2 > nums[0]=1 → MILA ✅
        //   Swap → [2, 3, 1]  (abhi bhi Step 3 baaki hai)
        //
        // WHY nums[j] <= nums[i] condition?
        // -----------------------------------
        // Hume strictly bada chahiye (nums[j] > nums[i]).
        // Toh tab tak aage badhte hain jab <= ho.
        // Pehla j milega jahan strictly greater ho → wahi swap karo.

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap pivot (i) aur just-greater element (j)
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // =====================================================
        // STEP 3: i+1 se end tak REVERSE karo
        // =====================================================
        //
        // WHY reverse karna zaroori hai?
        // --------------------------------
        // Pivot ke right ka hissa Step 1 ke baad bhi DESCENDING hai.
        // (Step 2 ke swap ke baad bhi yeh hissa descending rehta hai —
        //  kyunki humne sirf ek element swap kiya, order nahi badla)
        //
        // Descending suffix = SABSE BADA possible suffix.
        // Hume chahiye SABSE CHHOTA possible suffix (next permutation ke liye).
        // Descending ko reverse karo → ASCENDING milega → SMALLEST suffix ✅
        //
        // WHY left = i+1?
        // -----------------
        // Pivot index i tak sab fix hai (humne woh change kar liya Step 2 mein).
        // Sirf i+1 se aage wala hissa reverse hoga.
        //
        // SPECIAL CASE — jab i = -1 (no pivot found):
        // ---------------------------------------------
        // left = i+1 = -1+1 = 0
        // right = n-1
        // → Poora array reverse hoga → [3,2,1] becomes [1,2,3] ✅
        // Yeh automatically handle hota hai — alag case likhne ki zaroorat nahi!
        //
        // DRY RUN — [1, 3, 2]:
        //   After Step 1: i = 0  (nums[0]=1 < nums[1]=3)
        //   After Step 2: swap nums[0] & nums[2] → [2, 3, 1]
        //   After Step 3: reverse from index 1 → [2, 1, 3] ✅
        //
        // DRY RUN — [2, 3, 1]:
        //   After Step 1: i = 0  (nums[0]=2 < nums[1]=3)
        //   After Step 2: j=2, nums[2]=1 <= 2 → j=1, nums[1]=3 > 2 → swap → [3, 2, 1]
        //   After Step 3: reverse from index 1 → [3, 1, 2] ✅
        //
        // DRY RUN — [3, 2, 1] (fully descending):
        //   After Step 1: i = -1 (no dip found)
        //   Step 2 skipped (i < 0)
        //   After Step 3: left=0, right=2 → reverse whole array → [1, 2, 3] ✅

        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        NextPermutation obj = new NextPermutation();

        int[] nums1 = {1, 2, 3};
        obj.nextPermutation(nums1);
        System.out.print("Test 1: ");
        printArray(nums1); // Expected: [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        obj.nextPermutation(nums2);
        System.out.print("Test 2: ");
        printArray(nums2); // Expected: [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        obj.nextPermutation(nums3);
        System.out.print("Test 3: ");
        printArray(nums3); // Expected: [1, 5, 1]

        int[] nums4 = {2, 3, 1};
        obj.nextPermutation(nums4);
        System.out.print("Test 4: ");
        printArray(nums4); // Expected: [3, 1, 2]
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}