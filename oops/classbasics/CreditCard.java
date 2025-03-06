package oops.classbasics;

public class CreditCard extends Payment{

    @Override
    void processPayment() {
        System.out.println("payment processing with credit card");
    }



}
