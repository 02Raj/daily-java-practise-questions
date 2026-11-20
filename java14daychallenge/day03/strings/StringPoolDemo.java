package java14daychallenge.day03.strings;

public class StringPoolDemo {

    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = s3.intern();

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1 == s4: " + (s1 == s4));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}
