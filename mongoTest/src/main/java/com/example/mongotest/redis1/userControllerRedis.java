package com.example.mongotest.redis1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userControllerRedis {

    @Autowired
    private UsersRepository usersRepositoryRedis;

    @Autowired
    private UserRedisRepository userRedisRepository;

    @PostMapping("/redisSave")
    public UserRedis saveUserRedis(@RequestBody UserRedis user){
        usersRepositoryRedis.saveUser(user);
        return user;
    }

    @GetMapping("/redisGetAll")
    public List<UserRedis> getAllRedis(){
        return usersRepositoryRedis.findAll();
    }

}
