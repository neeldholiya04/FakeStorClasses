package com.neel.fakestorclasses.services;

import java.util.*;
import com.neel.fakestorclasses.models.Product;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
