# Sliding Window Technique

The **Sliding Window** technique is a commonly used algorithmic approach
to solve problems involving arrays or strings, where you need to find a
**subarray** or **substring** that satisfies certain conditions.\
It helps reduce time complexity compared to brute-force approaches.

------------------------------------------------------------------------

## 🔑 Key Idea

-   Instead of checking every possible subarray/subsequence (which takes
    O(n²)),\
    we maintain a **window (continuous segment)** and **slide** it
    through the input.
-   This avoids redundant calculations and achieves **O(n)** in many
    cases.

------------------------------------------------------------------------

## 📝 Types of Sliding Window Problems

### 1. **Fixed Size Window**

-   Window size is given or can be derived directly.
-   Common questions:
    -   Maximum sum of subarray of size K\
    -   First negative number in every window of size K\
    -   Count occurrences in every window of size K

✅ **How to identify?**\
- Question explicitly says *window of size K* OR *subarray of length
  K*.\
- The length is **fixed and known in advance**.

### 2. **Variable Size Window**

-   Window size is not fixed, it grows or shrinks dynamically based on
    conditions.\
-   Common questions:
    -   Longest substring without repeating characters\
    -   Smallest subarray with sum ≥ target\
    -   Longest substring with at most K distinct characters

✅ **How to identify?**\
- Question does NOT provide a fixed size.\
- Instead, there's a **condition** like sum, distinct characters, or
  repetition.

------------------------------------------------------------------------

## 🛠️ Steps to Solve Sliding Window Problems

### For **Fixed Size Window**

1.  Initialize two pointers (`i`, `j`) → start and end of window.
2.  Expand `j` until window size = K.
3.  Process result (sum, min, max, etc.).
4.  Slide window → remove contribution of `i`, move `i++`, and add
    `j+1`.

**Time Complexity:** O(n)\
**Space Complexity:** O(1) (or O(k) if storing elements)

------------------------------------------------------------------------

### For **Variable Size Window**

1.  Initialize two pointers (`i`, `j`).
2.  Expand `j` (right pointer) and include elements.
3.  Check condition (sum, distinct chars, etc.).
    -   If condition is satisfied → update answer.
    -   If condition is violated → shrink from left (`i++`).\
4.  Continue until `j` reaches end.

**Time Complexity:** O(n)\
**Space Complexity:** O(n) (if using HashMap/Set to track elements).

------------------------------------------------------------------------

## ⏱️ Time and Space Complexity Summary

Type            Time Complexity   Space Complexity
  --------------- ----------------- ----------------------------
Fixed Size      O(n)              O(1) or O(k)
Variable Size   O(n)              O(n) (for hash structures)

------------------------------------------------------------------------

## 📌 Example Problems

### Fixed Size Example (Maximum Sum Subarray of Size K)

``` java
public int maxSumSubarray(int[] arr, int k) {
    int i = 0, j = 0, sum = 0, maxSum = Integer.MIN_VALUE;
    while (j < arr.length) {
        sum += arr[j];
        if (j - i + 1 < k) {
            j++;
        } else if (j - i + 1 == k) {
            maxSum = Math.max(maxSum, sum);
            sum -= arr[i];
            i++;
            j++;
        }
    }
    return maxSum;
}
```

------------------------------------------------------------------------

### Variable Size Example (Longest Substring Without Repeating Characters)

``` java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int i = 0, j = 0, maxLen = 0;
    while (j < s.length()) {
        char c = s.charAt(j);
        map.put(c, map.getOrDefault(c, 0) + 1);
        while (map.get(c) > 1) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            i++;
        }
        maxLen = Math.max(maxLen, j - i + 1);
        j++;
    }
    return maxLen;
}
```

------------------------------------------------------------------------

## 🚀 Tips to Identify Sliding Window Problems

-   Subarray / Substring related.
-   Involves **contiguous elements**.
-   Condition based on sum, max/min, distinct count, or length.
-   Keywords in the problem:
    -   "longest", "smallest", "maximum", "minimum", "window of size K",
        "at most K", "sum ≥ target".

------------------------------------------------------------------------

## 🏁 Conclusion

-   **Fixed Size** → When size K is given → Simple sliding of window.\
-   **Variable Size** → When size is condition-based → Expand/Shrink
    window.\
-   Saves from brute force O(n²) → Optimized O(n).

------------------------------------------------------------------------

✅ Mastering this technique will help in many array and string problems
on LeetCode and interviews.
