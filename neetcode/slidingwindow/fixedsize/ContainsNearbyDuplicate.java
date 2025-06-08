package neetcode.slidingwindow.fixedsize;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Approaches:
 * 1. HashMap Approach (store last index of each number)
 * 2. Sliding Window using Set (window of size k)
 */
public class ContainsNearbyDuplicate {

    // 1️⃣ HashMap Approach
    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            map.put(nums[i], i); // update last seen index
        }

        return false;
    }

    // 2️⃣ Sliding Window Approach using Set
    public boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        int left = 0, right = 0;
        int n = nums.length;

        while (right < n) {

            // Duplicate found in current window
            if (window.contains(nums[right])) {
                return true;
            }

            // Add current element to window
            window.add(nums[right]);

            // Maintain window size ≤ k
            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }

            right++;
        }

        return false;
    }
}

