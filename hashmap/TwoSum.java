package hashmap;

import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i }; // Return index of complement and current index
            }

            map.put(nums[i], i);
        }
        return new int[0]; // Return empty array if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        int[] result = findTwoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }
}
