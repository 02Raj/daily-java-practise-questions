package pattern;

public class StarPattern {


    public static void print1() {
        int row = 5;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void print2() {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void print3() {
        int row = 5;

        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void print4() {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void print5() {
        int rows = 5;
        for (int i = rows; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print6(){
        int rows = 5;


        for (int i = 1; i <= rows; i++) {

            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }for (int i = rows; i >= 1; i--) {


            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }


            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }


            System.out.println();
        }
    }

    public static void print7(){
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print8() {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            int start;

            if (i % 2 == 0) {
                start = 0;
            } else {
                start = 1;
            }


            for (int j = 1; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void print9() {
        int rows = 4;

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }


            for (int k = i * 2; k < rows * 2; k++) {
                System.out.print(" ");
            }


            for (int l = i; l >= 1; l--) {
                System.out.print(l);
            }

            System.out.println();
        }
    }

    public static void print10(){
        int row = 5;
        int num = 1;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

    }


    public static void print11(){
        int row = 5;

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= i; j++){
                System.out.print((char) ('A' + j - 1));
            }
            System.out.println();
        }
    }

    public static void print12(){
        int row = 5;
        for(int i = row; i >= 1; i--){
            for(int j = 1; j <= i; j++){

              System.out.print((char) ('A' + j - 1));
            }
            System.out.println();
        }
    }

    public static void print13(){
        int row = 5;

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= i; j++){

                System.out.print((char) ('A' + i - 1));
            }
            System.out.println();
        }
    }


    public static void  print14(){
        int row = 5;

        // spcae print
        for (int i = 0; i <= row; i++){
            // space
            for(int j = 0; j < row - i - 1; j++)
                System.out.println(" ");

              // star
              for (int j = 0; j < 2 * i - 1; j++){
                  System.out.println((char) (j));
              }

            // space
            for (int j = 0; j <  row - i - 1; j++ ){

            }

        }


    }


    public static void main(String[] args) {
        System.out.println("Pattern 1:");
        print1();

        System.out.println("\nPattern 2:");
        print2();

        System.out.println("\nPattern 3:");
        print3();

        System.out.println("Pyramid Star Pattern:");
        print4();

        System.out.println("Revers Pyramid Star Pattern:");
        print5();

        System.out.println("combine Pyramid and reverse pyrmid Star Pattern:");
        print6();

        System.out.println("combine triangle and reverse triangle Star Pattern:");
        print7();

        System.out.println(" Pattern8:");
        print8();
        System.out.println("Symmetrical Number Pattern:");
        print9();

        System.out.println(" Pattern10:");
        print10();

        System.out.println(" Pattern11:");
        print11();

        System.out.println(" Pattern11:");
        print12();

        System.out.println(" Pattern13:");
        print13();




    }
}
