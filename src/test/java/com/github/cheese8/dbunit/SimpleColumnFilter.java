package com.github.cheese8.dbunit;

import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;

import java.util.Arrays;

public class SimpleColumnFilter implements IColumnFilter {

    @Override
    public boolean accept(String tableName, Column column) {
        return !Arrays.asList("id", "created_at", "updated_at").contains(column.getColumnName().toLowerCase());
    }
}