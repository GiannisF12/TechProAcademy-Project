package com.giannis_foras.ProductService.service;

import com.giannis_foras.ProductService.model.Product;
import com.giannis_foras.ProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product getProductByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = repository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return repository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
