package basicarrayquestion;

import java.util.Arrays;

public class MergeSortedArrays {

    /*
     🔹 Problem Statement:
        Given two sorted arrays arr1[] and arr2[], merge them into a single sorted array.
        Example:
            Input: arr1 = [1, 2, 3], arr2 = [2, 5, 6]
            Output: [1, 2, 2, 3, 5, 6]
        We have to merge them in ascending order WITHOUT using sort() again.

     🔹 Intuition / Idea:
        Since both arrays are already sorted, we can use the "two pointer" technique:
        - One pointer (i) for arr1
        - One pointer (j) for arr2
        - Compare arr1[i] and arr2[j]
        - Whichever is smaller, put it in the result[] array.
        - Move that pointer ahead.
        Continue until one array is finished, then copy the remaining elements.

     🔹 Formula / Logic Flow:
        while(i < m && j < n)
            if(arr1[i] <= arr2[j]) → result[k++] = arr1[i++]
            else                   → result[k++] = arr2[j++]

        // Copy leftover elements
        while(i < m) → result[k++] = arr1[i++]
        while(j < n) → result[k++] = arr2[j++]
     */

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;      // length of first array
        int n = arr2.length;      // length of second array
        int[] result = new int[m + n];  // new array to store merged output

        int i = 0, j = 0, k = 0;  // pointers for arr1, arr2, and result

        // 🧩 Step 1: Merge until one array finishes
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++]; // pick smaller from arr1
            } else {
                result[k++] = arr2[j++]; // pick smaller from arr2
            }
        }

        // 🧩 Step 2: Copy remaining elements from arr1 (if any)
        while (i < m) {
            result[k++] = arr1[i++];
        }

        // 🧩 Step 3: Copy remaining elements from arr2 (if any)
        while (j < n) {  // ⚠️ corrected from "while (i < n)" to "while (j < n)"
            result[k++] = arr2[j++];
        }

        return result; // merged sorted array
    }

    public static void main(String[] args) {

        // 🧠 Small Dry Run Example:
        // arr1 = [1, 2, 3]
        // arr2 = [2, 5, 6]
        // Step by Step:
        // Compare 1 and 2 → pick 1 → result = [1]
        // Compare 2 and 2 → pick 2 (arr1) → result = [1, 2]
        // Compare 3 and 2 → pick 2 (arr2) → result = [1, 2, 2]
        // Compare 3 and 5 → pick 3 → result = [1, 2, 2, 3]
        // arr1 finished → copy remaining [5, 6] → result = [1, 2, 2, 3, 5, 6]

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 5, 6};

        int[] merged = mergeSortedArrays(arr1, arr2);

        // 🖥️ Expected Output: [1, 2, 2, 3, 5, 6]
        System.out.println(Arrays.toString(merged));
    }
}

/*
============================================
🧮  Time Complexity Calculation:
--------------------------------------------
- We traverse each array exactly once.
- Comparisons: O(m + n)
- Copying remaining elements: O(m + n)
✅ Total Time Complexity = O(m + n)

💾  Space Complexity Calculation:
--------------------------------------------
- Extra array "result" of size (m + n)
✅ Space Complexity = O(m + n)

⚡ Note:
If merging in-place (without extra array) was required, space could be O(1)
but here we create a new array → O(m+n).

============================================
*/
