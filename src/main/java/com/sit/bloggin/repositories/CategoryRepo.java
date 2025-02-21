package com.sit.bloggin.repositories;

import com.sit.bloggin.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
