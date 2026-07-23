package string;

public class ReverseChar {


    public static String reverseChar(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        String sentence = "Divyansh Kumar Singh";

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            result += reverseChar(word) + " ";
        }

        System.out.println(result.trim());
    }
}