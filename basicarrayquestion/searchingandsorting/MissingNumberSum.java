package basicarrayquestion.searchingandsorting;

import java.util.Arrays;

public class MissingNumberSum {

    public static int findMissing(int[] arr){
        int n = arr.length;
        int actualSum = 0;
        int expectedSum = n * (n+1) /2;

        for (int i = 0; i < arr.length; i++){
            actualSum += arr[i];
        }

        return actualSum - expectedSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        findMissing(arr);
        System.out.println("Missing number is: " + Arrays.toString(arr));  // Output: 2
    }
}
