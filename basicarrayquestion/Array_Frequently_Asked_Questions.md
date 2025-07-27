Most Important Array Questions for Technical Interviews
These array-related questions are frequently asked in technical interviews. Mastering them will significantly increase your chances of success.

Core Operations & Manipulations
Two Sum

Problem: Given an array of integers and a target sum, find two numbers in the array that add up to the target.

Key Idea: Use a hash map to store seen numbers and their indices for O(N) average time complexity, or sort the array and use a two-pointer approach (if returning indices is not strictly required, or if the array can be modified).

Example: nums = [2, 7, 11, 15], target = 9 -> [0, 1]

Remove Duplicates from Sorted Array (In-place)

Problem: Given a sorted array, remove duplicates such that each element appears only once and return the new length. The operation must be in-place.

Key Idea: Use a two-pointer approach (one for reading, one for writing) to modify the array in-place efficiently.

Example: [1,1,2] -> [1,2] (new length 2)

Merge Sorted Arrays

Problem: Given two sorted arrays, merge them into a single sorted array.

Key Idea: Use a two-pointer approach, comparing elements from both arrays and placing them into a new array. For in-place merging (e.g., merging into the end of one of the arrays if it has enough space), start comparing from the end.

Example: [1,2,3], [2,5,6] -> [1,2,2,3,5,6]

Rotate Array

Problem: Rotate an array to the right or left by a given number of steps.

Key Idea: Can be done using a temporary array, or by performing three reversals of segments of the array for an O(N) time and O(1) space solution.

Example: [1,2,3,4,5,6,7] rotated by 3 steps to the right -> [5,6,7,1,2,3,4]

Move Zeroes

Problem: Given an array, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Key Idea: Use a two-pointer approach: one pointer to track the position for the next non-zero element, and another to iterate through the array.

Searching & Sorting Related
Maximum Subarray Sum (Kadane's Algorithm)

Problem: Find the contiguous subarray within a one-dimensional array of numbers that has the largest sum.

Key Idea: Use Dynamic Programming (Kadane's Algorithm) by tracking the current maximum sum ending at the current position and the overall global maximum sum.

Example: [-2,1,-3,4,-1,2,1,-5,4] -> 6 (from [4,-1,2,1])

Find Missing Number

Problem: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing.

Key Idea: Use the summation formula (expected sum minus actual sum) or the XOR operation to find the missing number.

Example: [3,0,1] -> 2

Search in Rotated Sorted Array

Problem: Search for a target value in a sorted array that has been rotated at some pivot.

Key Idea: Apply a modified binary search to handle the rotation.

Container With Most Water

Problem: Find two lines that, together with the x-axis, form a container that contains the most water.

Key Idea: Employ a two-pointer approach, moving the pointer of the shorter line inwards to explore larger areas.

Example: [1,8,6,2,5,4,8,3,7] -> 49

Product of Array Except Self

Problem: Given an array nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Key Idea: Calculate prefix products and suffix products by making two passes (left-to-right and right-to-left) through the array.

Example: [1,2,3,4] -> [24,12,8,6]

Advanced Array Patterns & Concepts
3Sum / 4Sum

Problem: Find all unique triplets/quadruplets in the array which give the sum of zero/target.

Key Idea: Sort the array, then use a two-pointer approach nested within a loop. Handle duplicates carefully.

Best Time to Buy and Sell Stock (I, II, III, IV)

Problem: Find the maximum profit you can achieve by buying and selling a stock. (Variations include allowing multiple transactions, k transactions, etc.)

Key Idea: Different approaches for variations: simple iteration for I, greedy for II, dynamic programming for III and IV.

Find Duplicate in an Array (Various Constraints)

Problem: Find one or all duplicate elements in an array, often with constraints on space or modification (e.g., numbers from 1 to N, exactly one duplicate).

Key Idea: Hash set, modifying the array itself (e.g., marking visited), Floyd's Cycle Finding Algorithm (for specific constraints like 'numbers from 1 to N with exactly one duplicate').

Subarray Sum Equals K

Problem: Given an array of integers and an integer k, return the total number of contiguous subarrays whose sum equals k.

Key Idea: Use prefix sums with a hash map to store frequencies of prefix sums encountered.

Largest Rectangle in Histogram

Problem: Find the area of the largest rectangle in a histogram.

Key Idea: Use a stack to keep track of increasing heights and calculate areas when heights decrease.

Set Matrix Zeroes

Problem: Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.

Key Idea: Use dummy arrays (or the first row/column of the matrix itself to save space) to mark which rows/columns need to be zeroed out.

Spiral Matrix

Problem: Given an m x n matrix, return all elements of the matrix in spiral order.

Key Idea: Simulate the path, keeping track of boundaries (top, bottom, left, right) and shrinking them inwards.

Jump Game (I & II)

Problem: Determine if you can reach the last index (I), or find the minimum number of jumps to reach the last index (II).

Key Idea: Greedy approach for both, tracking reachable index (I) or current/next farthest reach (II).

Sort Colors (Dutch National Flag problem)

Problem: Given an array nums with n objects colored red, white, or blue (represented by 0, 1, and 2), sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Key Idea: Three-pointer approach (low, mid, high) to partition the array in one pass.

