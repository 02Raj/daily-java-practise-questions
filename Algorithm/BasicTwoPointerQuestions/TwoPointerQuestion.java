package Algorithm.BasicTwoPointerQuestions;

import java.util.Arrays;

public class TwoPointerQuestion {

    static int[] pairWithGivenSum(int[] arr, int target, int left, int right) {
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    static void moveAllZerosToEnd(int[] arr) {
        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
    }

    static int[] removeDuplicateSortedArray(int[] arr2){

        int j = 0;

        for (int i = 1; i < arr2.length; i++){
            if (arr2[i] != arr2[j]){
                j++;
                arr2[j] = arr2[i];
            }
        }

        return Arrays.copyOf(arr2, j + 1);
    }


    static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5,5, 7, 10, 11, 15};
        int target = 15;

        int[] arr2 = {0, 1, 0, 3, 12};
        int[] result = pairWithGivenSum(arr, target, 0, arr.length - 1);

        if (result.length > 0) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
//

        removeDuplicateSortedArray(arr2);
        System.out.println("new Array is: " + Arrays.toString(removeDuplicateSortedArray(arr)));

        reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
