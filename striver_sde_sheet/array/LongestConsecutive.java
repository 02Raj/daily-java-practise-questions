package striver_sde_sheet.array;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutive {

    static  int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 1;


        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                List<Integer> currentList = new ArrayList<>();
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                    currentList.add(currentNum);
                }

                longestStreak = Math.max(longestStreak, currentStreak);
                System.out.println("Longest Sequence: " + currentList);
            }

        }

        return longestStreak;
    }

    public static void main(String[] args) {

        int[] nums = {49, 1, 3, 200, 2, 4, 70, 5};
        System.out.println("Longest consecutive: " + longestConsecutive(nums));
    }
}
