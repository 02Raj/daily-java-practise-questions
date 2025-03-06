package withoutrecursion;

public class CheckVowel {

    public static void main(String[] args) {
        String str = "Divyansh";
        str = str.toLowerCase();

        boolean vowelPresent = false;

        for(int i=0; i<= str.length()-1; i++){
            char ch = str.charAt(i);

            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelPresent = true;
                break;
            }
        }

        if (vowelPresent) {
            System.out.println("A vowel is present in the string.");
        } else {
            System.out.println("No vowel is present in the string.");
        }

    }
}
