package basicarrayquestion;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXorK {

    static int subarraysWithXorK(int[] arr, int k) {
        int prefixXor = 0;
        int count = 0;
        Map<Integer, Integer> xorMap = new HashMap<>();
        xorMap.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixXor = prefixXor ^ arr[i];

            int required = prefixXor ^ k;

            if (xorMap.containsKey(required)) {
                count += xorMap.get(required);
            }

            // Update the prefixXor map
//            xorMap.put(prefixXor, xorMap.getOrDefault(prefixXor, 0) + 1);
            if (xorMap.get(prefixXor) == null) {
                xorMap.put(prefixXor, 1);
            } else {
                xorMap.put(prefixXor, xorMap.get(prefixXor) + 1);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}
