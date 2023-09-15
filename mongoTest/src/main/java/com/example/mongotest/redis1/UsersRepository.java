package com.example.mongotest.redis1;

import com.example.mongotest.User;
import com.example.mongotest.redis1.UserRedis;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    public static final String HASH_KEY = "USER";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public UsersRepository(RedisTemplate redisTemplate) {
        this.hashOperations=redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(UserRedis user){
        hashOperations.put(HASH_KEY,user.getId(),user);
    }

    public List<UserRedis> findAll(){
        return hashOperations.values("USER");
    }

    public User findById(int id){
        return (User) hashOperations.get("USER",id);
    }

    public void updateUser(UserRedis user){
        saveUser(user);
    }

    public void deleteUser(int id){
        hashOperations.delete("USER",id);
    }


}