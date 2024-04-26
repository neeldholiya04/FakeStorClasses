package com.neel.fakestorclasses.repositories;

import com.neel.fakestorclasses.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Override
    Optional<Product> findById(Long id);
    Product save(Product product);
}
