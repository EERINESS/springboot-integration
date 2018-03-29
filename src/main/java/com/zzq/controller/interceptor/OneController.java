package com.zzq.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzq
 * @createTime 2018/3/29
 */
@Controller
@RequestMapping("two")
public class OneController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "interceptor";
    }
}
