package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    // ✅ Problem Statement:
    // nums1 is a subset of nums2.
    // For each element in nums1, find the next greater element in nums2.
    //
    // Example:
    // nums1 = [4,1,2]
    // nums2 = [1,3,4,2]
    // Output = [-1, 3, -1]

    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        Map<Integer,Integer> ngMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // 👉 Step 1: Traverse nums2 (reference array) from RIGHT to LEFT
        for (int i = nums2.length - 1; i >= 0; i--){
            int curr = nums2[i];

            // Pop smaller or equal elements
            while(!stack.isEmpty() && stack.peek() <= curr){
                stack.pop();
            }

            // Store next greater for current element in map
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            ngMap.put(curr,nextGreater);

            stack.push(curr);
        }

        // 👉 Step 2: For nums1, just lookup from map
        int[] result = new int[nums1.length];
        for (int i = 0 ; i < nums1.length; i++ ){
            result[i] =  ngMap.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.print("Result: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
