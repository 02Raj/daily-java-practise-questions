package basicarrayquestion;

public class MaxMinFinder {

    public static void findMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
    public static void main(String[] args) {
        int[] numbers = {5, 8, 1, 3, 9, 2, 10, 4};

        findMaxMin(numbers);
    }
}
