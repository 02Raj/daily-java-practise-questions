# 🎯 DSA Roadmap — 8-10 LPA Interview Crack Karne Ka Complete Plan

> **Target:** Product-based / Service-based company mein 8-10 LPA ki job  
> **Timeline:** 3-4 months (consistent effort ke saath)  
> **Mantra:** Quality > Quantity. 150 sahi problems > 500 random problems.

---

## 📌 Pehle Samjho — 8-10 LPA ke liye kya chahiye?

| Company Type | Examples | DSA Level | Total Problems |
|---|---|---|---|
| Service-based (top tier) | TCS Digital, Infosys SP, Wipro Elite | Easy–Medium | ~100 |
| Product-based (mid) | Zoho, Moengage, Chargebee, Freshworks | Medium | ~150 |
| Product-based (good) | Walmart, Samsung, DE Shaw, Atlassian | Medium–Hard | ~200 |

**8-10 LPA ke liye mostly Medium level problems aate hain.**  
Hard problems optional hain — bonus hai agar aate hain.

---

## 🗺️ Overall Roadmap — 4 Phases

```
Phase 1 (Week 1-3)   → Foundation: Array, String, Two Pointer, Sliding Window
Phase 2 (Week 4-6)   → Core DS: Hashing, Linked List, Stack, Queue
Phase 3 (Week 7-10)  → Trees + Searching: Binary Search, Binary Tree, BST
Phase 4 (Week 11-14) → Advanced: Graphs, DP, Greedy + Mock Interviews
```

---

## ✅ PHASE 1 — Foundation (Week 1–3)

### 1️⃣ Array
**Kyun important hai?** — Har interview mein array hota hai. 90% problems arrays use karti hain.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Find max/min in array | Easy | ✅ |
| 2 | Reverse an array | Easy | ✅ |
| 3 | Find duplicate element | Easy | ✅ |
| 4 | Kadane's Algorithm (Max Subarray Sum) | Medium | ✅✅ |
| 5 | Best Time to Buy and Sell Stock | Medium | ✅✅ |
| 6 | Rotate Image (90° clockwise) | Medium | ✅✅ |
| 7 | Set Matrix Zeroes | Medium | ✅✅ |
| 8 | Pascal's Triangle | Easy–Medium | ✅ |
| 9 | Next Permutation | Medium | ✅✅ |
| 10 | Sort Colors (Dutch National Flag) | Medium | ✅✅ |
| 11 | Merge Intervals | Medium | ✅✅ |
| 12 | Find Missing Number | Easy | ✅ |
| 13 | Majority Element (Boyer-Moore) | Medium | ✅✅ |

**Completion target:** 13/13 problems — 4-5 din mein

---

### 2️⃣ String
**Kyun important hai?** — Coding rounds mein string problems bohot common hain.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Reverse a String | Easy | ✅ |
| 2 | Check Palindrome | Easy | ✅ |
| 3 | Valid Anagram | Easy | ✅ |
| 4 | Longest Common Prefix | Easy | ✅ |
| 5 | Roman to Integer | Easy–Medium | ✅ |
| 6 | Count and Say | Medium | ✅ |
| 7 | Longest Palindromic Substring | Medium | ✅✅ |
| 8 | String to Integer (atoi) | Medium | ✅✅ |
| 9 | Valid Parentheses | Easy | ✅ |
| 10 | Group Anagrams | Medium | ✅✅ |

**Completion target:** 10/10 problems — 3-4 din mein

---

### 3️⃣ Two Pointer
**Kyun important hai?** — O(n²) ko O(n) mein convert karta hai — interviewer impress hota hai.

**Core Idea:** Do pointers simultaneously chalao — left aur right se — ya slow/fast.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Two Sum (sorted array) | Easy | ✅ |
| 2 | 3Sum | Medium | ✅✅ |
| 3 | Container With Most Water | Medium | ✅✅ |
| 4 | Remove Duplicates from Sorted Array | Easy | ✅ |
| 5 | Move Zeroes | Easy | ✅ |
| 6 | Trapping Rain Water | Hard | ✅ (must understand concept) |
| 7 | 4Sum | Medium | ✅✅ |
| 8 | Palindrome Check (two pointer) | Easy | ✅ |

**Pattern yaad rakho:**
```
left = 0, right = n-1
while (left < right) {
    if (condition met) → return/save answer
    else if (sum too small) → left++
    else → right--
}
```

---

### 4️⃣ Sliding Window
**Kyun important hai?** — Subarray/substring problems mein O(n²) → O(n) karta hai.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Maximum Sum Subarray of size K | Easy | ✅ |
| 2 | Longest Substring Without Repeating Characters | Medium | ✅✅ |
| 3 | Minimum Window Substring | Hard | ✅ (concept samjho) |
| 4 | Fruit Into Baskets | Medium | ✅✅ |
| 5 | Longest Repeating Character Replacement | Medium | ✅✅ |
| 6 | Permutation in String | Medium | ✅✅ |

**Pattern yaad rakho:**
```
window expand karo → right pointer badhao
condition violate ho → left pointer se window chota karo
```

---

## ✅ PHASE 2 — Core Data Structures (Week 4–6)

### 5️⃣ Hashing (HashMap / HashSet)
**Kyun important hai?** — O(n) solution ki chabi hai hashing.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Two Sum | Easy | ✅✅ |
| 2 | Subarray with zero sum | Medium | ✅✅ |
| 3 | Longest Consecutive Sequence | Medium | ✅✅ |
| 4 | Count distinct elements in window | Medium | ✅ |
| 5 | Subarray Sum Equals K | Medium | ✅✅ |
| 6 | Top K Frequent Elements | Medium | ✅✅ |

---

### 6️⃣ Linked List
**Kyun important hai?** — Pointer manipulation — direct coding skill test.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Reverse a Linked List | Easy | ✅✅ |
| 2 | Detect Cycle (Floyd's Algorithm) | Medium | ✅✅ |
| 3 | Find Middle of Linked List | Easy | ✅ |
| 4 | Merge Two Sorted Lists | Easy–Medium | ✅✅ |
| 5 | Remove Nth Node from End | Medium | ✅✅ |
| 6 | Add Two Numbers | Medium | ✅✅ |
| 7 | Intersection of Two Linked Lists | Easy–Medium | ✅ |
| 8 | Copy List with Random Pointer | Hard | ✅ |
| 9 | LRU Cache | Hard | ✅✅ (bohot common!) |

---

### 7️⃣ Stack & Queue
**Kyun important hai?** — OS concepts + coding problems dono mein aata hai.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Implement Stack using Queue | Easy | ✅ |
| 2 | Valid Parentheses | Easy | ✅✅ |
| 3 | Next Greater Element | Medium | ✅✅ |
| 4 | Min Stack | Medium | ✅✅ |
| 5 | Largest Rectangle in Histogram | Hard | ✅ |
| 6 | Daily Temperatures | Medium | ✅✅ |
| 7 | Sliding Window Maximum (Deque) | Hard | ✅ |

---

## ✅ PHASE 3 — Trees + Searching (Week 7–10)

### 8️⃣ Binary Search
**Kyun important hai?** — O(log n) solution — interviewer ki aankhon mein chamak aati hai.

**Golden Rule:** Jab bhi sorted array dikhe ya "find minimum/maximum satisfying condition" — Binary Search sochho.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Binary Search (basic) | Easy | ✅✅ |
| 2 | Search in Rotated Sorted Array | Medium | ✅✅ |
| 3 | Find First and Last Position | Medium | ✅✅ |
| 4 | Search a 2D Matrix | Medium | ✅✅ |
| 5 | Find Peak Element | Medium | ✅✅ |
| 6 | Kth Smallest Element in BST | Medium | ✅✅ |
| 7 | Median of Two Sorted Arrays | Hard | ✅ |
| 8 | Capacity to Ship Packages in D Days | Medium | ✅✅ |
| 9 | Aggressive Cows (GFG) | Medium | ✅✅ |
| 10 | Allocate Minimum Pages | Medium | ✅✅ |

---

### 9️⃣ Binary Tree
**Kyun important hai?** — Tree problems = recursion ki mastery dikhao.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Inorder / Preorder / Postorder Traversal | Easy | ✅✅ |
| 2 | Level Order Traversal (BFS) | Medium | ✅✅ |
| 3 | Height of Binary Tree | Easy | ✅✅ |
| 4 | Diameter of Binary Tree | Medium | ✅✅ |
| 5 | Check Balanced Binary Tree | Medium | ✅✅ |
| 6 | Lowest Common Ancestor | Medium | ✅✅ |
| 7 | Binary Tree Right Side View | Medium | ✅✅ |
| 8 | Zigzag Level Order Traversal | Medium | ✅ |
| 9 | Serialize and Deserialize Binary Tree | Hard | ✅ |
| 10 | Maximum Path Sum | Hard | ✅ |

---

### 🔟 Binary Search Tree (BST)

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Search in BST | Easy | ✅ |
| 2 | Insert into BST | Easy–Medium | ✅ |
| 3 | Delete Node in BST | Medium | ✅✅ |
| 4 | Validate BST | Medium | ✅✅ |
| 5 | Inorder Successor in BST | Medium | ✅✅ |
| 6 | Two Sum in BST | Medium | ✅ |

---

## ✅ PHASE 4 — Advanced Topics (Week 11–14)

### 1️⃣1️⃣ Graphs
**Kyun important hai?** — Graphs mein problem-solving depth dikhti hai.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | BFS of Graph | Easy | ✅✅ |
| 2 | DFS of Graph | Easy | ✅✅ |
| 3 | Detect Cycle in Undirected Graph | Medium | ✅✅ |
| 4 | Detect Cycle in Directed Graph | Medium | ✅✅ |
| 5 | Topological Sort (BFS + DFS) | Medium | ✅✅ |
| 6 | Number of Islands | Medium | ✅✅ |
| 7 | Flood Fill | Easy–Medium | ✅ |
| 8 | Shortest Path (Dijkstra) | Medium | ✅✅ |
| 9 | Course Schedule | Medium | ✅✅ |
| 10 | Clone Graph | Medium | ✅ |

---

### 1️⃣2️⃣ Dynamic Programming (DP)
**Kyun important hai?** — DP = highest ROI topic. Ek baar pattern samjh gaya toh bahut problems solve ho jaati hain.

**DP ke 5 Core Patterns:**

| Pattern | Representative Problem |
|---|---|
| 1D DP | Climbing Stairs, House Robber |
| Grid DP | Unique Paths, Min Path Sum |
| Subsequence DP | LCS, LIS, Edit Distance |
| Partition DP | 0/1 Knapsack, Subset Sum |
| String DP | Palindrome Partitioning |

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Climbing Stairs | Easy | ✅✅ |
| 2 | House Robber I & II | Medium | ✅✅ |
| 3 | Unique Paths | Medium | ✅✅ |
| 4 | Longest Common Subsequence (LCS) | Medium | ✅✅ |
| 5 | Longest Increasing Subsequence (LIS) | Medium | ✅✅ |
| 6 | 0/1 Knapsack | Medium | ✅✅ |
| 7 | Coin Change | Medium | ✅✅ |
| 8 | Edit Distance | Hard | ✅ |
| 9 | Partition Equal Subset Sum | Medium | ✅✅ |
| 10 | Word Break | Medium | ✅✅ |

---

### 1️⃣3️⃣ Greedy
**Kyun important hai?** — Simple logic, high reward.

| # | Problem | Difficulty | Must Do? |
|---|---|---|---|
| 1 | Activity Selection | Medium | ✅✅ |
| 2 | Jump Game I & II | Medium | ✅✅ |
| 3 | Gas Station | Medium | ✅✅ |
| 4 | Assign Cookies | Easy | ✅ |
| 5 | Minimum Platforms (GFG) | Medium | ✅✅ |

---

## 📊 Complete Checklist — Topic-wise Mark Karo

```
PHASE 1 — Foundation
[ ] Array          (13 problems)   Status: ___/13
[ ] String         (10 problems)   Status: ___/10
[ ] Two Pointer    (8 problems)    Status: ___/8
[ ] Sliding Window (6 problems)    Status: ___/6

PHASE 2 — Core DS
[ ] Hashing        (6 problems)    Status: ___/6
[ ] Linked List    (9 problems)    Status: ___/9
[ ] Stack & Queue  (7 problems)    Status: ___/7

PHASE 3 — Trees + Search
[ ] Binary Search  (10 problems)   Status: ___/10
[ ] Binary Tree    (10 problems)   Status: ___/10
[ ] BST            (6 problems)    Status: ___/6

PHASE 4 — Advanced
[ ] Graphs         (10 problems)   Status: ___/10
[ ] DP             (10 problems)   Status: ___/10
[ ] Greedy         (5 problems)    Status: ___/5

━━━━━━━━━━━━━━━━━━━━━━━━━━━
TOTAL TARGET: 110 problems
COMPLETED:    ___/110
```

---

## 🔥 Daily Schedule (Recommended)

```
Monday    → New topic + 2-3 new problems
Tuesday   → 2-3 new problems + 1 revision
Wednesday → New topic + 2-3 new problems
Thursday  → Pure revision (revisit weak topics)
Friday    → 3-4 problems (mixed topics)
Saturday  → Mock interview (LeetCode contest / Timed session)
Sunday    → Rest OR light revision / system design basics
```

**Daily minimum:** 1 problem solve karo — even on busy days.

---

## 💡 Problem Solve Karne Ka Sahi Tarika

```
Step 1 → Problem padho (5 min)
         Example manually trace karo
         
Step 2 → Brute force sochho pehle (2 min)
         TC/SC note karo
         
Step 3 → Optimize karo (10-15 min)
         Koi pattern match hota hai?
         (Two pointer? Hashing? Binary Search?)
         
Step 4 → Code likho (15-20 min)
         Edge cases sochho: empty, single element, all same

Step 5 → Dry run karo (5 min)
         Example pe manually test karo

Step 6 → Submit → Fail → Debug (without seeing solution)

Step 7 → Agar 30+ min ke baad bhi na aaye:
         Solution dekho, SAMJHO, next day BINA DEKHE dobara likho
```

---

## 🚫 Common Mistakes — Mat Karna

1. **Solution copy-paste mat karo** — samjhe bina koi fayda nahi
2. **Ek hi topic par stuck mat raho** — 2-3 din deke aage badho
3. **Sirf easy problems mat karo** — medium problems interview mein aate hain
4. **Random problems mat karo** — topic-wise systematic approach rakho
5. **Notes mat bhulo** — har problem pe TC/SC likho (teri Kadane wali style perfect hai!)
6. **Mock interview skip mat karo** — speed aur confidence dono zaroori hain

---

## 📚 Resources

| Resource | Kisliye |
|---|---|
| **LeetCode** | Primary platform — sab problems yahan solve karo |
| **Striver's SDE Sheet** | Toh tu already follow kar raha hai — perfect! |
| **TakeUForward (YouTube)** | Concept videos — agar stuck ho |
| **GFG** | Kuch Indian company specific problems |
| **NeetCode.io** | Patterns samjhne ke liye — roadmap ache se explain hai |

---

## 🎯 Interview Week Mein Kya Karo

```
Day -7  → Revision: Array, String, Two Pointer
Day -6  → Revision: Binary Search, Hashing
Day -5  → Revision: Linked List, Stack
Day -4  → Revision: Trees (Binary Tree + BST)
Day -3  → Revision: Graphs, DP top patterns
Day -2  → 1 Mock Interview + weak spots fix karo
Day -1  → Halka revision — zyada stress mat lo
Day 0   → Confident raho. Tu prepare hai. ✊
```

---

## ✊ Ek Baat Yaad Rakho

> *"8-10 LPA ek realistic target hai agar tu 100-150 problems sahi se solve kare.  
> Random 500 problems se better hai — 150 focused, understood, re-done problems."*

**Teri preparation already sahi direction mein hai** — documented notes, dry runs, revision checklists — yeh sab matter karta hai.

Bas consistent reh. **3-4 mahine. Ek step ek din.** 🚀

---

*Last updated: April 2025 | Target: 8-10 LPA Product/Service Companies*