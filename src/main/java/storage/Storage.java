package storage;

import java.util.ArrayList;
import java.util.List;
import entity.Auction;
import entity.Customer;
import entity.Product;

public class Storage {
    private static List<Auction> auctions;
    private static List<Product> products;
    private static List<Customer> customers;

    private static Long auctionCounter = 1L;
    private static Long productsCounter = 1L;
    private static Long customersCounter = 1L;

    static {
        auctions = new ArrayList<>();
        products = new ArrayList<>();
        customers = new ArrayList<>();
        StorageInitializer.initialize();
    }

    public static List<Auction> getAuctions() {
        return auctions;
    }

    public static void setAuctions(List<Auction> auctions) {
        Storage.auctions = auctions;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        Storage.products = products;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Storage.customers = customers;
    }

    public static Long generateAuctionId() {
        Long id = auctionCounter;
        auctionCounter++;
        return id;
    }

    public static Long generateProductId() {
        Long id = productsCounter;
        productsCounter++;
        return id;
    }

    public static Long generateCustomerId() {
        Long id = customersCounter;
        customersCounter++;
        return id;
    }
}
