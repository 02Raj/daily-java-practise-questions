package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {
    // TC: O(n^2), SC: O(1)
    static int brutForce(int[] a){
        int  max = 0;
        for(int i = 0; i < a.length; ++i){
            int sum = 0;
            for(int j = i; j < a.length; ++j){
                sum += a[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    // TC: O(n), SC: O(n)
    static int usingHashMap(int[] a){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < a.length; i++){
            sum += a[i];

            // Case 1: If sum is zero, means from 0 to i sum is zero
            if(sum == 0){
                maxLen = i + 1;
            }

            // Case 2: If same sum has been seen before, subarray sum is zero
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println("brutForce aopproach: " +  brutForce(a));

        System.out.println("optimal aopproach: " +  usingHashMap(a));
    }
}
