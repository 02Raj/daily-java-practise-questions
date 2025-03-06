package sorting;

import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr,int low,int high){

        if(low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr,low,mid);

        mergeSort(arr, mid + 1, high);

       merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;  // Left subarray
        int n2 = high - mid;     // Right subarray

        // Temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Left subarray
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        // Right subarray
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        // Merge , pointers initialize
        int i = 0, j = 0;

        // low से high तक एक for loop चला कर merge process करना
        for (int k = low; k <= high; k++) {
            // अगर दोनों subarrays में elements उपलब्ध हैं
            if (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
            }
            // अगर left subarray से सभी elements merge हो चुके हैं, तो सिर्फ right से elements लें
            else if (i < n1) {
                arr[k] = left[i];
                i++;
            }
            // अगर right subarray से सभी elements merge हो चुके हैं, तो सिर्फ left से elements लें
            else if (j < n2) {
                arr[k] = right[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr,0,arr.length - 1);
        System.out.println("Original Array: " + Arrays.toString(arr));

    }
}
