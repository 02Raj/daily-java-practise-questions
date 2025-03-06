package StringsLeetcode;

import java.util.Arrays;

import java.util.Arrays;

public class ThreeSum {

    public static int[] findThreeSum(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        int[] result = {arr[i], arr[j], arr[k]};
                        return result;
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 0, 2, 3, 4, 5, -2, 5};
        int target = 0;

        int[] result = findThreeSum(arr, target);
        if (result.length > 0) {
            System.out.println("Numbers that add up to " + target + ": " + Arrays.toString(result));
        } else {
            System.out.println("No such triplet found.");
        }
    }
}
