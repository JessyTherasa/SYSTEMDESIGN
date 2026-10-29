
package com.Rest.CLI;

import com.Rest.Service.TableService;
import java.util.Scanner;

public class Table {

    public static void showTables(TableService service) {
        System.out.println("\n--- Restaurant Tables ---");

        for (com.Rest.Model.Table table : service.getAllTables()) {
            System.out.println(table);
        }
    }

    public static void reserveTable(
            Scanner scanner, TableService service) {

        showTables(service);

        System.out.print("Enter table ID to reserve: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid table ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if (service.reserveTable(id)) {
            System.out.println("Table reserved successfully!");
        } else {
            System.out.println(
                "Table not found or already reserved."
            );
        }
    }

    public static void releaseTable(
            Scanner scanner, TableService service) {

        showTables(service);

        System.out.print("Enter table ID to release: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid table ID.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if (service.releaseTable(id)) {
            System.out.println("Table released successfully!");
        } else {
            System.out.println(
                "Invalid table ID or table is not reserved."
            );
        }
    }
}
