package com.zzq.controller;

import com.zzq.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zzq
 * @createTime 2018/3/22
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {
    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("resource", resource);
        return "freemarker/index";
    }
    @RequestMapping("center")
    public String center(){
        return "freemarker/center/center";
    }
}
