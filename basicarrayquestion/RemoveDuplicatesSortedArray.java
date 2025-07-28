package basicarrayquestion;

import java.util.HashMap;

public class RemoveDuplicatesSortedArray {

    // Approach 1: Two Pointer
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    // Approach 2: Using HashMap (uses extra space)
    public static int removeDuplicatesWithMap(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int index = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, true);
                nums[index++] = num;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] nums2 = nums1.clone();

        System.out.println("Using Two Pointers:");
        int length1 = removeDuplicates(nums1);
        for (int i = 0; i < length1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("\nNew Length: " + length1);

        System.out.println("\nUsing HashMap:");
        int length2 = removeDuplicatesWithMap(nums2);
        for (int i = 0; i < length2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("\nNew Length: " + length2);
    }
}
