package Recursion.basicRecursionQue;

public class BasicRecursionQus {

static void printNum(int num){

    if (num == 0) return;

    System.out.print(num);
     printNum(num - 1);
}


    static void printName(int num){
        if (num == 0) return;

        System.out.println("Raj");
        printName(num - 1);


    }


    static void printNumRev(int num){
        if (num == 0) return;

        System.out.print(num);
        printNumRev(num - 1);
    }

    static int sumOfNum(int num){

     if(num == 0) return 0;


        return sumOfNum(num - 1) + num;

    }


    static int factorialOfNum(int num) {
        if (num <= 1) return 1;

        return factorialOfNum(num - 1) * num;
    }

//    static int reverseAarray(int[] arr){
//
//    if (arr.length == 0) return 0;
//
//
//    }

    public static void main(String[] args) {

        int num = 4;
//        printNum(num);
//
//        printName(num);
//
//        printNumRev(num);

//        sumOfNum(num);
//        System.out.println("Sum of first " + num + " natural numbers: " + sumOfNum(num));

        factorialOfNum(num);
        System.out.println("factorialOfNum of num " + factorialOfNum(num));

//        int[] arr  = {2,3,4,5,6,7};
//        reverseAarray(arr);
//        for (int i = 0; i < arr.length; i++){
//            System.out.println("array: " + arr[i]);
//        }
    }
}
