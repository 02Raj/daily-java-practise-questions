# Most Frequently Asked DSA Questions - Up to 10 LPA

> Target: fresher and junior Java/SDE interviews at startups, service companies and MNCs in the roughly 6-10 LPA range.  
> Total: **60 questions** - Array 15, String 15, Stack 15, Linked List 15.  
> Research checked: **29 September 2026**.

## How this list was selected

This is a focused revision list, not a claim that every company asks the same questions. The problems were shortlisted by looking for repeated problems and patterns across LeetCode 75, LeetCode Top Interview 150, GeeksforGeeks' most-asked topic lists, its product-company list, and recent company-wise interview collections.

- **Priority A:** learn first; the problem or its pattern repeats across several interview sheets.
- **Priority B:** learn after Priority A; common follow-up or strong pattern coverage.
- For every problem, be able to explain the brute-force approach, the optimized approach, time complexity, space complexity, and edge cases.
- Solve in Java without looking at the answer, then test with empty, single-element, duplicate, negative and overflow-related cases where applicable.

## 1. Array - 15 questions

| Done | # | Priority | Problem | Level | Main pattern | Practice |
|---|---:|:---:|---|:---:|---|---|
| [ ] | 1 | A | Two Sum | Easy | HashMap | [LeetCode](https://leetcode.com/problems/two-sum/) |
| [ ] | 2 | A | Best Time to Buy and Sell Stock | Easy | Running minimum / greedy | [LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |
| [ ] | 3 | A | Maximum Subarray | Medium | Kadane's algorithm | [LeetCode](https://leetcode.com/problems/maximum-subarray/) |
| [ ] | 4 | A | Move Zeroes | Easy | Two pointers / in-place | [LeetCode](https://leetcode.com/problems/move-zeroes/) |
| [ ] | 5 | A | Sort Colors | Medium | Dutch National Flag | [LeetCode](https://leetcode.com/problems/sort-colors/) |
| [ ] | 6 | A | Majority Element | Easy | Boyer-Moore voting | [LeetCode](https://leetcode.com/problems/majority-element/) |
| [ ] | 7 | A | Product of Array Except Self | Medium | Prefix and suffix product | [LeetCode](https://leetcode.com/problems/product-of-array-except-self/) |
| [ ] | 8 | A | Merge Intervals | Medium | Sorting and interval merge | [LeetCode](https://leetcode.com/problems/merge-intervals/) |
| [ ] | 9 | A | 3Sum | Medium | Sorting and two pointers | [LeetCode](https://leetcode.com/problems/3sum/) |
| [ ] | 10 | A | Subarray Sum Equals K | Medium | Prefix sum and HashMap | [LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/) |
| [ ] | 11 | B | Missing Number | Easy | XOR / arithmetic | [LeetCode](https://leetcode.com/problems/missing-number/) |
| [ ] | 12 | B | Container With Most Water | Medium | Opposite-direction pointers | [LeetCode](https://leetcode.com/problems/container-with-most-water/) |
| [ ] | 13 | B | Search in Rotated Sorted Array | Medium | Modified binary search | [LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/) |
| [ ] | 14 | B | Longest Consecutive Sequence | Medium | HashSet | [LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/) |
| [ ] | 15 | B | Trapping Rain Water | Hard | Two pointers / prefix maxima | [LeetCode](https://leetcode.com/problems/trapping-rain-water/) |

### Array concepts to revise

Two pointers, sliding window, prefix sum, hashing, sorting, binary search, intervals, Kadane's algorithm and in-place modification.

## 2. String - 15 questions

| Done | # | Priority | Problem | Level | Main pattern | Practice |
|---|---:|:---:|---|:---:|---|---|
| [ ] | 1 | A | Valid Palindrome | Easy | Two pointers | [LeetCode](https://leetcode.com/problems/valid-palindrome/) |
| [ ] | 2 | A | Valid Anagram | Easy | Frequency array / HashMap | [LeetCode](https://leetcode.com/problems/valid-anagram/) |
| [ ] | 3 | A | Reverse Words in a String | Medium | Parsing and two pointers | [LeetCode](https://leetcode.com/problems/reverse-words-in-a-string/) |
| [ ] | 4 | A | Longest Common Prefix | Easy | Vertical scanning | [LeetCode](https://leetcode.com/problems/longest-common-prefix/) |
| [ ] | 5 | A | Longest Substring Without Repeating Characters | Medium | Sliding window | [LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| [ ] | 6 | A | Group Anagrams | Medium | HashMap with canonical key | [LeetCode](https://leetcode.com/problems/group-anagrams/) |
| [ ] | 7 | A | Longest Palindromic Substring | Medium | Expand around centre | [LeetCode](https://leetcode.com/problems/longest-palindromic-substring/) |
| [ ] | 8 | A | Find the Index of the First Occurrence in a String | Easy | KMP / pattern matching | [LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) |
| [ ] | 9 | A | String to Integer (atoi) | Medium | Careful parsing and overflow | [LeetCode](https://leetcode.com/problems/string-to-integer-atoi/) |
| [ ] | 10 | A | Longest Repeating Character Replacement | Medium | Sliding window and frequency | [LeetCode](https://leetcode.com/problems/longest-repeating-character-replacement/) |
| [ ] | 11 | B | First Unique Character in a String | Easy | Frequency counting | [LeetCode](https://leetcode.com/problems/first-unique-character-in-a-string/) |
| [ ] | 12 | B | Isomorphic Strings | Easy | Two-way character mapping | [LeetCode](https://leetcode.com/problems/isomorphic-strings/) |
| [ ] | 13 | B | Permutation in String | Medium | Fixed sliding window | [LeetCode](https://leetcode.com/problems/permutation-in-string/) |
| [ ] | 14 | B | Minimum Window Substring | Hard | Variable sliding window | [LeetCode](https://leetcode.com/problems/minimum-window-substring/) |
| [ ] | 15 | B | Palindromic Substrings | Medium | Expand around centre | [LeetCode](https://leetcode.com/problems/palindromic-substrings/) |

### String concepts to revise

Character frequency, Java `String` immutability, `StringBuilder`, two pointers, sliding window, hashing, palindrome expansion, parsing and KMP basics.

## 3. Stack - 15 questions

| Done | # | Priority | Problem | Level | Main pattern | Practice |
|---|---:|:---:|---|:---:|---|---|
| [ ] | 1 | A | Valid Parentheses | Easy | Matching stack | [LeetCode](https://leetcode.com/problems/valid-parentheses/) |
| [ ] | 2 | A | Min Stack | Medium | Auxiliary state in stack | [LeetCode](https://leetcode.com/problems/min-stack/) |
| [ ] | 3 | A | Implement Stack using Queues | Easy | Data-structure design | [LeetCode](https://leetcode.com/problems/implement-stack-using-queues/) |
| [ ] | 4 | A | Implement Queue using Stacks | Easy | Two-stack amortization | [LeetCode](https://leetcode.com/problems/implement-queue-using-stacks/) |
| [ ] | 5 | A | Next Greater Element I | Easy | Monotonic decreasing stack | [LeetCode](https://leetcode.com/problems/next-greater-element-i/) |
| [ ] | 6 | A | Daily Temperatures | Medium | Monotonic stack of indices | [LeetCode](https://leetcode.com/problems/daily-temperatures/) |
| [ ] | 7 | A | Online Stock Span | Medium | Monotonic stack with span | [LeetCode](https://leetcode.com/problems/online-stock-span/) |
| [ ] | 8 | A | Largest Rectangle in Histogram | Hard | Previous/next smaller element | [LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram/) |
| [ ] | 9 | A | Evaluate Reverse Polish Notation | Medium | Expression evaluation | [LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/) |
| [ ] | 10 | A | Next Greater Element II | Medium | Circular monotonic stack | [LeetCode](https://leetcode.com/problems/next-greater-element-ii/) |
| [ ] | 11 | B | Asteroid Collision | Medium | Simulation with stack | [LeetCode](https://leetcode.com/problems/asteroid-collision/) |
| [ ] | 12 | B | Decode String | Medium | Nested stack / recursion | [LeetCode](https://leetcode.com/problems/decode-string/) |
| [ ] | 13 | B | Remove K Digits | Medium | Greedy monotonic stack | [LeetCode](https://leetcode.com/problems/remove-k-digits/) |
| [ ] | 14 | B | Infix to Postfix | Medium | Operator precedence | [GeeksforGeeks](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1) |
| [ ] | 15 | B | Maximum Rectangle in Binary Matrix | Hard | Histogram plus monotonic stack | [LeetCode](https://leetcode.com/problems/maximal-rectangle/) |

### Stack concepts to revise

LIFO operations, `ArrayDeque` in Java, expression conversion/evaluation, monotonic increasing and decreasing stacks, recursion stack, and amortized complexity. Prefer `ArrayDeque` over the legacy Java `Stack` class in new code.

## 4. Linked List - 15 questions

| Done | # | Priority | Problem | Level | Main pattern | Practice |
|---|---:|:---:|---|:---:|---|---|
| [ ] | 1 | A | Reverse Linked List | Easy | Iterative pointer reversal | [LeetCode](https://leetcode.com/problems/reverse-linked-list/) |
| [ ] | 2 | A | Middle of the Linked List | Easy | Slow and fast pointers | [LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/) |
| [ ] | 3 | A | Linked List Cycle | Easy | Floyd's cycle detection | [LeetCode](https://leetcode.com/problems/linked-list-cycle/) |
| [ ] | 4 | A | Linked List Cycle II | Medium | Find cycle entry | [LeetCode](https://leetcode.com/problems/linked-list-cycle-ii/) |
| [ ] | 5 | A | Merge Two Sorted Lists | Easy | Dummy node and two pointers | [LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/) |
| [ ] | 6 | A | Remove Nth Node From End of List | Medium | Fixed-gap two pointers | [LeetCode](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) |
| [ ] | 7 | A | Intersection of Two Linked Lists | Easy | Pointer switching | [LeetCode](https://leetcode.com/problems/intersection-of-two-linked-lists/) |
| [ ] | 8 | A | Palindrome Linked List | Easy | Middle, reverse and compare | [LeetCode](https://leetcode.com/problems/palindrome-linked-list/) |
| [ ] | 9 | A | Add Two Numbers | Medium | Carry and dummy node | [LeetCode](https://leetcode.com/problems/add-two-numbers/) |
| [ ] | 10 | A | Sort List | Medium | Merge sort on linked list | [LeetCode](https://leetcode.com/problems/sort-list/) |
| [ ] | 11 | B | Odd Even Linked List | Medium | Stable pointer partition | [LeetCode](https://leetcode.com/problems/odd-even-linked-list/) |
| [ ] | 12 | B | Reverse Nodes in k-Group | Hard | Segment reversal | [LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group/) |
| [ ] | 13 | B | Copy List with Random Pointer | Medium | Node mapping / interweaving | [LeetCode](https://leetcode.com/problems/copy-list-with-random-pointer/) |
| [ ] | 14 | B | Merge k Sorted Lists | Hard | Heap / divide and conquer | [LeetCode](https://leetcode.com/problems/merge-k-sorted-lists/) |
| [ ] | 15 | B | LRU Cache | Medium | HashMap plus doubly linked list | [LeetCode](https://leetcode.com/problems/lru-cache/) |

### Linked List concepts to revise

Dummy nodes, pointer rewiring, slow/fast pointers, reversing a full list or a segment, merge sort, singly versus doubly linked lists, and combining a HashMap with a doubly linked list.

## Recommended practice order

1. Finish all **Priority A** questions topic by topic.
2. Re-solve each Priority A question after 2 days without notes.
3. Finish **Priority B** questions and note the pattern, not just the code.
4. Do four timed sets. Each set should contain one Array, one String, one Stack and one Linked List problem in 90 minutes.
5. In the final week, revise Java templates and explain solutions aloud as if an interviewer is listening.

## Interview-ready checklist

For a problem to count as completed, verify all of these:

- [ ] I can identify the pattern without seeing the topic name.
- [ ] I can first explain a simple/brute-force solution.
- [ ] I can code the optimized Java solution from scratch.
- [ ] I can state time and space complexity correctly.
- [ ] I can dry-run the solution on edge cases.
- [ ] I can answer one follow-up, such as doing it in-place or with less memory.

## Research sources

- [LeetCode 75 - essential and trending interview problems](https://leetcode.com/studyplan/leetcode-75/)
- [LeetCode Top Interview 150](https://leetcode.com/studyplan/top-interview-150/)
- [GeeksforGeeks - Top 100 DSA interview questions by topic](https://www.geeksforgeeks.org/dsa/top-100-data-structure-and-algorithms-dsa-interview-questions-topic-wise/)
- [GeeksforGeeks - Most asked 75 coding problems](https://www.geeksforgeeks.org/blogs/most-asked-75-coding-problems/)
- [GeeksforGeeks - Must-do coding questions for product companies](https://www.geeksforgeeks.org/dsa/must-do-coding-questions-for-product-based-companies/)
- [GeeksforGeeks - Recently asked product-company questions](https://www.geeksforgeeks.org/dsa/recently-asked-interview-questions-in-product-based-companies/)
- [GeeksforGeeks - Beginner most-asked DSA sheet](https://www.geeksforgeeks.org/dsa/most-asked-dsa-interview-problems-for-beginners/)
- [GeeksforGeeks - Recent company-wise interview problems](https://www.geeksforgeeks.org/blogs/top-interview-problems-asked-in-2024/)
- [GeeksforGeeks - Stack interview questions](https://www.geeksforgeeks.org/dsa/commonly-asked-data-structure-interview-questions-on-stack/)
- [GeeksforGeeks - Linked List interview questions](https://www.geeksforgeeks.org/dsa/top-50-linked-list-interview-question/)

> Salary bands and interview difficulty vary by company, role, location and experience. Completing this list gives strong coverage of common Easy-Medium patterns, but selection also depends on Java fundamentals, OOP, DBMS, OS, SQL, projects and communication.
