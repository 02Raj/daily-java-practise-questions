# Two Pointer Technique

The **Two Pointer Technique** is one of the most important DSA patterns for arrays, strings, and linked lists.
It helps you solve problems in **linear time** by using two indices/pointers instead of checking every possible pair.

> Short idea: **do pointers ko smartly move karo** so that each step gives useful information and avoids repeated work.

---

## 🎯 Why Two Pointer Matters

Brute-force solutions often check all pairs, subarrays, or states.
That usually costs **O(n²)** or worse.
Two pointers can reduce that to **O(n)** in many cases, especially when:

- the data is **sorted**
- the problem is about **pairs**, **palindromes**, **partitioning**, or **in-place rearrangement**
- you only need to scan the collection once or twice

---

## ✅ When to Think About Two Pointers

Use this pattern when the problem has one or more of these clues:

- **sorted array**
- **pair / triplet / quadruplet**
- **left-right comparison**
- **remove / move / partition** in-place
- **palindrome / reverse**
- **merge two sorted lists/arrays**
- **fast and slow movement** in linked list / cycle detection

### Keyword hints

If the question says:

- "find pair with given sum"
- "remove duplicates"
- "move zeros"
- "container with most water"
- "palindrome"
- "merge sorted arrays"
- "3Sum / 4Sum"
- "detect cycle"

then two pointers is very likely involved.

---

## 🧠 Core Thinking Pattern

Two-pointer problems usually follow this mental flow:

1. **Identify the invariant**
   - What stays true after every move?
   - Example: in a sorted array, if sum is too small, moving left pointer right can only increase the sum.

2. **Choose pointer roles**
   - left/right from both ends
   - slow/fast in same direction
   - read/write for in-place updates
   - first/second pointer for comparison or merging

3. **Move the correct pointer**
   - based on condition
   - never move randomly
   - every move must bring you closer to the answer

4. **Stop when pointers cross or condition is met**

---

## 🔍 Types of Two Pointer Problems

### 1) Opposite-End Pointers

Pointers start from both ends:

```java
int left = 0, right = n - 1;
while (left < right) {
    // check condition
    // move left or right depending on result
}
```

#### Used for:
- Two Sum in sorted array
- Container With Most Water
- Trapping Rain Water
- Palindrome check
- Reverse array/string

#### Key intuition

- If the array is sorted and sum is too small, move `left++`
- If the sum is too large, move `right--`
- For palindrome, compare and shrink from both ends

---

### 2) Same-Direction Pointers

Both pointers move from left to right.

```java
int slow = 0;
for (int fast = 0; fast < n; fast++) {
    // fast explores
    // slow stores valid result
}
```

#### Used for:
- remove duplicates from sorted array
- move zeroes
- partitioning arrays
- copying/filtering valid elements

#### Key intuition

- `fast` scans everything
- `slow` marks where the next valid element should go
- usually an **in-place** pattern

---

### 3) Fast and Slow Pointers

Mostly used in linked list problems.

```java
ListNode slow = head;
ListNode fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

#### Used for:
- cycle detection
- middle of linked list
- palindrome linked list
- finding intersection patterns

#### Key intuition

- `fast` moves 2 steps
- `slow` moves 1 step
- if they meet, a cycle usually exists

---

### 4) Read/Write Pointers

A practical form of same-direction pointers.

- `read` scans elements
- `write` stores filtered elements

#### Used for:
- remove duplicates
- compress array
- move all non-zero values forward
- keep only valid characters/items

---

### 5) Merge Pointers

Used when combining two sorted sequences.

```java
int i = 0, j = 0;
while (i < a.length && j < b.length) {
    // compare a[i] and b[j]
}
```

#### Used for:
- merge sorted arrays
- merge sorted linked lists
- union/intersection of sorted lists

---

### 6) K-Sum Family

This is an advanced extension of two pointers.

- `2Sum` → base pattern
- `3Sum` → fix one number, then apply two pointers
- `4Sum` → fix two numbers, then apply two pointers

#### Key rule

- sort first
- handle duplicates carefully
- use two pointers inside an outer loop

---

## 📊 Time Complexity and Space Complexity

| Pattern | Time Complexity | Space Complexity |
|---|---:|---:|
| Opposite-end scan | O(n) | O(1) |
| Same-direction scan | O(n) | O(1) |
| Read/write in-place | O(n) | O(1) |
| Fast/slow pointers | O(n) | O(1) |
| Merge two sorted lists | O(n + m) | O(1) |
| 3Sum / 4Sum with sorting | O(n²) / O(n³) depending on pattern | O(1) or O(log n) if sorting recursion is counted |

### Important note

Two pointer is not always O(n) end-to-end.
If sorting is required first, then overall complexity may become **O(n log n)**.

Example:
- Sort array: `O(n log n)`
- Two-pointer scan: `O(n)`
- Total: `O(n log n)`

---

## 🧩 Two Pointer vs Sliding Window

These two are related, but not the same.

| Aspect | Two Pointer | Sliding Window |
|---|---|---|
| Goal | Compare / move / merge / partition | Process continuous subarray/substring |
| Pointer movement | Depends on condition | Expand right, shrink left |
| Common use | pairs, palindromes, in-place changes | subarray sum, longest/shortest substring |
| Data requirement | often sorted or structural | contiguous segment |

### Simple rule

- If the problem says **pair, compare, merge, palindrome** → think **Two Pointer**
- If the problem says **subarray/substring/window** → think **Sliding Window**

---

## 🛠️ How to Recognize a Two Pointer Question

Ask yourself these questions:

1. **Can I solve this by comparing two positions at once?**
2. **Does moving one pointer give a meaningful monotonic change?**
3. **Is the array sorted or can it be sorted without breaking the logic?**
4. **Is the problem about in-place transformation?**
5. **Do I only need one pass or two passes?**

If the answer is "yes" to any of these, two pointers may be the right approach.

### Recognition cheat sheet

- **Sorted array + pair sum** → opposite ends
- **Duplicate removal** → read/write
- **Move zeroes** → read/write
- **Palindrome** → opposite ends
- **Middle of linked list** → fast/slow
- **3Sum / 4Sum** → sort + fix one/two + two pointers
- **Container With Most Water** → opposite ends with greedy shrink

---

## 🔥 Basic to Advanced Problem Patterns

### Basic Level

These build the core habit:

- Reverse array / string
- Palindrome check
- Two Sum in sorted array
- Merge two sorted arrays
- Move all zeroes to end
- Remove duplicates from sorted array

### Intermediate Level

These teach condition-based movement:

- Container With Most Water
- Valid Palindrome with cleanup
- Remove specific elements in-place
- Sort Colors
- Pair with given sum
- Dutch National Flag variant problems

### Advanced Level

These require pattern recognition and duplicate handling:

- 3Sum
- 4Sum
- Trapping Rain Water
- Linked list cycle detection
- Remove Nth node from end
- Pair/triplet counting variations

---

## 🧪 Step-by-Step Template

### Opposite-end template

```java
int left = 0;
int right = arr.length - 1;

while (left < right) {
    int sum = arr[left] + arr[right];

    if (sum == target) {
        return true;
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}
```

### Read/write template

```java
int write = 0;
for (int read = 0; read < arr.length; read++) {
    if (isValid(arr[read])) {
        arr[write] = arr[read];
        write++;
    }
}
```

### Fast/slow template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

## ⚠️ Common Mistakes

### 1) Moving the wrong pointer

In sorted pair-sum problems:
- sum too small → move `left++`
- sum too large → move `right--`

If you reverse this, logic breaks.

### 2) Not sorting before using pair logic

Two-pointer pair logic usually assumes sorted data.
If the array is not sorted, either sort it first or use a different technique like HashMap.

### 3) Forgetting duplicates in 3Sum/4Sum

After finding one valid answer, always skip repeated values.
Otherwise duplicate triplets/quadruplets appear.

### 4) Overwriting useful data in read/write problems

In-place updates must preserve unread data.
Always ensure `write <= read`.

### 5) Pointer crossing condition ignored

Usually the loop should stop at:
- `left < right`
- `slow != null && fast != null`
- `i < n && j < m`

Using the wrong boundary can cause bugs or infinite loops.

---

## 📌 Repository References

This repo already contains good starter examples for two-pointer practice:

- `Algorithm/TwoPointerAlgorithm.java`
- `Algorithm/BasicTwoPointerQuestions/TwoPointerQuestion.java`

Use them to see:
- sorted pair matching
- moving zeroes
- removing duplicates
- array reverse

---

## 🧭 How to Practice This Topic Deeply

### Recommended order

1. Reverse array / string
2. Palindrome check
3. Two Sum in sorted array
4. Move Zeroes
5. Remove Duplicates from Sorted Array
6. Merge Sorted Arrays
7. Container With Most Water
8. Trapping Rain Water
9. 3Sum
10. 4Sum
11. Fast/slow linked list problems

### Study method

For every question, write down:

- **What are the pointers doing?**
- **Why is pointer movement correct?**
- **Is the array sorted?**
- **Can I prove the time complexity?**
- **What are the edge cases?**

---

## 🧠 Interview Answer Template

When asked in interview, explain like this:

> "I am using two pointers because the problem has a monotonic structure. Based on the current condition, moving one pointer changes the state in a predictable way. That lets me avoid checking all pairs and reduces the complexity from O(n²) to O(n) in many cases."

That answer sounds simple, but it shows real understanding.

---

## ✅ Key Takeaways

- Two pointer is a **pattern**, not just a trick.
- It works best when pointer movement is **meaningful and monotonic**.
- It is commonly used for **pairs, palindromes, merges, partitioning, and linked list traversal**.
- Always check:
  - sorted vs unsorted
  - left/right vs fast/slow
  - duplicate handling
  - boundary conditions

> Mastering this one pattern makes many interview problems feel much easier.

