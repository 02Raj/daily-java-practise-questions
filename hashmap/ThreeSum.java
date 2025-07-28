package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;

public class ThreeSum {

    /**
     * Brute force approach
     * Time Complexity: O(n³) — three nested loops over the array
     * Space Complexity: O(1) — only constant extra space
     */
    public static int[] bruteForce(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == targetSum) {
                        return new int[]{arr[i], arr[j], arr[k]};
                    }
                }
            }
        }
        return new int[]{-1, -1,-1};  // No triplet found
    }

    /**
     * Optimized two-pointer approach (requires sorting)
     * Time Complexity: O(n²) — sorting is O(n log n), two-pointer scan is O(n²)
     * Space Complexity: O(1) — in-place sort plus constant extra space
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Agar array mein 3 se kam elements hain, toh triplet banana possible hi nahi hai
        if (nums.length < 3) {
            return result;
        }

        // Array ko sort karte hain taaki two-pointer technique ka use kar sakein
        // Sorting is important to efficiently skip duplicates and apply two-pointer logic
        Arrays.sort(nums);  // Time Complexity: O(n log n)

        // Loop through array, har index 'i' ke liye ek first element fix karte hain
        // Loop ko nums.length - 2 tak isliye chala rahe hain kyunki hume triplet chahiye,
        // aur ek triplet mein 3 elements hote hain — to agar i last ya second last pe hua to aage 2 elements honge hi nahi
        for (int i = 0; i < nums.length - 2; i++) {

            // Agar current element same hai previous se (duplicate), to skip kar dete hain
            // Taaki same triplet baar-baar result mein na aaye
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Ab hum two-pointer approach se do aise numbers dhoondhenge jo -nums[i] ke equal hoon
            // Taaki: nums[i] + nums[j] + nums[k] == 0 ho jaye
            twoSum(nums, i + 1, result, -nums[i]);
        }

        return result;
    }




    private void twoSum(int[] nums, int start, List<List<Integer>> result, int target) {

        // Two pointer initialization
        int i = start, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum > target) {
                // Sum zyada ho gaya, toh right pointer ko ek step left le jao (chhoti value lao)
                j--;
            } else if (sum < target) {
                // Sum kam hai, toh left pointer ko ek step right le jao (badi value lao)
                i++;
            } else {
                // Perfect match mil gaya: nums[i] + nums[j] + nums[k] = 0
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                // Duplicate elements skip karo (left side)
                while (i < j && nums[i] == nums[i + 1]) i++;

                // Duplicate elements skip karo (right side)
                while (i < j && nums[j] == nums[j - 1]) j--;

                // Next unique elements ke liye pointers move karo
                i++;
                j--;
            }
        }
    }


    /**
     * HashMap/HashSet-based approach (no sorting)
     * Time Complexity: O(n²) — two nested loops, each inner contains O(1) HashSet ops
     * Space Complexity: O(n) — HashSet to store seen elements
     */
    public List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> seen = new HashSet<>();
            int target = -nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];
                if (seen.contains(complement)) {
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                    // Skip duplicates for the second element
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                seen.add(nums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test optimized two-pointer approach
        int[] nums = {-4, -1, -1, 0, 1, 2};
        System.out.println("Optimized 3Sum result: " + solution.threeSum(nums));

        // Test brute force approach
        int[] numsBrute = {1, -1, 0, 2, 3, 4, 5, -2, 5};
        int[] bfRes = bruteForce(numsBrute, 0);
        System.out.println("Brute Force triplet: " +
                (bfRes[0] != -1 ? Arrays.toString(bfRes) : "None"));

        // Test HashMap approach
        int[] numsHash = {-4, -1, -1, 0, 1, 2};
        System.out.println("HashMap 3Sum result: " + solution.threeSumUsingHashMap(numsHash));
    }
}


