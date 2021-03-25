package repository;

import entity.Product;

public interface ProductRepository {
    Product add(Product product);

    Product get(Long id);

    Product update(Product product);
}
