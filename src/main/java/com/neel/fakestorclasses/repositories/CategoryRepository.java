package com.neel.fakestorclasses.repositories;

import com.neel.fakestorclasses.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category save(Category category);
}
