package StringsLeetcode;
public class RemovePalindromeSub {
    public static String removePalindromeSub(String str) {

        if (str == null || str.isEmpty()) {
            return "";
        }


        if (isPalindrome(str)) {
            return "1";
        } else {

            return "2";
        }
    }

    private static boolean isPalindrome(String str) {

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "baabb";
        String result = removePalindromeSub(str);
        System.out.println("Result: " + result);
    }
}
