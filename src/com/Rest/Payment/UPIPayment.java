
package com.Rest.Payment;

public class UPIPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.printf("UPI payment successful: Rs. %.2f%n", amount);
        return true;
    }

    @Override
    public String getMethodName() {
        return "UPI";
    }
}
