package hashmap;

import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];

            if(map.containsKey(compliment)){
                return new int[]{ compliment,i};
            }

            map.put(nums[i],i);
        }
    return new int[0];
    }

    public static void main(String[] args) {
        int[] nums  = {2,7,11,15};
        int target = 9;
        int[] result = findTwoSum(nums,target);

        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }
}
