package string.substringpatternmatching;

import java.util.HashSet;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String str){
        HashSet<Character> set = new HashSet<>();

        int left = 0; int right = 0; int maxLength = 0;
        int n = str.length();

        while(right <  n){
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength,right - left + 1);
                right++;
            }else{
                set.remove(str.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
