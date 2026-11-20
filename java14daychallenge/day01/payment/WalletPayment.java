package java14daychallenge.day01.payment;

import java.math.BigDecimal;

public class WalletPayment implements PaymentMethod {

        
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paid " + amount + " using Wallet");
    }
    
}
