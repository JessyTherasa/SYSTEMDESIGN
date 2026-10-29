
package com.Rest.Payment;

public class CashPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.printf("Cash payment received: Rs. %.2f%n", amount);
        return true;
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
}
