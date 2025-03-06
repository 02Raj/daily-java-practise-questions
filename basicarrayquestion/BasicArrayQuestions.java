package basicarrayquestion;

import java.util.*;

public class BasicArrayQuestions {


    // selection sort for sorting
    static void sortedArray(int[] arr){
         int n  = arr.length;
         int min_index;
         for (int i = 0; i < n - 1; i++){
             min_index = i;

             for (int j = i + 1 ; j < n; j++){
                 if (arr[j] < arr[min_index]){
                     min_index = j;
                 }
             }

             int temp = arr[min_index];
             arr[min_index] = arr[i];
             arr[i] = temp;
         }
     }

     static void sumOfArray(int[] arr2){
        int n = arr2.length;
        int sum = 0;

        for (int i = 0; i < n; i++){
            int num = arr2[i];
             sum += num;
        }
         System.out.println("sum of array is: " + sum);
     }

     static void avgOfArray(int[] arr2){
         int n = arr2.length;
         int sum = 0;

         for (int i = 0; i < n; i++){
             int num = arr2[i];
             sum += num;
         }
         int avg  = sum / n ;
         System.out.println("avg of array is: " + avg);
     }

     static void largestElementArray(int[] arr2) {
        int max = arr2[0];

        for (int i = 0; i < arr2.length - 1; i++){
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
         System.out.println("max: " + max);
     }

    static void secondLrgestElementArray(int[] arr2) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                secondMax = max;
                max = arr2[i];
            } else if (arr2[i] > secondMax && arr2[i] < max) {
                secondMax = arr2[i];
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second largest element found!");
        } else {
            System.out.println("Second Largest Element: " + secondMax);
        }
    }


    static boolean ifArraySort(int[] arr2){

        for (int i = 0; i < arr2.length - 1; i++){
            if(arr2[i] > arr2[i + 1]){
                return false;
            }
        }
        return true;
    }

    static boolean containSpecificValue(int[] arr){
        int specicValue = 7;

        for (int i=0; i<arr.length - 1; i++){
            if (arr[i] == specicValue){
                return true;
            }
        }
        return false;
    }

    static void removeSpecificElement(int[] arr){
        int removespecificElementIs = 10;
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == removespecificElementIs) count++;
        }

        System.out.println("count: " + count);
        // creta a new array with reduce size
        int[] newArr = new int[arr.length - count];
        int index = 0;

        // Copy elements except the one to be removed
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != removespecificElementIs) {
                newArr[index] = arr[i];
                index++;
            }
        }
        System.out.println("Updated Array: " + Arrays.toString(newArr));
    }

    static int[] insertElementSpecificPosition(int[] arr) {
        int element = 3;
        int position = 2;

        int[] newArr = new int[arr.length + 1];

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == position) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[j];
                j++;
            }
        }

        return newArr;
    }

    static void copyOfArray(int[] originalArray){

        int[] copiedArray = new int[originalArray.length];

        for (int i=0 ; i < originalArray.length; i++){
            copiedArray[i] = originalArray[i];
        }

        System.out.print("Original Array: ");
        for (int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + " ");
        }

        System.out.println();

        System.out.print("Copied Array: ");
        for (int i = 0; i < copiedArray.length; i++) {
            System.out.print(copiedArray[i] + " ");
        }
    }
    static int findIndexOfArrayElement(int[] arr) {
        int specicValue = 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == specicValue) {
                return i;
            }
        }
        return -1;
    }

    static int[] maxAndminValueOfArray(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return new int[]{max, min};
    }

    static void reverseArray(int[] arr) {
        System.out.print("Reverse Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    static void duplicateValueOfArray(int[] arr){
        int duplicateValue = 0;

        for (int i = 0; i < arr.length-1; i++){
           for (int j = i + 1; j < arr.length; j++){
               if (arr[i] == arr[j]){
                   duplicateValue = arr[i];
               }
           }
        }
        System.out.println("duplicate value is:" + duplicateValue);
    }

    static void commonElementArrays(int[] arr1, int[] arr2) {
        System.out.print("Common elements: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    static void duplicateValueUsingHashMap(int[] arr){

        Map<Integer,Integer> duplicatCount = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
           if(duplicatCount.containsKey(arr[i])){
               int currentCount = duplicatCount.get(arr[i]);
               duplicatCount.put(arr[i],currentCount + 1);
           }else{
               duplicatCount.put(arr[i], 1);
           }
        }
        System.out.println("Duplicate Elements with Count:");
        for (int i = 0; i < arr.length; i++){
            if(duplicatCount.get(arr[i]) > 1){
                System.out.println(arr[i] + " -> " + duplicatCount.get(arr[i]));
                duplicatCount.put(arr[i], 0);
            }
        }
    }

    static void leftRotateArray(int[] arr){
       int n = arr.length;
       int temp = arr[0];

       for (int i = 0; i < arr.length - 1; i++){
           arr[i] = arr[i+1];
       }

       arr[n-1] = temp;


    }

    public static void main(String[] args) {

        int[] arr = {1789,2035,1899,1456,2013};
        int[] arr2 = {2,4,15,4,10,1};
        int[] arr3 = {1,2,3,4,5};
        sumOfArray(arr2);
        avgOfArray(arr2);
        sortedArray(arr);

        System.out.println("Sorted Array:");
        for (int num : arr2) {
            System.out.print(num + " ");
        }

        largestElementArray(arr2);
        secondLrgestElementArray(arr2);
        ifArraySort(arr2);
        System.out.println("Is arr1 sorted? " + ifArraySort(arr2));

        containSpecificValue(arr2);

        System.out.println("Is  contain specific value? " + containSpecificValue(arr2));

        int index = findIndexOfArrayElement(arr2);
        System.out.println("Index of specific value: " + index);
        removeSpecificElement(arr2);

        copyOfArray(arr2);

        int[] result = insertElementSpecificPosition(arr2);

        duplicateValueOfArray(arr2);
        System.out.println("New Array: " + Arrays.toString(result));
        duplicateValueUsingHashMap(arr2);
        int[] maxAndMinresult = maxAndminValueOfArray(arr2);
        System.out.println("Max: " + Arrays.toString(maxAndMinresult));

        reverseArray(arr2);

        commonElementArrays(arr3,arr3);
        leftRotateArray(arr2);
        System.out.println("Rotated Array: " + Arrays.toString(arr2));
        }



}
