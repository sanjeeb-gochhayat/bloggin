package com.sit.bloggin.services;

import com.sit.bloggin.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
