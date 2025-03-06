package sorting.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void   mergeSort(int[] arr, int low, int high){

         if(low >= high) {
             return;
         }

         int mid = low + (high - low) / 2;

         mergeSort(arr,low,mid);
         mergeSort(arr,mid+1,high);

         merge(arr,low,mid,high);
     }
    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;


        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }


        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }


        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

//        System.out.println("temp1: " + temp);
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
//        System.out.println("temp2 " + temp);
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));


        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
