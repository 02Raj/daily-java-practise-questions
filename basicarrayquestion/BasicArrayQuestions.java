package basicarrayquestion;

import java.util.*;

/*
===========================================================
📦 Class: BasicArrayQuestions
===========================================================
📅 Created: 10-04-2025
===========================================================

📝 About This File:
Yeh file basic array problems ka collection hai.
Har method ek alag problem solve karta hai.
Brute force se optimal tak ke approaches cover kiye hain.
Har method ke upar ab Problem Statement + Input + Output bhi likha hai
taaki bina code padhe hi samajh aa jaaye ki method kya karta hai.

Methods List:
 1.  sortedArray              → Selection Sort
 2.  sumOfArray               → Array ka sum
 3.  avgOfArray               → Array ka average
 4.  largestElementArray      → Sabse bada element
 5.  secondLargestElementArray→ Doosra sabse bada element
 6.  ifArraySort              → Array sorted hai ya nahi
 7.  containSpecificValue     → Specific value hai ya nahi
 8.  removeSpecificElement    → Specific element remove karo
 9.  removeSpecificElementUsingArrayList
10.  insertElementSpecificPosition
11.  insertElementSpecificPositionUsingArrayList
12.  copyOfArray              → Array copy karo
13.  findIndexOfArrayElement  → Element ka index dhundho
14.  maxAndMinValueOfArray    → Max aur Min dono ek saath
15.  reverseArray (print)     → Print in reverse
16.  duplicateValueOfArray    → HashMap se duplicates dhundho
17.  commonElementArrays      → Do arrays ke common elements
18.  duplicateValueUsingHashMap
19.  leftRotateArray          → 1 baar left rotate
20.  removeDuplicateElementOfArray
21.  longestConsecutive       → Longest consecutive sequence
22.  reverseArray (in-place)  → Actual reverse (two pointer)
23.  rotateArrayKtimes        → K baar right rotate (reversal trick)
24.  moveAllZerosToEnd        → Saare 0s end pe le jao
25.  countOfSmallerElement    → x se chhote kitne elements
26.  findUnion                → Do arrays ka union (TreeSet)
27.  missingNumber            → Missing number dhundho
28.  maximumConsecutiveOnes   → Max consecutive 1s
29.  longestSubarrayWithSumKPositive    → Sliding window
30.  longestSubarrayWithSumKPositiveAndNegative → HashMap prefix sum
31.  sortColors (2 pass)      → Count and overwrite
32.  sortColors2 (1 pass)     → Dutch National Flag
33.  majorityElement          → N/2 se zyada (brute + Boyer-Moore)
34.  maxSubarraySum           → Kadane's Algorithm
35.  maxProfit                → Best time to buy/sell stock
36.  rearrangeBySign          → Positive-Negative alternate
37.  printLeaders             → Array ke leaders
38.  longestSuccessiveElements→ Longest consecutive (HashSet)
39.  rotateMatrix             → 90 degree clockwise rotate
40.  countSubarrays           → Subarray with sum = k
41.  pascalTriangle           → Pascal triangle generate karo
42.  majorityElementNBy2Times → N/2 majority (HashMap)
43.  majorityElementNBy3Times → N/3 majority (HashMap)

===========================================================
*/

public class BasicArrayQuestions {

    // =========================================================
    // 1. SELECTION SORT
    // =========================================================
    // 📝 Problem Statement: Diye gaye array ko ascending order mein sort karo.
    // 📥 Input: int[] arr = {5, 2, 8, 1}
    // 📤 Output: arr sorted ho jaayega in-place → {1, 2, 5, 8} (return type void hai)
    // 🧠 Algorithm: Selection Sort
    // Approach: Har iteration mein minimum element dhundho
    //           aur usse current position pe swap karo
    // TC: O(n²) — do nested loops
    // SC: O(1) — in-place sorting
    // =========================================================
    static void sortedArray(int[] arr) {
        int n = arr.length;
        int min_index;

        for (int i = 0; i < n - 1; i++) {
            min_index = i; // Assume karo current i hi minimum hai

            // Inner loop: i ke baad minimum element dhundho
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j; // Naya minimum mila
                }
            }

            // Minimum ko current position pe swap karo
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    // =========================================================
    // 2. SUM OF ARRAY
    // =========================================================
    // 📝 Problem Statement: Array ke sabhi elements ka total sum print karo.
    // 📥 Input: int[] arr2 = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Sum of array is: 36" (console print, return type void)
    // 🧠 Algorithm: Linear Traversal (Brute Force Summation)
    // Approach: Ek baar traverse karo, sab jodo
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void sumOfArray(int[] arr2) {
        int n = arr2.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr2[i]; // Har element add karo sum mein
        }
        System.out.println("Sum of array is: " + sum);
    }

    // =========================================================
    // 3. AVERAGE OF ARRAY
    // =========================================================
    // 📝 Problem Statement: Array ke elements ka average nikalo aur print karo.
    // 📥 Input: int[] arr2 = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Avg of array is: 6" (integer division ki wajah se decimal cut)
    // 🧠 Algorithm: Linear Traversal (Sum then Divide)
    // Approach: Sum nikaalo, phir n se divide karo
    // TC: O(n)   SC: O(1)
    // NOTE: int division use ho raha hai — decimal cut hoga
    // =========================================================
    static void avgOfArray(int[] arr2) {
        int n = arr2.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr2[i];
        }

        int avg = sum / n; // Integer division — floor value milegi
        System.out.println("Avg of array is: " + avg);
    }

    // =========================================================
    // 4. LARGEST ELEMENT
    // =========================================================
    // 📝 Problem Statement: Array ka sabse bada (maximum) element print karo.
    // 📥 Input: int[] arr2 = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Max: 15" (⚠️ current buggy loop last element skip kar sakta hai)
    // 🧠 Algorithm: Linear Scan (Single Pass Maximum)
    // Approach: First element se max start karo, traverse karo
    // TC: O(n)   SC: O(1)
    // ⚠️ Bug: loop arr.length - 1 tak jaata hai — last element miss
    //         Fix: i < arr.length hona chahiye
    // =========================================================
    static void largestElementArray(int[] arr2) {
        int max = arr2[0]; // Pehla element assume karo max hai

        for (int i = 0; i < arr2.length - 1; i++) { // ⚠️ last element miss ho raha
            if (arr2[i] > max) {
                max = arr2[i]; // Naya max update karo
            }
        }
        System.out.println("Max: " + max);
    }

    // =========================================================
    // 5. SECOND LARGEST ELEMENT
    // =========================================================
    // 📝 Problem Statement: Array ka doosra sabse bada (unique) element print karo.
    // 📥 Input: int[] arr2 = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Second Largest Element: 10" (agar na mile toh "No second largest element found!")
    // 🧠 Algorithm: Single Pass Two-Variable Tracking (Max & SecondMax)
    // Approach: Ek pass mein max aur secondMax dono track karo
    // TC: O(n)   SC: O(1)
    //
    // Logic:
    //   Case 1: Naya element max se bada → secondMax = max, max = new
    //   Case 2: max se chhota lekin secondMax se bada → secondMax update
    //   Case 3: Dono se chhota → kuch mat karo
    // =========================================================
    static void secondLargestElementArray(int[] arr2) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                secondMax = max;    // Purana max ab secondMax banega
                max = arr2[i];      // Naya max set karo
            } else if (arr2[i] > secondMax && arr2[i] < max) {
                secondMax = arr2[i]; // secondMax update karo
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second largest element found!");
        } else {
            System.out.println("Second Largest Element: " + secondMax);
        }
    }

    // =========================================================
    // 6. CHECK IF ARRAY IS SORTED (Ascending)
    // =========================================================
    // 📝 Problem Statement: Check karo ki array ascending order mein sorted hai ya nahi.
    // 📥 Input: int[] arr2 = {2, 4, 15, 4, 10, 1}
    // 📤 Output: boolean → false (kyunki 15 > 4 hai beech mein)
    // 🧠 Algorithm: Linear Scan (Adjacent Pair Comparison)
    // Approach: Adjacent elements compare karo
    //           Koi bhi element agle se bada mila → not sorted
    // TC: O(n)   SC: O(1)
    // =========================================================
    static boolean ifArraySort(int[] arr2) {
        for (int i = 0; i < arr2.length - 1; i++) {
            if (arr2[i] > arr2[i + 1]) {
                return false; // Ye pair out of order hai → not sorted
            }
        }
        return true; // Koi bhi violation nahi mili → sorted hai
    }

    // =========================================================
    // 7. CONTAINS SPECIFIC VALUE
    // =========================================================
    // 📝 Problem Statement: Check karo ki array mein ek fixed value (7) present hai ya nahi.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: boolean → false (7 array mein nahi hai)
    // 🧠 Algorithm: Linear Search
    // Approach: Linear search — har element check karo
    // TC: O(n)   SC: O(1)
    // ⚠️ Bug: loop arr.length - 1 tak — last index check nahi hota
    //         Fix: i < arr.length
    // =========================================================
    static boolean containSpecificValue(int[] arr) {
        int specificValue = 7;

        for (int i = 0; i < arr.length - 1; i++) { // ⚠️ last element miss
            if (arr[i] == specificValue) {
                return true;
            }
        }
        return false;
    }

    // =========================================================
    // 8. REMOVE SPECIFIC ELEMENT (New Array)
    // =========================================================
    // 📝 Problem Statement: Array se ek fixed value (10) ke saare occurrences hata kar
    //                        naya chhota array print karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Count: 1" phir "Updated Array: [2, 4, 15, 4, 1]"
    // 🧠 Algorithm: Counting + Array Rebuild (Filter Technique)
    // Approach:
    //   Step 1: Count karo kitni baar element aata hai
    //   Step 2: Chhota array banao (size = n - count)
    //   Step 3: Us element ko chhod ke baaki copy karo
    // TC: O(n)   SC: O(n) — new array ban raha hai
    // =========================================================
    static void removeSpecificElement(int[] arr) {
        int removeSpecificElementIs = 10;
        int count = 0;

        // Step 1: Count karo
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == removeSpecificElementIs) count++;
        }

        System.out.println("Count: " + count);

        // Step 2: New array banao reduced size ke saath
        int[] newArr = new int[arr.length - count];
        int index = 0;

        // Step 3: Sirf wo elements copy karo jo remove nahi hone chahiye
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != removeSpecificElementIs) {
                newArr[index] = arr[i];
                index++;
            }
        }
        System.out.println("Updated Array: " + Arrays.toString(newArr));
    }

    // =========================================================
    // 9. REMOVE SPECIFIC ELEMENT USING ARRAYLIST
    // =========================================================
    // 📝 Problem Statement: Array ko ArrayList mein convert karke index 2 ka
    //                        element remove karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: List<Integer> → [2, 4, 4, 10, 1] (index 2 yaani value 15 hata di)
    // 🧠 Algorithm: ArrayList remove(index) API
    // Approach: Array → ArrayList, phir remove(index) call karo
    // TC: O(n)   SC: O(n)
    // NOTE: remove(2) means index 2 remove hoga, value 2 nahi
    // =========================================================
    static List<Integer> removeSpecificElementUsingArrayList(int[] arr) {
        List<Integer> newArr = new ArrayList<>();

        // Array ko ArrayList mein convert karo
        for (int i = 0; i < arr.length; i++) {
            newArr.add(arr[i]);
        }

        newArr.remove(2); // Index 2 ka element remove karo
        return newArr;
    }

    // =========================================================
    // 10. INSERT ELEMENT AT SPECIFIC POSITION (New Array)
    // =========================================================
    // 📝 Problem Statement: Ek fixed element (3) ko fixed position (index 2) pe
    //                        insert karo aur naya array return karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: int[] → {2, 4, 3, 15, 4, 10, 1}
    // 🧠 Algorithm: Array Rebuild (Manual Insertion via New Array)
    // Approach:
    //   Naya array banao (size + 1)
    //   Traverse karo — jab position aaye toh element daalo
    //   Baaki elements copy karo
    // TC: O(n)   SC: O(n)
    // =========================================================
    static int[] insertElementSpecificPosition(int[] arr) {
        int element = 3;
        int position = 2;

        int[] newArr = new int[arr.length + 1];

        // i = new array index, j = original array index
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == position) {
                newArr[i] = element; // Yahan naya element daalo
            } else {
                newArr[i] = arr[j]; // Purane array se copy karo
                j++;
            }
        }
        return newArr;
    }

    // =========================================================
    // 11. INSERT ELEMENT USING ARRAYLIST
    // =========================================================
    // 📝 Problem Statement: Array ko ArrayList mein convert karke index 2 pe
    //                        value 3 insert karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: List<Integer> → [2, 4, 3, 15, 4, 10, 1]
    // 🧠 Algorithm: ArrayList add(index, value) API
    // Approach: Array → ArrayList, phir add(index, value)
    // TC: O(n)   SC: O(n)
    // =========================================================
    static List<Integer> insertElementSpecificPositionUsingArrayList(int[] arr) {
        List<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            newArr.add(arr[i]);
        }

        newArr.add(2, 3); // Index 2 pe value 3 insert karo
        return newArr;
    }

    // =========================================================
    // 12. COPY OF ARRAY (Manual Deep Copy)
    // =========================================================
    // 📝 Problem Statement: Original array ki deep copy banao aur dono print karo.
    // 📥 Input: int[] originalArray = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Original Array: 2 4 15 4 10 1 " phir "Copied Array: 2 4 15 4 10 1 "
    // 🧠 Algorithm: Manual Deep Copy (Element by Element)
    // Approach: Naya array banao, element by element copy karo
    // TC: O(n)   SC: O(n)
    // NOTE: Ye deep copy hai — original change se copy affect nahi hoga
    // =========================================================
    static void copyOfArray(int[] originalArray) {
        int[] copiedArray = new int[originalArray.length];

        // Manually copy karo
        for (int i = 0; i < originalArray.length; i++) {
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

    // =========================================================
    // 13. FIND INDEX OF ARRAY ELEMENT
    // =========================================================
    // 📝 Problem Statement: Ek fixed value (4) ka pehla index array mein dhundho.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: int → 1 (index 1 pe pehli baar 4 milta hai), na mile toh -1
    // 🧠 Algorithm: Linear Search
    // Approach: Linear search — pehla match return karo
    // TC: O(n)   SC: O(1)
    // Returns: index if found, -1 if not found
    // =========================================================
    static int findIndexOfArrayElement(int[] arr) {
        int specificValue = 4;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == specificValue) {
                return i; // Pehla match milaa → index return karo
            }
        }
        return -1; // Nahi mila
    }

    // =========================================================
    // 14. MAX AND MIN VALUE OF ARRAY
    // =========================================================
    // 📝 Problem Statement: Array ka maximum aur minimum value ek saath nikalo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: int[] → {15, 1}  (index 0 = max, index 1 = min)
    // 🧠 Algorithm: Single Pass Min-Max Tracking
    // Approach: Ek hi pass mein max aur min dono track karo
    // TC: O(n)   SC: O(1)
    // Returns: int[] { max, min }
    // =========================================================
    static int[] maxAndMinValueOfArray(int[] arr) {
        int max = arr[0]; // Pehle element se shuru karo
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i]; // Naya max mila
            if (arr[i] < min) min = arr[i]; // Naya min mila
        }

        return new int[]{max, min};
    }

    // =========================================================
    // 15. REVERSE ARRAY (Print Only — Array Change Nahi Hota)
    // =========================================================
    // 📝 Problem Statement: Array ko reverse order mein print karo, actual array
    //                        modify kiye bina.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Reverse Array: 1 10 4 15 4 2 "
    // 🧠 Algorithm: Reverse Traversal (Print Only, No In-place Swap)
    // Approach: End se start tak print karo
    // TC: O(n)   SC: O(1)
    // NOTE: Actual array modify nahi hota — sirf print hota hai
    // =========================================================
    static void reverseArray(int[] arr) {
        System.out.print("Reverse Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 16. DUPLICATE VALUE OF ARRAY (HashMap Approach)
    // =========================================================
    // 📝 Problem Statement: Array mein jo bhi elements duplicate (1 se zyada baar)
    //                        aate hain unhe unki count ke saath print karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Duplicate value: 4, Count: 2"
    // 🧠 Algorithm: HashMap Frequency Counting
    // Approach (Optimal):
    //   HashMap mein har element ki frequency store karo
    //   Phir jinki frequency > 1 hai unhe print karo
    // TC: O(n)   SC: O(n)
    //
    // Brute Force (commented):
    //   Har element ko baaki sab se compare karo
    //   TC: O(n²)   SC: O(1)
    // =========================================================
    static void duplicateValueOfArray(int[] arr) {
        int duplicateValue = 0;

        /*
         * Brute Force O(n²):
         * for (int i = 0; i < arr.length-1; i++){
         *    for (int j = i + 1; j < arr.length; j++){
         *        if (arr[i] == arr[j]){
         *            duplicateValue = arr[i];
         *        }
         *    }
         * }
         */

        // Optimal: HashMap se frequency count karo
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(arr[i])) {
                map.put(num, map.get(num) + 1); // Count badhao
            } else {
                map.put(num, 1); // Pehli baar dekha
            }
        }

        // Count > 1 wale elements print karo
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate value: " + entry.getKey()
                        + ", Count: " + entry.getValue());
            }
        }
    }

    // =========================================================
    // 17. COMMON ELEMENTS IN TWO ARRAYS
    // =========================================================
    // 📝 Problem Statement: Do arrays diye hain, unme common elements print karo.
    // 📥 Input: int[] arr1 = {1,2,3,4,5,6,7,8,9,10}, int[] arr2 = {2,3,4,4,5,11,12}
    // 📤 Output: "Common elements: 2 3 4 5 "
    // 🧠 Algorithm: Brute Force Nested Loop (O(n*m))
    // Approach: Brute Force — har pair compare karo
    // TC: O(n * m) — n = arr1.length, m = arr2.length
    // SC: O(1)
    // NOTE: Optimal approach HashSet use karti hai → O(n + m)
    // =========================================================
    static void commonElementArrays(int[] arr1, int[] arr2) {
        System.out.print("Common elements: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break; // Match mila → next i pe jao
                }
            }
        }
        System.out.println();
    }

    // =========================================================
    // 18. DUPLICATE VALUE USING HASHMAP (Cleaner Version)
    // =========================================================
    // 📝 Problem Statement: Array ke duplicate elements unki count ke saath print
    //                        karo, but ek baar print hone ke baad dobara print na ho.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: "Duplicate Elements with Count:" phir "4 -> 2"
    // 🧠 Algorithm: HashMap Frequency Counting (with Printed-Marker Reset)
    // Approach: HashMap se frequency count, phir ek baar print
    //           Printed elements ko 0 mark karo (dubara na chape)
    // TC: O(n)   SC: O(n)
    // =========================================================
    static void duplicateValueUsingHashMap(int[] arr) {
        Map<Integer, Integer> duplicateCount = new HashMap<>();

        // Step 1: Frequency count karo
        for (int i = 0; i < arr.length; i++) {
            if (duplicateCount.containsKey(arr[i])) {
                int currentCount = duplicateCount.get(arr[i]);
                duplicateCount.put(arr[i], currentCount + 1);
            } else {
                duplicateCount.put(arr[i], 1);
            }
        }

        System.out.println("Duplicate Elements with Count:");
        for (int i = 0; i < arr.length; i++) {
            if (duplicateCount.get(arr[i]) > 1) {
                System.out.println(arr[i] + " -> " + duplicateCount.get(arr[i]));
                duplicateCount.put(arr[i], 0); // Mark as printed — dubara print na ho
            }
        }
    }

    // =========================================================
    // 19. LEFT ROTATE ARRAY (1 Position)
    // =========================================================
    // 📝 Problem Statement: Array ko ek position left rotate karo.
    // 📥 Input: int[] arr = {1, 2, 3, 4, 5}
    // 📤 Output: Console print → "2 3 4 5 1 " (arr in-place bhi modify ho jaata hai)
    // 🧠 Algorithm: Left Rotation (Temp Variable Shift Technique)
    // Approach:
    //   Step 1: Pehla element save karo (temp)
    //   Step 2: Sab elements ek jagah left shift karo
    //   Step 3: temp ko last position pe daalo
    //
    // Example: {1,2,3,4,5} → {2,3,4,5,1}
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void leftRotateArray(int[] arr) {
        int n = arr.length;
        int temp = arr[0]; // Pehla element bachao

        // Sab ko ek baar left shift karo
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[n - 1] = temp; // Pehla element last pe daalo

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // =========================================================
    // 20. REMOVE DUPLICATE ELEMENTS
    // =========================================================
    // 📝 Problem Statement: Array se duplicate elements hata kar sirf unique
    //                        elements ka naya array return karo.
    // 📥 Input: int[] arr = {2, 4, 15, 4, 10, 1}
    // 📤 Output: int[] → {2, 4, 15, 10, 1} (order guaranteed nahi, HashMap use ho raha)
    // 🧠 Algorithm: HashMap-based Deduplication (alt: Sort + Two Pointer)
    // Approach (Current — HashMap):
    //   HashMap mein daalo → automatically duplicates hatt jaate hain
    //   Keys nikaalo → unique array banao
    // TC: O(n)   SC: O(n)
    //
    // Approach (Commented — Two Pointer):
    //   Sort karo, phir adjacent compare karo
    //   TC: O(n log n)   SC: O(1)
    //
    // ⚠️ HashMap order guarantee nahi karta
    // =========================================================
    static int[] removeDuplicateElementOfArray(int[] arr) {
        /*
         * Two Pointer (Sorted array ke liye):
         * Arrays.sort(arr);
         * int j = 0;
         * for (int i = 1; i < arr.length; i++) {
         *     if (arr[i] != arr[j]) {
         *         j++;
         *         arr[j] = arr[i];
         *     }
         * }
         * return Arrays.copyOf(arr, j + 1);
         */

        // HashMap approach: duplicates naturally filter ho jaate hain
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1); // Duplicate hoga toh overwrite — koi issue nahi
        }

        // Map keys se result array banao
        int[] result = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            result[index++] = key;
        }
        return result;
    }

    // =========================================================
    // 21. LONGEST CONSECUTIVE SEQUENCE
    // =========================================================
    // 📝 Problem Statement: Array mein longest consecutive integers ki sequence
    //                        ki length nikalo (order array mein kuch bhi ho sakta hai).
    // 📥 Input: int[] nums = {100, 4, 200, 1, 3, 2}
    // 📤 Output: int → 4 (sequence 1,2,3,4)
    // Approach (HashSet Optimal):
    // 🧠 Algorithm: HashSet Optimal — Longest Consecutive Sequence Technique
    // Approach (HashSet Optimal):
    //   Step 1: Sab numbers HashSet mein daalo → O(1) lookup
    //   Step 2: Sirf sequence start dhundho (num-1 set mein nahi)
    //   Step 3: Wahan se aage count karo
    // TC: O(n)   SC: O(n)
    // =========================================================
    static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Set mein daalo
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Sirf tab start karo jab yeh sequence ka pehla element ho
            // (matlab num-1 set mein nahi hai)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Aage aage count karo jab tak sequence chale
                while (!numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    // =========================================================
    // 22. REVERSE ARRAY IN-PLACE (Two Pointer)
    // =========================================================
    // 📝 Problem Statement: Diye gaye range [i, j] ke beech array ko actual mein
    //                        (in-place) reverse karo.
    // 📥 Input: int[] a = {1,2,3,4,5,6,7}, i = 0, j = 6
    // 📤 Output: a in-place ho jaata hai → {7,6,5,4,3,2,1} (return type void)
    // 🧠 Algorithm: Two Pointer Technique
    // Approach: Left aur Right pointers — swap karte hue beech tak jao
    // TC: O(n)   SC: O(1)
    // NOTE: Yeh actual array modify karta hai (print wala nahi karta)
    // =========================================================
    static void reverseArray(int[] a, int i, int j) {
        int li = i;  // Left pointer
        int ri = j;  // Right pointer

        while (li < ri) {
            // Swap karo
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;
            li++;
            ri--;
        }
    }

    // =========================================================
    // 23. ROTATE ARRAY K TIMES (Right Rotation)
    // =========================================================
    // 📝 Problem Statement: Array ko k positions right rotate karo.
    // 📥 Input: int[] arr = {1,2,3,4,5,6,7}, k = 2
    // 📤 Output: arr in-place ho jaata hai → {6,7,1,2,3,4,5} (return type void)
    // 🧠 Algorithm: Reversal Algorithm (3-Step Reverse Trick)
    // Example: {1,2,3,4,5,6,7}, k=2 → {6,7,1,2,3,4,5}
    //
    // Approach (Reversal Trick — 3 Steps):
    //   k = k % n  (agar k > n ho toh handle karo)
    //   Step 1: Reverse from 0 to (n-k-1)
    //   Step 2: Reverse from (n-k) to (n-1)
    //   Step 3: Reverse full array
    //
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void rotateArrayKtimes(int[] arr, int k) {
        k = k % arr.length; // k > n case handle karo
        if (k < 0) {
            k = k + arr.length; // Negative k handle karo
        }

        reverseArray(arr, 0, arr.length - k - 1);    // Part 1 reverse
        reverseArray(arr, arr.length - k, arr.length - 1); // Part 2 reverse
        reverseArray(arr, 0, arr.length - 1);         // Full array reverse
    }

    // =========================================================
    // 24. MOVE ALL ZEROS TO END
    // =========================================================
    // 📝 Problem Statement: Array ke saare zeros ko end mein le jao, baaki
    //                        non-zero elements ka relative order same rakho.
    // 📥 Input: int[] arr = {1, 0, 2, 3, 0, 4, 0, 1}
    // 📤 Output: arr in-place ho jaata hai → {1, 2, 3, 4, 1, 0, 0, 0}
    // 🧠 Algorithm: Two Pointer Technique (Stable Partition)
    // Example: {1,0,2,3,0,4,0,1} → {1,2,3,4,1,0,0,0}
    //
    // Approach (Two Pointer):
    //   left = non-zero elements ki next position
    //   Jab bhi non-zero mile → left aur i swap karo
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void moveAllZerosToEnd(int[] arr) {
        int left = 0; // Yahan next non-zero element jayega

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Non-zero element mila → left position pe swap karo
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
            // Zero mila → kuch mat karo, i aage badho
        }
    }

    // =========================================================
    // 25. COUNT ELEMENTS SMALLER THAN OR EQUAL TO X
    // =========================================================
    // 📝 Problem Statement: Array mein kitne elements hain jo x se chhote ya
    //                        barabar hain, unka count print karo.
    // 📥 Input: int[] arr = {10, 1, 2, 8, 4, 5}, x = 9
    // 📤 Output: "Count of elements smaller or equal to 9: 5"
    // 🧠 Algorithm: Linear Scan Counting
    // Approach: Linear scan — count badhao jab arr[i] <= x
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void countOfSmallerElement(int[] arr, int x) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                count++;
            }
        }
        System.out.println("Count of elements smaller or equal to " + x + ": " + count);
    }

    // =========================================================
    // 26. FIND UNION OF TWO ARRAYS
    // =========================================================
    // 📝 Problem Statement: Do arrays ka union nikalo — unique elements, sorted order mein.
    // 📥 Input: int[] arr6 = {1..10}, int[] arr7 = {2,3,4,4,5,11,12}
    // 📤 Output: "Union: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]"
    // 🧠 Algorithm: TreeSet (Set Union, Auto Sorted + Unique)
    // Approach: TreeSet use karo
    //   TreeSet: unique elements + sorted order maintain karta hai
    // TC: O((n+m) log n)   SC: O(n+m)
    // =========================================================
    static void findUnion(int[] arr6, int[] arr7) {
        // TreeSet → unique + sorted
        Set<Integer> temp = new TreeSet<>();

        for (int i = 0; i < arr6.length; i++) temp.add(arr6[i]);
        for (int i = 0; i < arr7.length; i++) temp.add(arr7[i]);

        System.out.println("Union: " + temp);
    }

    // =========================================================
    // 27. MISSING NUMBER (1 to N range mein)
    // =========================================================
    // 📝 Problem Statement: Sorted array (1 to n range) mein se missing number
    //                        dhundho.
    // 📥 Input: int[] arr8 = {1, 2, 4, 5}
    // 📤 Output: "Missing number is: 3"
    // 🧠 Algorithm: Linear Scan Comparison (alt: Sum Formula n*(n+1)/2)
    // Approach: i (1 to n) ko arr[i-1] se compare karo
    //           Pehla mismatch = missing number
    // TC: O(n)   SC: O(1)
    // ⚠️ Assumption: Array sorted hai aur 1 to n range mein hai
    // NOTE: Optimal: Sum formula → n*(n+1)/2 - actualSum
    // =========================================================
    static void missingNumber(int[] arr8) {
        for (int i = 1; i <= arr8.length; i++) {
            if (i != arr8[i - 1]) {
                System.out.println("Missing number is: " + i);
                break;
            }
        }
    }

    // =========================================================
    // 28. MAXIMUM CONSECUTIVE ONES
    // =========================================================
    // 📝 Problem Statement: Binary array (0s aur 1s) mein maximum consecutive
    //                        1s ki length nikalo.
    // 📥 Input: int[] arr = {1, 1, 0, 1, 1, 1}
    // 📤 Output: "Maximum Consecutive Ones: 3"
    // 🧠 Algorithm: Streak Counting (Single Pass Window)
    // Example: {1,1,0,1,1,1} → 3
    //
    // Approach:
    //   count = current streak of 1s
    //   maxCount = best streak so far
    //   0 milaa → maxCount update, count reset
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void maximumConsecutiveOnes(int[] arr) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++; // Streak badhao
            } else {
                maxCount = Math.max(maxCount, count); // Best streak save karo
                count = 0; // Reset karo
            }
        }
        // Last streak check karo (loop ke baad update)
        maxCount = Math.max(maxCount, count);
        System.out.println("Maximum Consecutive Ones: " + maxCount);
    }

    // =========================================================
    // 29. LONGEST SUBARRAY WITH SUM = K (Positive Numbers Only)
    // =========================================================
    // 📝 Problem Statement: Sirf positive numbers wale array mein sabse lambi
    //                        subarray dhundho jiska sum exactly k ho.
    // 📥 Input: int[] arr = {2, 3, 5, 1, 9}, k = 3
    // 📤 Output: int → 1 (subarray {3} ya {1,2} type match; length return hoti hai)
    // 🧠 Algorithm: Sliding Window (Two Pointer, Positive-only)
    // Approach: Sliding Window (Two Pointer)
    //   right pointer aage badhta hai → sum badhta hai
    //   sum > k hone pe left pointer aage badhao → sum ghata
    //   sum == k milne pe length update karo
    // TC: O(n)   SC: O(1)
    // ⚠️ Sirf positive numbers ke liye kaam karta hai
    // =========================================================
    static int longestSubarrayWithSumKPositive(int[] arr, int k) {
        int left = 0, right = 0, maxLength = 0;
        int currentSum = 0;

        while (right < arr.length) {
            currentSum += arr[right]; // Window expand karo

            // Sum zyada ho gaya → left se shrink karo
            while (currentSum > k && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // Valid subarray mila
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    // =========================================================
    // 30. LONGEST SUBARRAY WITH SUM = K (Positive + Negative)
    // =========================================================
    // 📝 Problem Statement: Positive aur negative dono numbers wale array mein
    //                        sabse lambi subarray dhundho jiska sum exactly k ho.
    // 📥 Input: int[] arr = {-1, 1, 1}, k = 5
    // 📤 Output: int → 0 (koi bhi subarray ka sum 5 nahi ban raha is input mein)
    // 🧠 Algorithm: Prefix Sum + HashMap
    // Approach: Prefix Sum + HashMap
    //   sum = prefix sum at index i
    //   Agar (sum - k) pehle dekha tha → wahan se yahan tak subarray valid hai
    //   map.put(0, -1) → index -1 pe sum 0 tha (empty prefix)
    // TC: O(n)   SC: O(n)
    // =========================================================
    static int longestSubarrayWithSumKPositiveAndNegative(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        map.put(0, -1); // Base case: index -1 pe sum = 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Poora prefix sum == k (0 se i tak)
            if (sum == k) {
                maxLen = i + 1;
            }

            // sum - k pehle dekha tha → us point ke baad ka subarray valid hai
            if (map.containsKey(sum - k)) {
                int prevIndex = map.get(sum - k);
                maxLen = Math.max(maxLen, i - prevIndex);
            }

            // Pehli baar dekha toh hi store karo (longer subarray ke liye)
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // =========================================================
    // 31. SORT COLORS — 2 Pass (Count and Overwrite)
    // =========================================================
    // 📝 Problem Statement: Sirf 0, 1, 2 wale array ko sort karo (Dutch National
    //                        Flag problem), 2 pass approach se.
    // 📥 Input: int[] nums = {2, 0, 2, 1, 1, 0}
    // 📤 Output: nums in-place ho jaata hai → {0, 0, 1, 1, 2, 2}
    // Example: {2,0,2,1,1,0} → {0,0,1,1,2,2}
    //
    // Approach:
    //   Pass 1:
    // 🧠 Algorithm: Counting Sort (2 Pass)
    // Example: {2,0,2,1,1,0} → {0,0,1,1,2,2}
    //
    // Approach:
    //   Pass 1: 0s, 1s, 2s count karo
    //   Pass 2: Array overwrite karo counts ke hisaab se
    // TC: O(n)   SC: O(1)
    // NOTE: 2 passes lagte hain — single pass ke liye sortColors2 dekho
    // =========================================================
    static void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0, count1 = 0, count2 = 0;

        // Pass 1: Count karo
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;
        }

        // Pass 2: Overwrite karo
        int idx = 0;
        for (int i = 0; i < count0; i++) nums[idx++] = 0;
        for (int i = 0; i < count1; i++) nums[idx++] = 1;
        for (int i = 0; i < count2; i++) nums[idx++] = 2;
    }

    // =========================================================
    // 32. SORT COLORS — 1 Pass (Dutch National Flag Algorithm)
    // =========================================================
    // 📝 Problem Statement: Sirf 0, 1, 2 wale array ko single pass mein sort karo.
    // 📥 Input: int[] nums = {2, 0, 2, 1, 1, 0}
    // 📤 Output: nums in-place ho jaata hai → {0, 0, 1, 1, 2, 2}
    // Approach (3 Pointers):
    // 🧠 Algorithm: Dutch National Flag Algorithm (3 Pointer)
    // Approach (3 Pointers):
    //   low  → 0s boundary (low se pehle sab 0)
    //   mid  → current element
    //   high → 2s boundary (high ke baad sab 2)
    //
    //   Case 0: swap(low, mid), low++, mid++
    //   Case 1: mid++
    //   Case 2: swap(mid, high), high-- (mid++ NAHI — unseen element)
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void sortColors2(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // 0 milaa → front pe bhejo
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++; // 1 sahi jagah hai
            } else {
                // 2 milaa → end pe bhejo
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--; // mid++ NAHI — high se aaya element check karna hai
            }
        }
    }

    // =========================================================
    // 33. MAJORITY ELEMENT (> N/2 Times)
    // =========================================================
    // 📝 Problem Statement: Wo element dhundho jo array mein N/2 se zyada baar
    //                        aata ho.
    // 📥 Input: int[] nums = {3, 2, 3}
    // 📤 Output: "Majority element is: 3"
    // 🧠 Algorithm: Brute Force (alt Optimal: Boyer-Moore Voting Algorithm)
    // Example: {3,2,3} → 3
    //
    // Approach 1 (Current — Brute Force):
    //   Har element ke liye count karo
    //   TC: O(n²)   SC: O(1)
    //
    // Approach 2 (Optimal — Boyer-Moore Voting, commented):
    //   candidate aur count track karo
    //   count 0 → candidate change
    //   same element → count++, different → count--
    //   TC: O(n)   SC: O(1)
    // =========================================================
    static void majorityElement(int[] nums) {
        int n = nums.length;
        int halfLength = n / 2;

        // Brute Force O(n²)
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            System.out.println(nums[i] + " => " + count);

            if (count > halfLength) {
                System.out.println("Majority element is: " + nums[i]);
                return;
            }
        }

        /*
         * Boyer-Moore Voting — Optimal O(n):
         * int count = 0, candidate = 0;
         * for (int i = 0; i < nums.length; i++) {
         *     if (count == 0) candidate = nums[i];
         *     if (nums[i] == candidate) count++;
         *     else count--;
         * }
         * return candidate;
         */
    }

    // =========================================================
    // 34. MAXIMUM SUBARRAY SUM (Kadane's Algorithm)
    // =========================================================
    // 📝 Problem Statement: Contiguous subarray dhundho jiska sum sabse zyada ho,
    //                        aur wo maximum sum print karo.
    // 📥 Input: int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
    // 📤 Output: "Max subarray Sum: 6" (subarray {4,-1,2,1})
    // 🧠 Algorithm: Kadane's Algorithm
    // Example: {-2,1,-3,4,-1,2,1,-5,4} → 6 (subarray: {4,-1,2,1})
    //
    // Approach (Kadane's — Optimal):
    //   currentSum += arr[i]
    //   maxSum update karo
    //   currentSum < 0 → reset to 0 (negative prefix kaam nahi aata)
    // TC: O(n)   SC: O(1)
    //
    // Brute Force (commented): O(n²)
    // =========================================================
    static void maxSubarraySum(int[] arr) {
        /*
         * Brute Force O(n²):
         * int maxSum = Integer.MIN_VALUE;
         * for (int start = 0; start < arr.length; start++){
         *     int currentSum = 0;
         *     for (int end = start; end < arr.length; end++){
         *         currentSum += arr[end];
         *         maxSum = Math.max(currentSum, maxSum);
         *     }
         * }
         */

        // Kadane's Algorithm — Optimal O(n)
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            maxSum = Math.max(currentSum, maxSum); // Best track karo

            if (currentSum < 0) {
                currentSum = 0; // Negative prefix ko discard karo
            }
        }
        System.out.println("Max subarray Sum: " + maxSum);
    }

    // =========================================================
    // 35. BEST TIME TO BUY AND SELL STOCK
    // =========================================================
    // 📝 Problem Statement: Stock prices ka array diya hai — ek din buy karke
    //                        baad wale din sell karke maximum profit nikalo.
    // 📥 Input: int[] arr = {7, 1, 5, 3, 6, 4}
    // 📤 Output: "Max Profit = 5" (buy @1, sell @6)
    // 🧠 Algorithm: Greedy Single Pass (Min Price Tracking)
    // Example: {7,1,5,3,6,4} → 5 (buy @1, sell @6)
    //
    // Approach:
    //   min_price = sabse sasta price jahan buy kiya
    //   Har din: agar aaj ka price min se zyada → profit calculate karo
    //            agar aaj ka price min se kam → min update karo
    // TC: O(n)   SC: O(1)
    // =========================================================
    static void maxProfit(int[] arr) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min_price) {
                min_price = arr[i]; // Sasta din mila → yahan buy karo
            } else {
                int profit = arr[i] - min_price; // Aaj sell karne ka profit
                max_profit = Math.max(max_profit, profit); // Best profit update
            }
        }
        System.out.println("Max Profit = " + max_profit);
    }

    // =========================================================
    // 36. REARRANGE ARRAY BY SIGN (Alternate Positive-Negative)
    // =========================================================
    // 📝 Problem Statement: Array ke positive aur negative numbers ko alternate
    //                        (pos, neg, pos, neg...) order mein rearrange karo.
    // 📥 Input: int[] arr = {1, 2, -4, -5}
    // 📤 Output: List<Integer> → [1, -4, 2, -5]
    // 🧠 Algorithm: Two List Separation + Alternate Merge
    // Example: {1,2,-4,-5} → {1,-4,2,-5}
    //
    // Approach:
    //   Step 1: Positive aur Negative alag lists mein daalo
    //   Step 2: Alternate order mein result list mein daalo
    // TC: O(n)   SC: O(n)
    // ⚠️ Assumption: Equal number of positives and negatives
    // =========================================================
    static List<Integer> rearrangeBySign(int[] arr) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // Step 1: Separate karo
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) positive.add(arr[i]);
            else negative.add(arr[i]);
        }

        // Step 2: Alternate order mein daalo (pos, neg, pos, neg...)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < positive.size(); i++) {
            result.add(positive.get(i));
            result.add(negative.get(i));
        }
        return result;
    }

    // =========================================================
    // 37. PRINT LEADERS IN ARRAY
    // =========================================================
    // 📝 Problem Statement: Array ke "leaders" dhundho — leader wo element hai
    //                        jo apne right side ke saare elements se bada ho.
    // 📥 Input: int[] arr = {10, 22, 12, 3, 0, 6}
    // 📤 Output: List<Integer> → [22, 12, 6]
    // 🧠 Algorithm: Right-to-Left Traversal (Suffix Maximum Technique)
    // Example: {10,22,12,3,0,6} → {22,12,6}
    //          (6 is always leader, 12 > {3,0,6}, 22 > {12,3,0,6})
    //
    // Approach: Right se left traverse karo
    //   max_from_right track karo
    //   Jab arr[i] > max_from_right → leader hai
    // TC: O(n)   SC: O(n) for result list
    // =========================================================
    static List<Integer> printLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int max_from_right = arr[arr.length - 1];
        leaders.add(max_from_right); // Rightmost element hamesha leader hai

        // Right se left jao
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] > max_from_right) {
                max_from_right = arr[i]; // Naya max mila
                leaders.add(max_from_right); // Leader hai
            }
        }

        // Right to left collect kiya → reverse karo for correct order
        Collections.reverse(leaders);
        return leaders;
    }

    // =========================================================
    // 38. LONGEST SUCCESSIVE ELEMENTS (Consecutive Sequence)
    // =========================================================
    // 📝 Problem Statement: Array mein longest consecutive integers ki sequence
    //                        ki length print karo (21 wale method jaisa hi, but print karta hai).
    // 📥 Input: int[] arr = {100, 200, 1, 3, 2, 4}
    // 📤 Output: "Longest consecutive length: 4" (sequence 1,2,3,4)
    // 🧠 Algorithm: HashSet Optimal — Longest Consecutive Sequence Technique
    // Example: {100,200,1,3,2,4} → 4 (sequence: 1,2,3,4)
    //
    // Approach (HashSet Optimal):
    //   num-1 set mein nahi → yeh sequence ka start hai
    //   Wahan se count karo aage tak
    // TC: O(n)   SC: O(n)
    // =========================================================
    static void longestSuccessiveElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int max_len = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            // Sirf sequence ke starting point se shuru karo
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Aage count karo
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                max_len = Math.max(max_len, count);
                System.out.println("Longest consecutive length: " + max_len);
            }
        }
    }

    // =========================================================
    // 39. ROTATE MATRIX 90 DEGREES CLOCKWISE
    // =========================================================
    // 📝 Problem Statement: N x N matrix ko in-place 90 degree clockwise rotate karo.
    // 📥 Input: int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}
    // 📤 Output: matrix in-place ho jaata hai → {{7,4,1},{8,5,2},{9,6,3}}
    // 🧠 Algorithm: Transpose + Reverse Rows (In-place Matrix Rotation)
    // Example: [[1,2,3],[4,5,6],[7,8,9]] → [[7,4,1],[8,5,2],[9,6,3]]
    //
    // Approach (In-place — 2 Steps):
    //   Step 1: Transpose karo (matrix[i][j] ↔ matrix[j][i])
    //   Step 2: Har row ko reverse karo
    // TC: O(n²)   SC: O(1)
    // =========================================================
    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // j = i+1 se shuru — diagonal ke ek taraf
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Har row reverse karo
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // =========================================================
    // HELPER: Reverse a Single Row (Two Pointer)
    // =========================================================
    // 📝 Problem Statement: Ek single row (1D array) ko in-place reverse karo.
    // 📥 Input: int[] row = {1, 2, 3}
    // 📤 Output: row in-place ho jaata hai → {3, 2, 1}
    // 🧠 Algorithm: Two Pointer Technique
    static void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    // =========================================================
    // 40. COUNT SUBARRAYS WITH SUM = K
    // =========================================================
    // 📝 Problem Statement: Array mein kitni subarrays hain jinka sum exactly
    //                        k (=6, fixed) hai, unka total count print karo.
    // 📥 Input: int[] arr = {3, 1, 2, 4}
    // 📤 Output: "Count: 2" (subarrays: {3,1,2} aur {2,4})
    // 🧠 Algorithm: Prefix Sum + HashMap
    // Example: {3,1,2,4}, k=6 → 2
    //
    // Approach: Prefix Sum + HashMap
    //   map.put(0,1) → empty subarray ka base case
    //   Har index pe: sum - k pehle dekha → count badhao
    // TC: O(n)   SC: O(n)
    // =========================================================
    static void countSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int k = 6;

        map.put(0, 1); // Base case: empty prefix

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // sum - k pehle mila tha → valid subarray count karo
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Current sum ko map mein store karo
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Count: " + count);
    }

    // =========================================================
    // 41. PASCAL'S TRIANGLE
    // =========================================================
    // 📝 Problem Statement: Diye gaye numRows tak Pascal's Triangle generate karo.
    // 📥 Input: int numRows = 5
    // 📤 Output: List<List<Integer>> →
    //            [[1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1]]
    // 🧠 Algorithm: Dynamic Programming (Row Built from Previous Row)
    // Property: Har element = usse upar ke do elements ka sum
    //           Pehla aur aakhri element = 1
    //
    // Approach: Row by row banao using previous row
    // TC: O(n²)   SC: O(n²)
    // =========================================================
    public static List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // Corners hamesha 1
                } else {
                    // Upar ke do elements ka sum
                    int num = result.get(i - 1).get(j) + result.get(i - 1).get(j - 1);
                    row.add(num);
                }
            }
            result.add(row);
        }
        return result;
    }

    // Helper: Pascal triangle print karo
    // 📝 Problem Statement: pascalTriangle() se aayi list ko row-wise console pe print karo.
    // 📥 Input: int numRows = 5
    // 📤 Output: Console pe har row print hoti hai (1 / 1 1 / 1 2 1 / ...), return void
    // 🧠 Algorithm: Simple Traversal & Print
    public static void printPascalTriangle(int numRows) {
        List<List<Integer>> triangle = pascalTriangle(numRows);
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Helper: Specific position (r, c) ka element nikalo
    // 📝 Problem Statement: Pascal's Triangle ke row r (1-indexed) aur column c
    //                        (0-indexed) ka element nikalo.
    // 📥 Input: r = 5, c = 3
    // 📤 Output: int → 4 (row 5 → 1 4 6 4 1, index 3 = 4)
    // 🧠 Algorithm: Direct Lookup (via Pascal's Triangle Construction)
    public static int getElementAtPosition(int r, int c) {
        List<List<Integer>> triangle = pascalTriangle(r);
        if (r <= 0 || c < 0 || c >= triangle.get(r - 1).size()) {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
        return triangle.get(r - 1).get(c);
    }

    // =========================================================
    // 42. MAJORITY ELEMENT > N/2 TIMES (HashMap)
    // =========================================================
    // 📝 Problem Statement: Wo element dhundho jo array mein N/2 se zyada baar
    //                        aata ho, HashMap frequency count use karke.
    // 📥 Input: int[] arr = {1, 2, 2, 3, 2}
    // 📤 Output: "Majority element (N/2): 2" (2 appears 3 > 5/2 = 2 times)
    // 🧠 Algorithm: HashMap Frequency Counting (alt Optimal: Boyer-Moore Voting)
    // Example: {1,2,2,3,2} → 2 (appears 3 > 5/2 = 2 times)
    //
    // Approach: HashMap se frequency count karo, jaise hi threshold
    //           cross ho → return karo
    // TC: O(n)   SC: O(n)
    // NOTE: Optimal → Boyer-Moore Voting O(n) O(1)
    // =========================================================
    static void majorityElementNBy2Times(int[] arr) {
        int halfLength = arr.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // Count badhao

            if (map.get(arr[i]) > halfLength) {
                System.out.println("Majority element (N/2): " + arr[i]);
                return;
            }
        }
    }

    // =========================================================
    // 43. MAJORITY ELEMENT > N/3 TIMES (HashMap)
    // =========================================================
    // 📝 Problem Statement: Wo element dhundho jo array mein N/3 se zyada baar
    //                        aata ho, HashMap frequency count use karke.
    // 📥 Input: int[] arr = {1, 2, 2, 3, 2}
    // 📤 Output: "Majority element (N/3): 2" (2 appears 3 > 5/3 = 1 time)
    // 🧠 Algorithm: HashMap Frequency Counting
    // Example: {1,2,2,3,2} → 2 (appears 3 > 5/3 = 1 time)
    //
    // NOTE: Maximum 2 hi aise elements ho sakte hain
    // TC: O(n)   SC: O(n)
    // =========================================================
    static void majorityElementNBy3Times(int[] arr) {
        int thirdLength = arr.length / 3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // Count badhao

            if (map.get(arr[i]) > thirdLength) {
                System.out.println("Majority element (N/3): " + arr[i]);
                return;
            }
        }
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {
        int[] arr  = {1789, 2035, 1899, 1456, 2013};
        int[] arr2 = {2, 4, 15, 4, 10, 1};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 0, 2, 3, 0, 4, 0, 1};
        int[] arr5 = {10, 1, 2, 8, 4, 5};
        int[] arr6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr7 = {2, 3, 4, 4, 5, 11, 12};
        int[] nums = {49, 1, 3, 200, 2, 4, 70, 5};
        int[] arr8 = {1, 2, 4, 5};
        int[] arr9 = {1, 1, 0, 1, 1, 1};
        int[] arr10 = {2, 3, 5, 1, 9};
        int k = 10;
        int[] arr11 = {-1, 1, 1};
        int k1 = 5;
        int[] arr12 = {2, 0, 2, 1, 1, 0};
        int[] arr13 = {3, 2, 3};
        int[] arr14 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr15 = {7, 1, 5, 3, 6, 4};
        int[] arr16 = {1, 2, -4, -5};
        int[] arr17 = {10, 22, 12, 3, 0, 6};
        int[] arr18 = {100, 200, 1, 3, 2, 4};
        int[][] arr19 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] arr20 = {3, 1, 2, 4};
        int[] arr21 = {1, 2, 2, 3, 2};
        int numRows = 5;
        int[] arr22 = {4, 2, 2, 6, 4};
        int k2 = 6;

        // ── 1. Sum & Average ──────────────────────────────────
        sumOfArray(arr2);
        avgOfArray(arr2);

        // ── 2. Sorting ────────────────────────────────────────
        sortedArray(arr);
        System.out.print("Sorted Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        // ── 3. Finding Elements ───────────────────────────────
        largestElementArray(arr2);
        secondLargestElementArray(arr2);
        System.out.println("Is arr2 sorted? " + ifArraySort(arr2));

        // ── 4. Contains Specific Value ────────────────────────
        System.out.println("Contains specific value? " + containSpecificValue(arr2));

        // ── 5. Find Index ─────────────────────────────────────
        int index = findIndexOfArrayElement(arr2);
        System.out.println("Index of specific value: " + index);

        // ── 6. Remove Specific Element ────────────────────────
        removeSpecificElement(arr2);

        // ── 7. Copy Array ─────────────────────────────────────
        copyOfArray(arr2);

        // ── 8. Insert Element ─────────────────────────────────
        int[] result = insertElementSpecificPosition(arr2);
        System.out.println("After insertion: " + Arrays.toString(result));
        System.out.println("Insert (ArrayList): " + insertElementSpecificPositionUsingArrayList(arr2));

        // ── 9. Duplicates ─────────────────────────────────────
        duplicateValueOfArray(arr2);
        duplicateValueUsingHashMap(arr2);

        // ── 10. Remove Duplicates ─────────────────────────────
        System.out.println("Without duplicates: " + Arrays.toString(removeDuplicateElementOfArray(arr2)));
        System.out.println("Remove index 2 (ArrayList): " + removeSpecificElementUsingArrayList(arr2));

        // ── 11. Max & Min ─────────────────────────────────────
        System.out.println("Max and Min: " + Arrays.toString(maxAndMinValueOfArray(arr2)));

        // ── 12. Reverse ───────────────────────────────────────
        reverseArray(arr2);

        // ── 13. Left Rotate ───────────────────────────────────
        leftRotateArray(arr3);

        // ── 14. Longest Consecutive ───────────────────────────
        System.out.println("Longest consecutive: " + longestConsecutive(nums));

        // ── 15. Rotate K Times ────────────────────────────────
        rotateArrayKtimes(arr3, k);
        System.out.println("Rotated K times: " + Arrays.toString(arr3));

        // ── 16. Move Zeros to End ─────────────────────────────
        moveAllZerosToEnd(arr4);
        System.out.println("Zeros moved to end: " + Arrays.toString(arr4));

        // ── 17. Count Smaller Elements ───────────────────────
        countOfSmallerElement(arr5, 9);

        // ── 18. Union ─────────────────────────────────────────
        findUnion(arr6, arr7);

        // ── 19. Missing Number ────────────────────────────────
        missingNumber(arr8);

        // ── 20. Max Consecutive Ones ──────────────────────────
        maximumConsecutiveOnes(arr9);

        // ── 21. Longest Subarray (Positive) ───────────────────
        System.out.println("Longest subarray sum=k (positive): " + longestSubarrayWithSumKPositive(arr10, 3));

        // ── 22. Longest Subarray (Pos+Neg) ────────────────────
        System.out.println("Longest subarray sum=k (any): " + longestSubarrayWithSumKPositiveAndNegative(arr11, k1));

        // ── 23. Sort Colors (2 pass) ──────────────────────────
        sortColors(arr12);
        System.out.println("Sort Colors (2 pass): " + Arrays.toString(arr12));

        // ── 24. Sort Colors (1 pass DNF) ─────────────────────
        int[] arr12b = {2, 0, 2, 1, 1, 0};
        sortColors2(arr12b);
        System.out.println("Sort Colors (1 pass): " + Arrays.toString(arr12b));

        // ── 25. Majority Element ──────────────────────────────
        majorityElement(arr13);

        // ── 26. Max Subarray Sum ──────────────────────────────
        maxSubarraySum(arr14);

        // ── 27. Best Time to Buy & Sell ───────────────────────
        maxProfit(arr15);

        // ── 28. Rearrange by Sign ─────────────────────────────
        System.out.println("Rearranged by sign: " + rearrangeBySign(arr16));

        // ── 29. Leaders ───────────────────────────────────────
        System.out.println("Leaders: " + printLeaders(arr17));

        // ── 30. Longest Successive ────────────────────────────
        longestSuccessiveElements(arr18);

        // ── 31. Rotate Matrix ─────────────────────────────────
        rotateMatrix(arr19);
        System.out.println("Rotated Matrix:");
        for (int[] row : arr19) {
            System.out.println(Arrays.toString(row));
        }

        // ── 32. Count Subarrays ───────────────────────────────
        countSubarrays(arr20);

        // ── 33. Pascal's Triangle ─────────────────────────────
        printPascalTriangle(numRows);
        System.out.println("Element at (5,3): " + getElementAtPosition(5, 3));

        // ── 34. Majority Element N/2 & N/3 ───────────────────
        majorityElementNBy2Times(arr21);
        majorityElementNBy3Times(arr21);
    }
}