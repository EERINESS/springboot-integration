package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zzq
 * @createTime 2018/3/26
 */
@Controller
@RequestMapping("error")
public class ErrorController {
    @RequestMapping("error")
    public String error(){
        int a = 1 / 0;
        return "thymeleaf/error";
    }
}
