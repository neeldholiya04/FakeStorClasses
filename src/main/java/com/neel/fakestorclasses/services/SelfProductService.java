package com.neel.fakestorclasses.services;

import com.neel.fakestorclasses.exceptions.CategoryNotFoundException;
import com.neel.fakestorclasses.exceptions.ProductNotFoundException;
import com.neel.fakestorclasses.models.Category;
import com.neel.fakestorclasses.models.Product;
import com.neel.fakestorclasses.repositories.CategoryRepository;
import com.neel.fakestorclasses.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product with id " + id + " not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) {
            product.setCategory(categoryRepository.save(category));
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Invalid Category is Passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
