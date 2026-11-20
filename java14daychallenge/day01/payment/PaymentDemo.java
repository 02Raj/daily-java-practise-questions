package java14daychallenge.day01.payment;

import java.math.BigDecimal;

public class PaymentDemo {

    public static void main(String[] args) {
        PaymentService cardPaymentService =
                new PaymentService(new CreditCardPayment());
        PaymentService upiPaymentService =
                new PaymentService(new UpiPayment());

        cardPaymentService.processPayment(new BigDecimal("500.00"));
        upiPaymentService.processPayment(new BigDecimal("250.00"));

        try {
            upiPaymentService.processPayment(BigDecimal.ZERO);
        } catch (IllegalArgumentException exception) {
            System.out.println("Rejected: " + exception.getMessage());
        }
    }
}
