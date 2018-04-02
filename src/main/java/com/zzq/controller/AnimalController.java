package com.zzq.controller;

import com.zzq.entity.Animal;
import com.zzq.entity.JsonResult;
import com.zzq.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzq
 * @createTime 2018/4/1
 */
@RestController
@RequestMapping("animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("one/{id}")
    public Animal list(@PathVariable("id") Integer id){
        return animalService.findAnimalById(id);
    }

    @PostMapping("insert")
    public int insert(Animal animal){
        return animalService.insert(animal);
    }

    @PostMapping("update")
    public void update(@ModelAttribute("Animal") Animal animal){
        animalService.update(animal);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        animalService.delete(id);
    }

    @GetMapping("findAll")
    public JsonResult findAll(){
        return JsonResult.ok(animalService.findAll());
    }

    @PostMapping("insertByMap")
    public void insertByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "admin");
        map.put("sex", "m");
        map.put("age", 18);
        animalService.insertByMap(map);
    }

}
