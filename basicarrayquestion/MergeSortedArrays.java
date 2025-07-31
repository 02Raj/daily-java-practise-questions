package basicarrayquestion;

import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m+n];

        int i = 0; int j = 0; int k = 0;

        while(i < m && j < n){
            if(arr1[i] <= arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }
        }

        while (i < m) {
            result[k++] = arr1[i++];
        }

        while(i < n){
            result[k++] = arr2[j++];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 5, 6};

        int[] merged = mergeSortedArrays(arr1,arr2);
        System.out.println(Arrays.toString(merged));
    }
}
