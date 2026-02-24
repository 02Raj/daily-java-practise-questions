package javainterview.basiccodingquestions;

public class Factorial {

    public static int  factorialIterative(int num){
        int result = 1;
        for(int i = 1; i <= num; i++){
            result  *= i;
        }
        return result;
    }

    public  static int factorialRecursive(int num){
        if(num <= 1) return 1;
        return num *  factorialRecursive(num-1);
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial (Iterative): " + factorialIterative(num));
        System.out.println("Factorial (Recursive): " + factorialRecursive(num));
    }
}
