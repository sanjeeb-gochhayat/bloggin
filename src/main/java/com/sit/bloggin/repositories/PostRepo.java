package com.sit.bloggin.repositories;

import com.sit.bloggin.entities.Category;
import com.sit.bloggin.entities.Post;
import com.sit.bloggin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
