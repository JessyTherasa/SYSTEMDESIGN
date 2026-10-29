
package com.Rest.Payment;

public interface PaymentMethod {
    boolean pay(double amount);
    String getMethodName();
}
