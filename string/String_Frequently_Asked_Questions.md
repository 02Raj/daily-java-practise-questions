Core Concepts & Manipulations
Palindrome Check

Problem: Given a string, determine if it's a palindrome (reads the same forwards and backwards).

Key Idea: Two-pointer approach. Use one pointer at the start and one at the end, comparing characters. Learn to handle non-alphanumeric characters and case sensitivity.

Example: "Madam", "racecar"

Anagram Check

Problem: Given two strings, determine if they are anagrams of each other (contain the same characters with the same frequencies).

Key Idea: Use a hash map or array to compare character frequencies, or sort both strings and compare them.

Example: "listen", "silent"

Reverse a String

Problem: Reverse a given string.

Key Idea: Use a two-pointer approach for in-place reversal, or utilize StringBuilder/StringBuffer for efficiency.

Example: "hello" -> "olleh"

First Non-Repeating Character

Problem: Find the first character in a string that appears only once.

Key Idea: Use a hash map to store character counts, then iterate again to find the first character with a count of 1.

Example: "leetcode" -> 'l'

Remove Duplicates from a String

Problem: Given a string, remove duplicate characters.

Key Idea: Use a HashSet to keep track of seen characters, or a boolean array if the character set is small (e.g., 'a'-'z'). Build a new string or modify in-place if allowed.

Substring & Pattern Matching
Longest Substring Without Repeating Characters

Problem: Find the length of the longest substring in a given string that does not contain any repeating characters.

Key Idea: Employ a sliding window approach with a hash set/map to track characters within the current window.

Example: "abcabcbb" -> 3 ("abc")

Longest Palindromic Substring

Problem: Find the longest palindromic substring within a given string.

Key Idea: Expand around center (for odd and even length palindromes), or dynamic programming.

Implement strStr() / Substring Search

Problem: Find the first occurrence of a needle string in a haystack string.

Key Idea: Naive approach (brute force), KMP algorithm (more efficient for larger texts and patterns), Rabin-Karp algorithm (hashing-based).

Count Occurrences of a Character/Substring

Problem: Count how many times a specific character or substring appears in a string.

Key Idea: Simple iteration, or using built-in string methods (if allowed) for substrings.

Group Anagrams

Problem: Given an array of strings, group anagrams together.

Key Idea: Use a hash map where the key is the sorted version of the word (e.g., "eat" -> "aet") and the value is a list of its anagrams.

Conversions & Formatting
String to Integer (atoi)

Problem: Implement the atoi function, which converts a string to an integer. Handle various edge cases like whitespace, signs, and overflow.

Key Idea: Parse character by character, manage the sign, and rigorously check for overflow conditions.

Reverse Words in a Sentence

Problem: Reverse the order of words in a sentence, while keeping the words themselves intact.

Key Idea: Split the string into words, reverse the array of words, then join them back. Handle multiple spaces.

Example: "the sky is blue" -> "blue is sky the"

Valid Parentheses

Problem: Determine if the input string containing parentheses (round, curly, square) is valid.

Key Idea: Use a stack to track opening parentheses and check for matching closing ones.

Roman to Integer / Integer to Roman

Problem: Convert a Roman numeral to an integer, or vice versa.

Key Idea: Map Roman symbols to values. For Roman to Integer, handle subtractive notation (e.g., IV, IX).

Simplify Path (Unix-style)

Problem: Given a Unix-style absolute path, simplify it.

Key Idea: Use a stack to process path components (e.g., ".", "..", directory names).

Text Justification (Word Wrap)

Problem: Given an array of words and a maximum width, format the text such that each line has exactly maxWidth characters and is fully justified.

Key Idea: Greedy approach for line fitting, then distribution of extra spaces. This is a complex problem often seen in hard rounds.

Decode String (with numbers and brackets)

Problem: Given an encoded string, return its decoded string. k[encoded_string] means encoded_string is repeated k times.

Key Idea: Use two stacks: one for counts and one for strings, or recursion.

Longest Common Prefix

Problem: Find the longest common prefix string amongst an array of strings.

Key Idea: Iterate through characters, comparing the character at the current position across all strings.

Zigzag Conversion

Problem: Convert a given string into a zigzag pattern on a given number of rows.

Key Idea: Simulate the pattern, or calculate indices where each character should go.

