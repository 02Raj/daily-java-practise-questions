package basicarrayquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    /*
    =============================================================
                       HASHMAP APPROACH
    =============================================================

    ✔ Use When
    - Need INDICES.
    - Array can be Sorted OR Unsorted.
    - LeetCode Two Sum (Most Expected Interview Answer).

    Stores
    Value -> Index

    Time Complexity : O(n)
    Space Complexity: O(n)

    Example
    nums = {2,7,11,15}
    target = 9

    Output
    [0,1]
    */

    public static int[] twoSumHashMap(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            map.put(nums[i],i);
        }

        return null;
    }


    /*
    =============================================================
                       HASHSET APPROACH
    =============================================================

    ✔ Use When
    - Need only VALUES.
    - Indices are NOT required.
    - Array can be Sorted OR Unsorted.

    Stores
    Only Values

    Time Complexity : O(n)
    Space Complexity: O(n)

    Example Output
    [2,7]
    */

    public static int[] twoSumHashSet(int[] nums,int target){

        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){

            int complement = target-num;

            if(set.contains(complement)){
                return new int[]{complement,num};
            }

            set.add(num);
        }

        return null;
    }


    /*
    =============================================================
                     TWO POINTER APPROACH
    =============================================================

    ✔ Best When
    - Array is ALREADY SORTED.

    ✔ If array is UNSORTED
    - Sort first.
    - Then apply Two Pointer.

    Returns
    Values

    Time Complexity
    Sorted Array      -> O(n)
    Unsorted Array    -> O(n log n)

    Space Complexity
    Sorted Array      -> O(1)
    Sorted Copy       -> O(n)
    */

    public static int[] twoSumTwoPointer(int[] arr,int target){

        int[] copy = Arrays.copyOf(arr,arr.length);

        Arrays.sort(copy);

        int left=0;
        int right=copy.length-1;

        while(left<right){

            int sum=copy[left]+copy[right];

            if(sum==target){
                return new int[]{copy[left],copy[right]};
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }

        }

        return null;
    }


    public static void main(String[] args) {

        int[] nums={2,7,11,15};

        int target=9;

    }

}


/*
=============================================================
            TWO SUM INTERVIEW REVISION
=============================================================

Q1. Array is Sorted?
------------------------------------
Answer:
Two Pointer

TC : O(n)
SC : O(1)

=============================================================

Q2. Array is Unsorted?
------------------------------------
Answer:
HashMap
or
HashSet

=============================================================

Q3. Need INDICES?
------------------------------------
Answer:
HashMap

Stores
Value -> Index

TC : O(n)
SC : O(n)

=============================================================

Q4. Need only VALUES?
------------------------------------
Answer:
HashSet

Stores
Only Values

TC : O(n)
SC : O(n)

=============================================================

Q5. Can Two Pointer work on Unsorted Array?
------------------------------------
YES

First Sort Array
Then Apply Two Pointer

TC : O(n log n)

=============================================================

Q6. Most Asked Interview Solution?
------------------------------------
HashMap

Reason:
Returns Indices in O(n).

=============================================================

Q7. Which approach uses Extra Space?
------------------------------------
HashMap
HashSet

=============================================================

Q8. Which approach uses Minimum Space?
------------------------------------
Two Pointer
(Only if array is already sorted.)

=============================================================

Memory Trick

Indices  -> HashMap

Values   -> HashSet

Sorted   -> Two Pointer

Unsorted -> HashMap / HashSet

=============================================================
*/