
package com.Rest.Payment;

public class CardPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.printf("Card payment successful: Rs. %.2f%n", amount);
        return true;
    }

    @Override
    public String getMethodName() {
        return "Card";
    }
}
