package com.afs.refactoring;

import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        printBanner();
        printDetails(name, calculateOutstanding(orders));
    }

    private void printDetails(String name, int outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    private void printBanner() {
        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
    }

    private int calculateOutstanding(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getAmount)
                .sum();
    }
}

class Order {
    private final int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
