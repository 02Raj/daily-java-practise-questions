package basicarrayquestion;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public static void moveZeros(int[] arr){
        int left = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        moveZeros(arr); // perform operation

        System.out.println("Result: " + Arrays.toString(arr)); // print result


    }
}
