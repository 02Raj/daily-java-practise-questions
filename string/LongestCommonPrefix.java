package string;

public class LongestCommonPrefix {

    /**
     * ============================================
     *              PROBLEM STATEMENT
     * ============================================
     * Given an array of strings, find the longest
     * common prefix shared among all the strings.
     *
     * If there is NO common prefix, return "".
     *
     * --------------------------------------------
     * INPUT:
     *   ["flower", "flow", "flight"]
     *
     * OUTPUT:
     *   "fl"
     *
     * --------------------------------------------
     * EXPLANATION:
     *   All strings start with:
     *       "fl" → common prefix
     *   After that, characters differ.
     *
     * --------------------------------------------
     * APPROACH:
     * 1. Assume the first string is the prefix.
     * 2. Compare it with every next string.
     * 3. If a string does NOT start with the prefix:
     *       → keep reducing prefix from the end
     * 4. If prefix becomes empty:
     *       → return "" (no common prefix)
     *
     * --------------------------------------------
     * TIME COMPLEXITY:  O(n * m)
     *   n = number of strings
     *   m = length of shortest string
     *
     * SPACE COMPLEXITY: O(1)
     *
     * ============================================
     */

    public String longestCommonPrefix(String[] strs) {

        // Edge Case: empty or null input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Step 1: Assume first string is the prefix
        String prefix = strs[0];

        // Step 2: Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {

            // Step 3: Reduce prefix until it matches or becomes empty
            while (!strs[i].startsWith(prefix)) {

                // Shrink prefix from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // No common prefix left
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Step 4: Return the final longest common prefix
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[] input = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + obj.longestCommonPrefix(input));
    }
}
