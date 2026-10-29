
package com.Rest.Model;

public class Table {
    private final int tableId;
    private final int capacity;
    private boolean available;

    public Table(int tableId, int capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.available = true;
    }

    public int getTableId() {
        return tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Table " + tableId
                + " | Capacity: " + capacity
                + " | " + (available ? "Available" : "Reserved");
    }
}
