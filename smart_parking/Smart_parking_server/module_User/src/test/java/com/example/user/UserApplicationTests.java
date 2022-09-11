package com.example.user;

import com.example.user.entity.User_information;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class UserApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    //json序列化工具
    private final static ObjectMapper mapper=new ObjectMapper();

    @Test
    void contextLoads() throws JsonProcessingException {
        User_information user_information = new User_information();
        user_information.setUser_id("111");
        user_information.setUser_name("雷");
        user_information.setPassword("asdas阿萨德");
        //手动序列化
        String json=mapper.writeValueAsString(user_information);
//        stringRedisTemplate.opsForValue().set("test",json);
//        String value=stringRedisTemplate.opsForValue().get("test");
        stringRedisTemplate.opsForValue().set("test1",json);
//        user_information.setUser_id("4444");
//        user_information.setUser_name("5555");
//        user_information.setPassword("6666");
//        json=mapper.writeValueAsString(user_information);
//
//        stringRedisTemplate.opsForHash().put("test","test2",json);
//        Long delete = stringRedisTemplate.opsForHash().delete("test", "test1");
//        System.out.println(delete);
        String s= stringRedisTemplate.opsForValue().get("test1");
        //反序列化
        System.out.println(s);
        User_information userInformation=mapper.readValue(s,User_information.class);
        System.out.println(userInformation);

//        redisTemplate.opsForValue().set("test",user_information);
//        User_information t = (User_information) redisTemplate.opsForValue().get("test");
//        System.out.println(t);


    }

}
