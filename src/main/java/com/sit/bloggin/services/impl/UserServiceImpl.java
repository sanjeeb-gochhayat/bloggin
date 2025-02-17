package com.sit.bloggin.services.impl;

import com.sit.bloggin.payloads.UserDto;
import com.sit.bloggin.repositories.UserRepo;
import com.sit.bloggin.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto user) {
        
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
