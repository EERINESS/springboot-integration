package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zzq
 * @createTime 2018/3/22
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {
    @RequestMapping("index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name", "thymeleaf-start");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(){
        return "thymeleaf/center/center";
    }

}
