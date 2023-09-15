package com.example.mongotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImp {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //add user
    @Override
    public User addUser(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            return null;
        }
    }

    //get all user
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get user by id
    @Override
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    //update user
    @Override
    public User updateUser(String id, User updateUser){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            user.setName(updateUser.getName());
            user.setMail(updateUser.getMail());
            user.setMail(updateUser.getMail());
            return userRepository.save(user);
        }else
            return null;
    }

    //delete user
    @Override
    public Boolean deleteUser(String id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
