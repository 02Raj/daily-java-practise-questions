# 📌 LeetCode Problem: Count Subarrays With Fixed Bounds

🔗 Problem Link: [https://leetcode.com/problems/count-subarrays-with-fixed-bounds/](https://leetcode.com/problems/count-subarrays-with-fixed-bounds/)  
🔢 Problem Number: 2444

---

## 💬 Problem Statement

Given an integer array `nums` and two integers `minK` and `maxK`, return the number of subarrays where:
- The **minimum element** is exactly `minK`
- The **maximum element** is exactly `maxK`
- All elements lie in the range `[minK, maxK]`

---

## 🧠 Approach: Variable Size Sliding Window

### ✅ Idea:
- Har index `i` pe hum ye dekhte hain ki kitne subarrays `i` pe end ho rahe hain jo valid hain (yaani minK aur maxK dono include karte hain).
- Invalid element se window ka `leftBound` set hota hai.
- Har bar jab hum `minK` ya `maxK` dekhte hain, unke last indexes ko store karte hain (`minPosition`, `maxPosition`).
- Valid subarray ka count hota hai:  
  `min(minPosition, maxPosition) - leftBound`  
  (Matlab: uss index ke baad jitne start points possible hain).

### 🧪 Dry Run:
For example:  
`nums = [1, 3, 5, 2, 7, 5], minK = 1, maxK = 5`

| i | nums[i] | minPos | maxPos | leftBound | Count | ans |
|--|---------|--------|--------|------------|--------|-----|
| 0 |   1     |   0    |  -1    |   -1       |  -     |  0  |
| 1 |   3     |   0    |  -1    |   -1       |  -     |  0  |
| 2 |   5     |   0    |   2    |   -1       |  min(0,2)-(-1)=1 | 1 |
| 3 |   2     |   0    |   2    |   -1       | 1      | 2  |
| 4 |   7     |   0    |   2    |   4 (invalid) | - | 2 |
| 5 |   5     |   0    |   5    |   4        | 0      | 2 |

👉 Total Valid Subarrays = 2

---

## 📦 Code Overview

### Important Variables:
- `leftBound`: Invalid element ka index (jo minK-maxK range me nahi hai).
- `minPosition`: Last index where `nums[i] == minK`
- `maxPosition`: Last index where `nums[i] == maxK`
- `ans`: Final result, total count of valid subarrays.

---

## 📈 Time and Space Complexity

| Type              | Complexity |
|-------------------|------------|
| ⏱️ Time Complexity | O(n) — Single pass through the array |
| 🧠 Space Complexity| O(1) — Constant extra space used |

---

## 🔁 Related Concepts

- ✅ **Variable Size Sliding Window**
    - Previous fixed window problems jaise `AnagramOccurrencesCounter` mein window size fix tha.
    - Yahaan window ka size dynamic hai, based on validity condition (minK-maxK ke beech sab element hone chahiye).

---

## ✅ Summary

- **Sliding window** ka ye ek advance form hai jahan hume window ka size dynamically adjust karna hota hai.
- Real-time index tracking (last seen min/max) aur invalid positions se hi efficient solution nikalta hai.
