package string.substringpatternmatching;

public class SubstringSearch {

    // 1. Manual implementation (without using indexOf)
    public static int strStrManual(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == nLen) return i; // match found
        }
        return -1; // match not found
    }

    // 2. Using Java built-in method
    public static int strStrBuiltIn(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";

        System.out.println("Manual Method Index: " + strStrManual(haystack, needle));    // Output: 4
        System.out.println("Built-in Method Index: " + strStrBuiltIn(haystack, needle)); // Output: 4
    }
}
