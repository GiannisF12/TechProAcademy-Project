package com.giannis_foras.ProductService.service;

import com.giannis_foras.ProductService.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product getProductByName(String name);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

}
