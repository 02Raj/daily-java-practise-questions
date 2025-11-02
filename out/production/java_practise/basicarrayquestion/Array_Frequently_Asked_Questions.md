# Most Important Array Questions for Technical Interviews

These array-related questions are frequently asked in technical interviews. Mastering them will significantly increase your chances of success.

---

## 📌 Core Operations & Manipulations

### 🔹 Two Sum
**Problem:** Given an array of integers and a target sum, find two numbers in the array that add up to the target.  
**Key Idea:** Use a hash map for O(N) time or sort & use two pointers.  
**Example:** `nums = [2, 7, 11, 15], target = 9` → `[0, 1]`

---

### 🔹 Remove Duplicates from Sorted Array (In-place)
**Problem:** Remove duplicates so each element appears only once and return the new length.  
**Key Idea:** Two-pointer approach (read/write).  
**Example:** `[1,1,2]` → `[1,2]` (new length = 2)

---

### 🔹 Merge Sorted Arrays
**Problem:** Merge two sorted arrays into a single sorted array.  
**Key Idea:** Two-pointer method; reverse merge for in-place.  
**Example:** `[1,2,3]`, `[2,5,6]` → `[1,2,2,3,5,6]`

---

### 🔹 Rotate Array
**Problem:** Rotate an array to the right/left by a number of steps.  
**Key Idea:** Use three reversals for O(N) time, O(1) space.  
**Example:** `[1,2,3,4,5,6,7]` rotated right by 3 → `[5,6,7,1,2,3,4]`

---

### 🔹 Move Zeroes
**Problem:** Move all 0's to the end, maintaining relative order.  
**Key Idea:** Two-pointer approach to place non-zero values first.

---

## 🔍 Searching & Sorting Related

### 🔹 Maximum Subarray Sum (Kadane's Algorithm)
**Problem:** Find the contiguous subarray with the largest sum.  
**Key Idea:** Use Kadane's Algorithm (DP).  
**Example:** `[-2,1,-3,4,-1,2,1,-5,4]` → `6` (from `[4,-1,2,1]`)

---

### 🔹 Find Missing Number
**Problem:** From numbers 0 to n, find the one missing number.  
**Key Idea:** Use sum formula or XOR.  
**Example:** `[3,0,1]` → `2`

---

### 🔹 Search in Rotated Sorted Array
**Problem:** Search target in a rotated sorted array.  
**Key Idea:** Modified binary search.

---

### 🔹 Container With Most Water
**Problem:** Find two lines forming the max water container.  
**Key Idea:** Two-pointer approach.  
**Example:** `[1,8,6,2,5,4,8,3,7]` → `49`

---

### 🔹 Product of Array Except Self
**Problem:** Return array where `output[i] = product of all nums except nums[i]`.  
**Key Idea:** Prefix and suffix products.  
**Example:** `[1,2,3,4]` → `[24,12,8,6]`

---

## 💡 Advanced Array Patterns & Concepts

### 🔹 3Sum / 4Sum
**Problem:** Find all unique triplets/quadruplets that sum to zero/target.  
**Key Idea:** Sort + two-pointer inside loop. Handle duplicates carefully.

---

### 🔹 Best Time to Buy and Sell Stock (I, II, III, IV)
**Problem:** Max profit from buying/selling stock (varies by version).  
**Key Idea:**
- I: Simple iteration
- II: Greedy
- III & IV: Dynamic Programming

---

### 🔹 Find Duplicate in an Array
**Problem:** Find duplicates with constraints.  
**Key Idea:** Use HashSet, modify array, or Floyd’s Cycle Detection.

---

### 🔹 Subarray Sum Equals K
**Problem:** Count subarrays whose sum = k.  
**Key Idea:** Prefix sums with hashmap.

---

### 🔹 Largest Rectangle in Histogram
**Problem:** Max rectangle area in histogram.  
**Key Idea:** Use stack to manage increasing heights.

---

### 🔹 Set Matrix Zeroes
**Problem:** If an element is 0, set its row and column to 0.  
**Key Idea:** Use markers (first row/col) to track zeroes.

---

### 🔹 Spiral Matrix
**Problem:** Return all elements in spiral order.  
**Key Idea:** Simulate spiral by tracking and shrinking boundaries.

---

### 🔹 Jump Game I & II
**Problem:**
- I: Can you reach the last index?
- II: Min jumps to last index.  
  **Key Idea:** Greedy approach.

---

### 🔹 Sort Colors (Dutch National Flag)
**Problem:** Sort array of 0s, 1s, 2s.  
**Key Idea:** Three-pointer (low, mid, high) partitioning.

---
