package java14daychallenge.day01.payment;

import java.math.BigDecimal;

public class PaymentService {

    private final PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method must not be null");
        }
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        paymentMethod.pay(amount);
    }
}
