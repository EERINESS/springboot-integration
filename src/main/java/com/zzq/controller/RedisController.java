package com.zzq.controller;

import com.zzq.entity.JsonResult;
import com.zzq.entity.SysUser;
import com.zzq.entity.User;
import com.zzq.utils.JsonUtils;
import com.zzq.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zzq
 * @createTime 2018/3/29
 */
@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("test")
    public JsonResult test(){
        stringRedisTemplate.opsForValue().set("test - cache", "hello redis");
        return JsonResult.ok(stringRedisTemplate.opsForValue().get("test - cache"));
    }

    @RequestMapping("jsonTest")
    public JsonResult jsonTest(){
        SysUser user = new SysUser();
        user.setId("1000909");
        user.setUsername("lee" + new Date());
        user.setNickname("lee" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        stringRedisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));
        return JsonResult.ok(JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"), SysUser.class));
    }

    @RequestMapping("jsonList")
    public JsonResult jsonList(){
        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("userInfo", JsonUtils.objectToJson(userList), 2000);

        return JsonResult.ok(JsonUtils.jsonToList(redis.get("userInfo"), User.class));
    }
}
