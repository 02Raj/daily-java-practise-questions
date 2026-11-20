package java14daychallenge.day01.payment;

import java.math.BigDecimal;

public class UpiPayment implements PaymentMethod {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
