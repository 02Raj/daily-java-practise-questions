package basicarrayquestion;

import java.util.*;

public class BasicArrayQuestions {


    // selection sort for sorting
    static void sortedArray(int[] arr){
         int n  = arr.length;             // {2,4,15,4,10,1};
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

  static List<Integer>removeSpecificElementUsingArrayList(int[] arr){

        List<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            newArr.add(arr[i]);
        }

        newArr.remove(2);

        return newArr;
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
    static List<Integer> insertElementSpecificPositionUsingArrayList(int[] arr){

        List<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            newArr.add(arr[i]);
        }

        newArr.add(2,3);

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

//    array[] = {1,2,3,4,5}
//    Output: 2,3,4,5,1
    static void leftRotateArray(int[] arr){
       int n = arr.length;
//        System.out.println("arr{n-1]: " + arr[n-1]);
       int temp = arr[0];

       for (int i = 0; i < arr.length - 1; i++){
           arr[i] = arr[i+1];
       }

       arr[n-1] = temp;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    static int[] removeDuplicateElementOfArray(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort array

        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i]; // Overwrite duplicates
            }
        }

        return Arrays.copyOf(arr, j + 1); // Step 3: Create a new array with unique values
    }

    static int longestConsecutive(int[] nums){
        if ( nums == null || nums.length == 0){
            return 0;
        }
         // Step 1: Sabhi numbers ko HashSet mein daalo
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            numSet.add(nums[i]);
        }

        int longestStreak = 0;
        // Step 2: Har number ke liye check karo
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            // Check karo ki yeh sequence ka starting point hai ya nahi
            if ((!numSet.contains(num - 1))){
                int currentNum = num;
                int currentStreak = 1;
                // Sequence ki length count karo
                while(!numSet.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                // Maximum length update karo
                longestStreak = Math.max(longestStreak,currentStreak);

            }
        }

        return longestStreak;
    }
    static void  reverseArray(int[]a,int i, int j){
        int li = i;
        int ri = j;

        while(li < ri){
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;
            li++;
            ri--;
        }
    }

//    Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
//    Output: 6 7 1 2 3 4 5
  static void  rotateArrayKtimes(int[] arr,int k){
        k = k % arr.length;
        if(k < 0){
            k = k + arr.length;
        }
//     part 1
      reverseArray(arr,0,arr.length - k - 1);
        // part 2
      reverseArray(arr,arr.length - k, arr.length - 1);
// part 1 + part 2 ( complete)
      reverseArray(arr,0,arr.length - 1);
    }

//    Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
//    Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
    static void moveAllZerosToEnd(int[] arr){
        int left = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
    }

    static void countOfsmallerElement(int[] arr, int x) {
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                count++;
            }
        }


        System.out.println("Count of elements smaller or equal to " + x + ": " + count);
    }

//    arr6[] = {1,2,3,4,5}
//    arr7[] = {2,3,4,4,5}
//    Output:
//    {1,2,3,4,5}
    static void findUnion(int[] arr6,int[] arr7){

        //TreeSet is a collection that stores unique elements in sorted (ascending) order.
        Set<Integer> temp = new TreeSet<>();

        for (int i = 0; i < arr6.length; i++){
            temp.add(arr6[i]);
        }
        for (int i = 0; i < arr7.length; i++){
            temp.add(arr7[i]);
        }

        System.out.println("temp; " + temp);
    }


    static void missingNumber(int[] arr8){

        for (int i = 1; i <= arr8.length;i++){
//            System.out.println("Index: " + i + ", Value: " + arr8[i - 1]);
            if (i !=  arr8[i - 1]){
//                System.out.println("Index: " + i + ", Value: " + arr8[i - 1]);
                System.out.println("missing number is: " + i);
                break;
            }
        }

    }

    //prices = {1, 1, 0, 1, 1, 1}
//    Output: 3
    static void maximumConsecutiveOnes(int[] arr){

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                count++;

            }else{
                maxCount = Math.max(maxCount,count);
            }
        }

        maxCount = Math.max(maxCount, count);

        System.out.println("Maximum Consecutive Ones: " + maxCount);
    }

//    N = 3, k = 5, array[] = {2,3,5}
//    Result: 2
    static int longestSubarrayWithSumKPositive(int[] arr, int k) {
        int left = 0, right = 0, maxLength = 0;
        int currentSum = 0;

        while (right < arr.length) {
            currentSum += arr[right];

            // Adjust the left pointer until the sum becomes ≤ k
            while (currentSum > k && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // If we find a valid subarray with sum k
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }

//    Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
//    Result: 3
    static int longestSubarrayWithSumKPositoveAndNegative(int[] arr,int k){
     Map<Integer,Integer>  map = new HashMap<>();
       int sum = 0;
       int maxLen = 0;

       map.put(0,-1);
       for (int i = 0; i < arr.length; i++){
           sum += arr[i];

           if(sum == k){
               maxLen = i + 1;
           }

           if (map.containsKey(sum - k)){
               int prevIndex = map.get(sum - k);
               maxLen = Math.max(maxLen, i - prevIndex);
           }
       }

       return maxLen;
    }

    // 2 passes
//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
    static void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0, count1 = 0, count2 = 0;

        // Step 1: Count 0s, 1s, and 2s
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;
        }

        // Step 2: Overwrite array with 0s, then 1s, then 2s
        int idx = 0;

        for (int i = 0; i < count0; i++) {
            nums[idx++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            nums[idx++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[idx++] = 2;
        }
    }

//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//Dutch National Flag Algorithm  (single passes)
    static void sortColors2(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

//    Input Format: N = 3, nums[] = {3,2,3}
//    Result: 3
    static void majorityElement(int[] nums){
        int n = nums.length;
        int halfLength = n / 2;

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

/*        optimal code with time complexity is O(n)
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;*/

    }

    static void maxSubarraySum(int[] arr){

/*        Brut-force-method TimeComplexcity O(n^2)
       int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < arr.length; start++){
            int currentSum = 0;
            for (int end = start; end < arr.length; end++){
                currentSum += arr[end];
                maxSum = Math.max(currentSum,maxSum);
            }
        }
        System.out.println("Max subarray Sum: " + maxSum);*/

        //Kadane's Algorithm (optimal  TimeComplexcity O(n) )
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0 ; i < arr.length; i++){
            currentSum += arr[i];
            maxSum= Math.max(currentSum, maxSum);

            if (currentSum < 0){
                currentSum = 0;
            }
        }

        System.out.println("Max subarray Sum: " + maxSum);

    }

//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and
//    sell on day 5 (price = 6), profit = 6-1 = 5.
//
//    Note: That buying on day 2 and selling on day 1
//    is not allowed because you must buy before
//    you sell.
    static void maxProft(int[] arr) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        int profit;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min_price) {
                min_price = arr[i];
            } else {
                profit = arr[i] - min_price;  // sell - buy
                max_profit = Math.max(max_profit, profit);  // maximum profit update
            }
        }

        System.out.println("Max Profit = " + max_profit);
    }
    static List<Integer> rearrangeBySign(int[] arr){

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                positive.add(arr[i]);
            }else {
                negative.add(arr[i]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < positive.size(); i++) {
            result.add(positive.get(i));
            result.add(negative.get(i));
        }
        return result;
    }

    static List<Integer> printLeaders(int[] arr){
              List<Integer> leaders = new ArrayList<>();
              int max_from_right = arr[arr.length - 1];
               leaders.add(max_from_right); // rightmost element is always a leader
                for (int i = arr.length - 2; i > 0; i--){
               if(arr[i] > max_from_right){
            max_from_right = arr[i];
          leaders.add(max_from_right);
            }
         }
        // Leaders are collected from right to left, so reverse them
        Collections.reverse(leaders);
        return leaders;
    }

//    input: [100, 200, 1, 3, 2, 4]
//    Output: 4
   static void longestSuccessiveElements(int[] arr){
//        TreeSet is a collection in Java that stores unique elements in sorted (ascending) order and does not allow null elements.
//        It is based on a Red-Black Tree and provides log(n) time complexity for basic operations
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr.length; i++){
            set.add(arr[i]);
        }
        int max_len = 0;

        for (int i = 0; i < arr.length; i++){
            int num = arr[i];

            if(!set.contains(num - 1)){
                int currentNum = num;
                int count = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    count++;
                }

                max_len = Math.max(max_len,count);
                System.out.println("Longest consecutive length: " + max_len);
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {1789, 2035, 1899, 1456, 2013};
        int[] arr2 = {2, 4, 15, 4, 10, 1};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        int[] arr5 = {10, 1, 2, 8, 4, 5};
        int[] arr6 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr7 = {2,3,4,4,5,11,12};
        int[] nums = {49, 1, 3, 200, 2, 4, 70, 5};
        int[] arr8 = {1, 2, 4, 5};
        int[] arr9 = {1, 1, 0, 1, 1, 1};
        int[] arr10 ={2,3,5,1,9};
        int k = 10;

        int[] arr11 = {-1, 1, 1};
        int k1 = 5;
        int[] arr12 = {2,0,2,1,1,0};
        int[] arr13 = {3,2,3};
        int[] arr14 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr15 = {7,1,5,3,6,4};
        int[] arr16 = {1, 2, -4, -5};
        int[] arr17 = {10, 22, 12, 3, 0, 6};
        int[] arr18 = {100, 200, 1, 3, 2, 4};
        // 1. SUM AND AVERAGE OF ARRAY
      /*  sumOfArray(arr2);
        avgOfArray(arr2);*/

        //  2. SORTING ARRAY
     /*   sortedArray(arr);
        System.out.println("Sorted Array:");
        for (int num : arr2) {
            System.out.print(num + " ");
        }*/

        //  3. FINDING ELEMENTS IN ARRAY
      /*  largestElementArray(arr2);
        secondLrgestElementArray(arr2);
        boolean isSorted = ifArraySort(arr2);
        System.out.println("Is arr2 sorted? " + isSorted);*/

        //  4. CHECK IF ARRAY CONTAINS A SPECIFIC VALUE
       /* boolean containsValue = containSpecificValue(arr2);
        System.out.println("Does arr2 contain specific value? " + containsValue);
*/
        //  5. FIND INDEX OF AN ELEMENT
        int index = findIndexOfArrayElement(arr2);
        System.out.println("Index of specific value: " + index);

        //  6. REMOVE SPECIFIC ELEMENT
        removeSpecificElement(arr2);

        //  7. COPY ARRAY
        copyOfArray(arr2);

        //  8. INSERT ELEMENT AT A SPECIFIC POSITION
        int[] result = insertElementSpecificPosition(arr2);
        System.out.println("New Array after insertion: " + Arrays.toString(result));

        List<Integer> result2 = insertElementSpecificPositionUsingArrayList(arr2);
        System.out.println("Insert element at specific position (ArrayList): " + result2);

        //  9. FIND DUPLICATE VALUES
    /*    duplicateValueOfArray(arr2);
        duplicateValueUsingHashMap(arr2);*/

        //  10. REMOVE DUPLICATE ELEMENTS
        removeDuplicateElementOfArray(arr2);
        List<Integer> result3 = removeSpecificElementUsingArrayList(arr2);
        System.out.println("Array after removing specific element: " + result3);

        //  11. FIND MAX AND MIN ELEMENTS
        int[] maxAndMinResult = maxAndminValueOfArray(arr2);
        System.out.println("Max and Min: " + Arrays.toString(maxAndMinResult));

        //  12. REVERSE ARRAY
        reverseArray(arr2);
        leftRotateArray(arr3);
        System.out.println("Rotated Array: " + Arrays.toString(arr2));
        int length = longestConsecutive(nums);
        System.out.println("Length of the longest consecutive sequence: " + length);
        int m = 3;
        rotateArrayKtimes(arr3,k);
        System.out.println("Rotated Array: " + Arrays.toString(arr3));
        moveAllZerosToEnd(arr4);
        System.out.println("move all zero to end: " + Arrays.toString(arr4));
        int x = 9;
        countOfsmallerElement(arr5,x);
        findUnion(arr6,arr7);
        missingNumber(arr8);
        maximumConsecutiveOnes(arr9);
        longestSubarrayWithSumKPositive(arr10,k);
        System.out.println("Longest Subarray Length: " + longestSubarrayWithSumKPositive(arr10,m));
        longestSubarrayWithSumKPositoveAndNegative(arr11,k1);
        System.out.println("Longest Subarray Length: " + longestSubarrayWithSumKPositoveAndNegative(arr10,m));
        sortColors(arr12);
        for (int num : arr12) {
            System.out.print(num + " ");
        }

        sortColors2(arr12);

        for (int num1 : arr12) {
            System.out.print(num1 + " ");
        }
        majorityElement(arr13);

        maxSubarraySum(arr14);

        maxProft(arr15);

        List<Integer> result1 = rearrangeBySign(arr16);

   /*     for (int num : result1) {
            System.out.print(num + " ");
        }*/

        List<Integer> leaders = printLeaders(arr17);

        for (int val : leaders) {
            System.out.print(val + " ");
        }

        longestSuccessiveElements(arr18);
    }


}
