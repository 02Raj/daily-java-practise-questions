package oops.classbasics;

public class Main {
    public static void main(String[] args) {
        Payment payment1 = new CreditCard();
        Payment payment2 = new PayPal();
        payment1.processPayment();
        payment2.processPayment();
    }
}
