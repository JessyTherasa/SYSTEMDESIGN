
package com.Rest.Model;

public class Payment {
    private final int paymentId;
    private final double amount;
    private final String method;
    private final boolean successful;

    public Payment(int paymentId, double amount,
                   String method, boolean successful) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.successful = successful;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId
                + " | Amount: Rs. " + String.format("%.2f", amount)
                + " | Method: " + method
                + " | Status: " + (successful ? "SUCCESS" : "FAILED");
    }
}
