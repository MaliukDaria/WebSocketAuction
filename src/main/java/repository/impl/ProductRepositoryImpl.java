package repository.impl;

import entity.Product;
import org.springframework.stereotype.Repository;
import repository.ProductRepository;
import storage.Storage;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product add(Product product) {
        product.setId(Storage.generateProductId());
        Storage.getProducts().add(product);
        return product;
    }

    @Override
    public Product get(Long id) {
        return Storage.getProducts().stream()
                .filter(auction -> auction.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cant find product with id " + id));
    }

    @Override
    public Product update(Product product) {
        Product productFromStorage = get(product.getId());
        productFromStorage.setTitle(product.getTitle());
        productFromStorage.setPrice(product.getPrice());
        return productFromStorage;
    }
}
