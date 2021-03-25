package service;

import entity.Product;

public interface ProductService {
    Product add(Product product);

    Product get(Long id);

    Product update(Product product);
}
