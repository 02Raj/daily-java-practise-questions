package basicarrayquestion;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // ✅ HashMap approach: returns indices
    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return null;
    }

    // ✅ Two-pointer approach: returns values (not indices)
    public static int[] twoSumTwoPointer(int[] arr, int target) {
        // Don't modify original array
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];

            if (sum == target) {
                return new int[] { copy[left], copy[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null; // 🔴 You missed this!
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Using HashMap:");
        int[] result1 = twoSumHashMap(nums, target);
        if (result1 != null)
            System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]");
        else
            System.out.println("No two numbers found.");

        System.out.println("\nUsing Two Pointer:");
        int[] result2 = twoSumTwoPointer(nums, target);
        if (result2 != null)
            System.out.println("Values: [" + result2[0] + ", " + result2[1] + "]");
        else
            System.out.println("No two numbers found.");
    }
}
