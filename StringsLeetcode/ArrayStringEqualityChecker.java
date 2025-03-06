package StringsLeetcode;

public class ArrayStringEqualityChecker {

    public boolean areEqual(String[] word1, String[] word2){
        String str1 = String.join("", word1);
        System.out.println(str1 + " ");
        String str2 = String.join("", word2);
        System.out.println(str2 + " ");

        return str1.equals(str2);
    }


    public static void main(String[] args) {
        ArrayStringEqualityChecker checker = new ArrayStringEqualityChecker();

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        System.out.println(checker.areEqual(word1, word2));

//        String[] word1Example2 = {"a", "cb"};
//        String[] word2Example2 = {"ab", "c"};
//
//        System.out.println(checker.areEqual(word1Example2, word2Example2));
    }
}
