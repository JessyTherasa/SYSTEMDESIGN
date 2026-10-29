
package com.Rest.Service;

import com.Rest.Model.Table;
import com.Rest.Repository.TableRepository;
import java.util.List;

public class TableService {
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<Table> getAllTables() {
        return repository.findAll();
    }

    public boolean reserveTable(int tableId) {
        Table table = repository.findById(tableId);

        if (table == null || !table.isAvailable()) {
            return false;
        }

        table.setAvailable(false);
        return true;
    }

    public boolean releaseTable(int tableId) {
        Table table = repository.findById(tableId);

        if (table == null || table.isAvailable()) {
            return false;
        }

        table.setAvailable(true);
        return true;
    }
}
