package Recursion;

public class ArraySum {
    static int findSum(int[] arr, int n) {

        if (n == 0) {
            return 0;
        }


        return arr[n - 1] + findSum(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10,1,20,5 };
        int n = arr.length;
        int sum = findSum(arr, n);
        System.out.println("Sum of all elements in the array: " + sum);
    }
}
