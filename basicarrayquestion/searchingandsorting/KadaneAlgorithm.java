package basicarrayquestion.searchingandsorting;

import java.util.Arrays;

public class KadaneAlgorithm {

    public static void maximumSubarraySum(int[] arr){

        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0 ; i < arr.length - 1; i++){
            currentSum += arr[i];
            maxSum = Math.max(currentSum, maxSum);
        }

        if(currentSum < 0){
            currentSum = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        maximumSubarraySum(arr);
        System.out.println("result: " + Arrays.toString( arr));
    }
}
