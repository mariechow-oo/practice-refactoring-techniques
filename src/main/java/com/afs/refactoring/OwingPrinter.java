package com.afs.refactoring;

import java.util.Iterator;
import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        int outstanding = calculateOutstanding(orders);

        // print banner
        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");

        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
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
