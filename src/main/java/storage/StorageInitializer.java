package storage;

import java.math.BigDecimal;
import entity.Auction;
import entity.Customer;
import entity.Product;

public class StorageInitializer {
    public static void initialize() {
        Customer bob = new Customer();
        bob.setId(Storage.generateCustomerId());
        bob.setLogin("Bob");

        Customer alise = new Customer();
        alise.setId(Storage.generateCustomerId());
        alise.setLogin("Alise");

        Storage.getCustomers().add(bob);
        Storage.getCustomers().add(alise);

        Product chair = new Product();
        chair.setId(Storage.generateProductId());
        chair.setPrice(BigDecimal.valueOf(13));
        chair.setTitle("Chair");

        Product table = new Product();
        table.setId(Storage.generateProductId());
        table.setPrice(BigDecimal.valueOf(666));
        table.setTitle("Table");

        Storage.getProducts().add(chair);
        Storage.getProducts().add(table);

        Auction firstAuction = new Auction();
        firstAuction.setId(Storage.generateAuctionId());
        firstAuction.setProduct(chair);

        Auction secondAuction = new Auction();
        secondAuction.setId(Storage.generateAuctionId());
        secondAuction.setProduct(table);

        Storage.getAuctions().add(firstAuction);
        Storage.getAuctions().add(secondAuction);
    }
}
