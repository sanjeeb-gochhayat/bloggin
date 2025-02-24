package com.sit.bloggin.repositories;

import com.sit.bloggin.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
