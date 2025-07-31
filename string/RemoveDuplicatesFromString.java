package string;

import java.util.HashSet;

public class RemoveDuplicatesFromString {

    //  Method to remove duplicate characters from a string
    public static String removeDuplicate(String str) {
        //  Result banane ke liye StringBuilder use kar rahe hain
        StringBuilder result = new StringBuilder();
        //  HashSet har unique character ko store karega (duplicate ko ignore karne ke liye)
        HashSet<Character> seen = new HashSet<>();
        //  Har character ke liye loop chalega
        for (char ch : str.toCharArray()) {
            // 🔹 Agar yeh character pehli baar aaya hai
            if (!seen.contains(ch)) {
                //  Usse Set mein add karo (taaki next time pata chale yeh repeat ho raha hai)
                seen.add(ch);
                //  Result mein bhi add karo (kyunki yeh unique hai)
                result.append(ch);
            }
            //  Agar character already seen hai, to skip ho jayega
        }
        // 🔚 Final string return karo jisme sirf unique characters hain (in original order)
        return result.toString();
    }

    public static void main(String[] args) {

        //  Input string
        String input = "Programming";

        // Duplicates remove kar ke result milega
        String output = removeDuplicate(input);

        //  Output print kar rahe hain
        System.out.println("original: " + input);  // original: Programming
        System.out.println("output: " + output);   // output: Progamin
    }
}
