
package com.Rest.CLI ;

import com.Rest.Payment.CardPayment;
import com.Rest.Payment.CashPayment;
import com.Rest.Payment.UPIPayment;
import com.Rest.Payment.PaymentMethod;
import com.Rest.Service.PaymentService;
import java.util.Scanner;

public class PaymentCli {

    public static void makePayment(
            Scanner scanner, PaymentService service) {

        System.out.print("Enter payment amount: Rs. ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.nextLine();
            return;
        }

        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        System.out.println("1. Card");
        System.out.println("2. Cash");
        System.out.println("3. UPI");
        System.out.print("Choose payment method: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid choice.");
            scanner.nextLine();
            return;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        PaymentMethod method;

        switch (choice) {
            case 1:
                method = new CardPayment();
                break;
            case 2:
                method = new CashPayment();
                break;
            case 3:
                method = new UPIPayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        try {
            System.out.println(
                    "Saved: " + service.processPayment(amount, method));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showPayments(PaymentService service) {
        System.out.println("\n--- Payment History ---");

        if (service.getAllPayments().isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        service.getAllPayments().forEach(System.out::println);
    }
}
