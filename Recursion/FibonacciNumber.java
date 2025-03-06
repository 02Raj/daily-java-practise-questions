package Recursion;

public class FibonacciNumber {

    public static void main(String[] args) {
        int result = fib(5);
        System.out.println("The 4th Fibonacci number is: " + result);
    }

    public static int fib(int n){
       if(n <=1 ){
        return n;
       }

       return fib(n-1) + fib(n-2);
    }
}
