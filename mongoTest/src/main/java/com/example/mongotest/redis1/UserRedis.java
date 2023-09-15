package com.example.mongotest.redis1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("USER")
public class UserRedis implements Serializable {

    @Id
    private String id;
    private String name;
    private String mail;
    private int age;
}
