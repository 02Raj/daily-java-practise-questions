# Most Important String Questions for Technical Interviews

These string-related questions are commonly asked in technical interviews. Understanding these problems and their solutions will help you stand out in coding rounds and whiteboard interviews.

---

## 📌 Core Concepts & Manipulations

### 🔹 Palindrome Check
**Problem:** Determine if a given string is a palindrome (reads the same forwards and backwards).  
**Key Idea:** Two-pointer approach; handle non-alphanumeric characters and case sensitivity.  
**Example:** `"Madam"`, `"racecar"`

---

### 🔹 Anagram Check
**Problem:** Check if two strings are anagrams (same characters, same frequency).  
**Key Idea:** Use a hash map for frequency count, or sort both strings and compare.  
**Example:** `"listen"` and `"silent"`

---

### 🔹 Reverse a String
**Problem:** Reverse the characters in a string.  
**Key Idea:** Two-pointer in-place reversal, or use `StringBuilder` in Java.  
**Example:** `"hello"` → `"olleh"`

---

### 🔹 First Non-Repeating Character
**Problem:** Find the first character in a string that appears only once.  
**Key Idea:** Count characters using hash map, then iterate again.  
**Example:** `"leetcode"` → `'l'`

---

### 🔹 Remove Duplicates from a String
**Problem:** Remove all duplicate characters from a string.  
**Key Idea:** Use a HashSet or boolean array to track characters.

---

## 🔍 Substring & Pattern Matching

### 🔹 Longest Substring Without Repeating Characters
**Problem:** Find the length of the longest substring with no repeating characters.  
**Key Idea:** Sliding window with hash set/hash map.  
**Example:** `"abcabcbb"` → `3` (`"abc"`)

---

### 🔹 Longest Palindromic Substring
**Problem:** Find the longest substring that is a palindrome.  
**Key Idea:** Expand around center or use dynamic programming.

---

### 🔹 Implement strStr() / Substring Search
**Problem:** Find the first occurrence of a needle string in a haystack string.  
**Key Idea:** Naive approach or advanced (KMP, Rabin-Karp) for efficiency.

---

### 🔹 Count Occurrences of a Character/Substring
**Problem:** Count how often a character or substring occurs.  
**Key Idea:** Iterate through string or use built-in methods.

---

### 🔹 Group Anagrams
**Problem:** Group strings that are anagrams.  
**Key Idea:** Use a hash map with sorted string as key.

---

## 🔄 Conversions & Formatting

### 🔹 String to Integer (atoi)
**Problem:** Implement `atoi`, converting a string to an integer.  
**Key Idea:** Parse char-by-char, manage sign, handle overflows.

---

### 🔹 Reverse Words in a Sentence
**Problem:** Reverse the word order in a sentence.  
**Key Idea:** Split by spaces, reverse the array, and join.  
**Example:** `"the sky is blue"` → `"blue is sky the"`

---

### 🔹 Valid Parentheses
**Problem:** Check if a string of parentheses is valid.  
**Key Idea:** Use a stack to match pairs.

---

### 🔹 Roman to Integer / Integer to Roman
**Problem:** Convert between Roman numerals and integers.  
**Key Idea:** Use a value map and handle subtractive cases.

---

### 🔹 Simplify Path (Unix-style)
**Problem:** Simplify an absolute Unix file path.  
**Key Idea:** Use a stack to handle `"."`, `".."`, and directory names.

---

### 🔹 Text Justification (Word Wrap)
**Problem:** Format text so each line is fully justified with a given width.  
**Key Idea:** Greedy approach with space distribution.

---

### 🔹 Decode String (with numbers and brackets)
**Problem:** Decode a string like `"3[a2[c]]"` → `"accaccacc"`.  
**Key Idea:** Use two stacks (for numbers and strings) or recursion.

---

### 🔹 Longest Common Prefix
**Problem:** Find the longest common prefix in a string array.  
**Key Idea:** Compare characters at each position across all strings.

---

### 🔹 Zigzag Conversion
**Problem:** Convert string into zigzag pattern on n rows and read row-by-row.  
**Key Idea:** Simulate zigzag or calculate correct row for each character.

---
