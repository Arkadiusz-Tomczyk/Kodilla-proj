package com.kodilla.good.patterns.Food2Door;

import java.util.Random;

public class GlutenFreeShop implements Supplier {
    @Override
    public String getSupplierName() {
        return "GlutenFreeShop";
    }

    @Override
    public boolean process(Order order) {
        System.out.println("Processing order " + order.getProductName() + ", pcs: " + order.getProductQuantity());
        Random random = new Random();
        return random.nextBoolean();
    }
}
