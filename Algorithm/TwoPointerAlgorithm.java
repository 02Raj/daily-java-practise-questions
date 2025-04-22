package Algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPointerAlgorithm {


    // Brute-force approach (for unsorted/sorted array)
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int[] bruteForce(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{-1, -1}; // No pair found
    }

    // Optimal Two Pointer Approach (array must be sorted)
    // Time Complexity: O(n log n) for sorting + O(n) for two-pointer => O(n log n)
    // Space Complexity: O(1)
    public static int[] twoPointerApproach(int[] arr, int targetSum) {
        Arrays.sort(arr); // Array must be sorted before using two pointers

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == targetSum) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // No pair found
    }

    // HashMap Approach (Best for Unsorted Arrays)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] hashMapApproach(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = targetSum - num;

            if (map.get(complement) != null) {
                return new int[]{complement, num};
            }

            map.put(num, 1);
        }

        return new int[]{-1, -1}; // No pair found
    }


    // Main method to test
    public static void main(String[] args) {
        int[] arr = {7, 11, 1, 3, 15, 5, 9}; // Unsorted array
        int targetSum = 14;

        // Use brute-force
        int[] result1 = bruteForce(arr, targetSum);
        System.out.println("Brute Force: " + result1[0] + ", " + result1[1]);

        // Use two-pointer (after sorting)
        int[] result2 = twoPointerApproach(arr.clone(), targetSum);
        System.out.println("Two Pointer: " + result2[0] + ", " + result2[1]);

        // Use HashMap
        int[] result3 = hashMapApproach(arr, targetSum);
        System.out.println("HashMap: " + result3[0] + ", " + result3[1]);
    }
}
