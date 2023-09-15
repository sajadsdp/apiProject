package com.example.mongotest;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserServiceImp{

    //add user
    User addUser(User user);

    //get all user
    List<User> getAllUsers();

    //get user by id
    User getUserById(String id);

    //update user
    User updateUser(String id, User updateUser);

    //delete user
    abstract Boolean deleteUser(String id);
}
