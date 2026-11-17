package basicarrayquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    /*
    =============================================================
                       HASHMAP APPROACH
    =============================================================

    Need INDICES
    Value -> Index

    Time Complexity : O(n)
    Space Complexity: O(n)
    */

    public static int[] twoSumHashMap(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }


    /*
    =============================================================
                       HASHSET APPROACH
    =============================================================

    Need only VALUES
    Stores only values

    Time Complexity : O(n)
    Space Complexity: O(n)
    */

    public static int[] twoSumHashSet(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            int complement = target - num;

            if (set.contains(complement)) {
                return new int[]{complement, num};
            }

            set.add(num);
        }

        return null;
    }


    /*
    =============================================================
                     TWO POINTER APPROACH
    =============================================================

    Works best when array is already sorted.

    Here we are sorting a COPY so that original array
    remains unchanged.

    Time Complexity : O(n log n)
    Space Complexity: O(n)
    */

    public static int[] twoSumTwoPointer(int[] arr, int target) {

        int[] copy = Arrays.copyOf(arr, arr.length);

        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {

            int sum = copy[left] + copy[right];

            if (sum == target) {
                return new int[]{copy[left], copy[right]};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return null;
    }


    public static void main(String[] args) {

        int[] nums = {3,2,4};

        int target = 6;


        // ========================================================
        // HASHMAP
        // Returns INDEXES
        // ========================================================

        int[] hashMapResult = twoSumHashMap(nums, target);

        System.out.println("HashMap Result: "
                + Arrays.toString(hashMapResult));


        // ========================================================
        // HASHSET
        // Returns VALUES
        // ========================================================

        int[] hashSetResult = twoSumHashSet(nums, target);

        System.out.println("HashSet Result: "
                + Arrays.toString(hashSetResult));


        // ========================================================
        // TWO POINTER
        // Returns VALUES
        // ========================================================

        int[] twoPointerResult = twoSumTwoPointer(nums, target);

        System.out.println("Two Pointer Result: "
                + Arrays.toString(twoPointerResult));
    }
}