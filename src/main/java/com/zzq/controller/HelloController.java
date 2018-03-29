package com.zzq.controller;

import com.zzq.entity.JsonResult;
import com.zzq.entity.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzq
 * @createTime 2018/3/22
 */
@RestController
public class HelloController {
    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public String hello(){
        return "hello springBoot";
    }

    @RequestMapping("getResource")
    public JsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JsonResult.ok(bean);
    }

}
