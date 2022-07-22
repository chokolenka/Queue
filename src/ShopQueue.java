package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShopQueue {
    public static void main(String[] args) {
        Product water = new Product("water", 2.0);
        Product bread = new Product("bread", 1.0);
        Product gum = new Product("gum", 1.5);

        Buyer buyer1 = new Buyer(TypeCustomer.REGULAR);
        Buyer buyer2 = new Buyer(TypeCustomer.VETERAN);
        Buyer buyer3 = new Buyer(TypeCustomer.CHILD);

        buyer1.addProduct(water);
        buyer2.addProduct(bread);
        buyer2.addProduct(water);
        buyer3.addProduct(gum);

        PriorityQueue<Buyer> queue = new PriorityQueue<>();
        queue.add(buyer1);
        queue.add(buyer2);
        queue.add(buyer3);

        double sum = 0;
        Seller seller = new Seller();
        while (!queue.isEmpty()) {
            Buyer buyer = queue.poll();
            sum += seller.calc(buyer);
            System.out.println(buyer.customer);
            System.out.println(sum);
        }
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

enum TypeCustomer {
    VETERAN, CHILD, REGULAR
}

class Buyer implements Comparable {

    TypeCustomer customer;
    ArrayList<Product> basket = new ArrayList<>();

    public Buyer(TypeCustomer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        basket.add(product);
    }


    @Override
    public int compareTo(Object o) {
        int index1 = this.customer.ordinal();
        int index2 = ((Buyer) o).customer.ordinal();
        System.out.println(index1+ " " +index2);
        return index1 - index2;
    }
}

class Seller {
    public double calc(Buyer byuer) {
        double sum = byuer.basket.stream()
                .mapToDouble(p -> p.price)
                .sum();
        return sum;
    }
}
