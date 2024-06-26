package com.neel.fakestorclasses.controllers;


import com.neel.fakestorclasses.models.Product;
import com.neel.fakestorclasses.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
     {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
