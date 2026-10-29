
package com.Rest.Service;

import com.Rest.Model.Payment;
import com.Rest.Payment.PaymentMethod;
import com.Rest.Repository.PaymentRepository;
import java.util.List;

public class PaymentService {
    private final PaymentRepository repository;
    private int nextPaymentId = 1;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment processPayment(double amount, PaymentMethod method) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        }

        boolean success = method.pay(amount);

        Payment payment = new Payment(
                nextPaymentId++,
                amount,
                method.getMethodName(),
                success
        );

        repository.save(payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
}
