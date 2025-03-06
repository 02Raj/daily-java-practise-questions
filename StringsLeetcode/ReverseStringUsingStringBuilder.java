package StringsLeetcode;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String original = "Divyansh";
        StringBuilder sb = new StringBuilder(original);
        String result = sb.reverse().toString();
        System.out.println("result:" + result);
    }
}
