package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasicHashMapQus {

    public static int findFirstNonRepeating(int[] arr){
      HashMap<Integer,Integer> freqMap = new HashMap<>();

      for(int i = 0; i < arr.length; i++){
          int num = arr[i];
        freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
      }

/*      without use getOrDefault method
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }*/


      for (int i = 0; i < arr.length; i++){
          if (freqMap.get(arr[i]) == 1){
              return arr[i];
          }
      }
      return -1;

    }


    public static int lastNonRepeating(int[] arr){
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

/*      without use getOrDefault method
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }*/

        System.out.println("freqMap: " + freqMap);
        for (int i = 0; i < arr.length; i++){
            if (freqMap.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return -1;
   }
    public static void countFreq(int arr[], int n) {
        boolean visited[] = new boolean[n];
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
        for (int i = 0; i < n; i++) {

            // Skip this element if already processed
            if (visited[i] == true)
                continue;

            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            if (count > maxFreq) {
                maxEle = arr[i];
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = arr[i];
                minFreq = count;
            }
        }
        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);

    }

    static boolean isSubset(int a[], int b[]) {
        int m = a.length;
        int n = b.length;

        for (int i = 0; i < n; i++) { // Iterate through b[] (subset array)
            boolean found = false;
            for (int j = 0; j < m; j++) { // Check in a[] (main array)
                if (b[i] == a[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) return false; // If any element is missing, return false
        }
        return true;
    }
    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 2, 0, 4, 5, 2};
        int[] a = {11, 1, 13, 21, 3, 7};
        int[] b = {11, 3, 7, 1};
      System.out.println("First Non-Repeating Element: " + findFirstNonRepeating(arr));

      System.out.println("First Last-Non-Repeating Element: " + lastNonRepeating(arr));

       int n = arr.length;
       countFreq(arr,n);
        if (isSubset(a, b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}
