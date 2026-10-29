
package com.Rest.Repository;

import com.Rest.Model.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();

    public void save(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }
}
