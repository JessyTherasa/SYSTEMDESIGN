
package com.Rest;

import com.Rest.CLI.PaymentCli;
import com.Rest.CLI.Table;
import com.Rest.Repository.PaymentRepository;
import com.Rest.Repository.TableRepository;
import com.Rest.Service.PaymentService;
import com.Rest.Service.TableService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PaymentRepository paymentRepository =
                new PaymentRepository();

        TableRepository tableRepository =
                new TableRepository();

        PaymentService paymentService =
                new PaymentService(paymentRepository);

        TableService tableService =
                new TableService(tableRepository);

        boolean running = true;

        System.out.println(
                "Welcome to Restaurant Management System!");

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Make Payment");
            System.out.println("2. View Payment History");
            System.out.println("3. View Restaurant Tables");
            System.out.println("4. Reserve Table");
            System.out.println("5. Release Table");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    PaymentCli.makePayment(
                            scanner, paymentService);
                    break;

                case 2:
                    PaymentCli.showPayments(paymentService);
                    break;

                case 3:
                    Table.showTables(tableService);
                    break;

                case 4:
                    Table.reserveTable(scanner, tableService);
                    break;

                case 5:
                    Table.releaseTable(scanner, tableService);
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
