package oops.classbasics;

public class MathOperations {

    int add(int a, int b){
        return a * b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }


    double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        MathOperations math = new MathOperations();
//        System.out.println(STR."Sum of 2 and 3: \{math.add(2, 3)}");
//        System.out.println(STR."Sum of 2, 3, and 4: \{math.add(2, 3, 4)}");
//        System.out.println(STR."Sum of 2.5 and 3.5: \{math.add(2.5, 3.5)}");
    }

}
