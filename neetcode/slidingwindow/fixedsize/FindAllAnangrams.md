## 🧩 Find All Anagrams in a String

🔗 [LeetCode Problem Link](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

### 🧠 Approach:
- Sliding Window (fixed size) use kiya
- Pattern ka frequency array banaya (size 26 for a-z)
- Text pe har step pe char ka frequency kam/zyada kiya
- Har bar jab window ka size match kare pattern se, `allZero()` se check kiya kya yeh anagram hai

### 🔁 Related Code:
- `AnagramOccurrencesCounter.java` se hi inspired hai — waha count return kar rahe the, yaha indices.

### ⏱️ Time Complexity: `O(n)`
### 🗃️ Space Complexity: `O(1)`

### 📌 Learning:
- Sliding window ko efficiently kaise manage karein
- Frequency map ka practical use in string matching
- Code reusability with slight changes in logic

