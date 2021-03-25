package service.impl;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.get(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }
}
