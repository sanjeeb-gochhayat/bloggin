package com.sit.bloggin.repositories;

import com.sit.bloggin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
