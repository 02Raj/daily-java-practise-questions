package basicarrayquestion;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }

        String cleaned = clean.toString();
        int n = cleaned.length();

        for (int i = 0; i < n / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // Test main method
    public static void main(String[] args) {
        IsPalindrome solution = new IsPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car")); // false
    }
}
