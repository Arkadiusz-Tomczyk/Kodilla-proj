package com.kodilla.good.patterns.Food2Door;

public interface Supplier {

    String getSupplierName();
    boolean process(Order order);
}
