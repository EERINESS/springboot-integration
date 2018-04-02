package com.zzq.service;

import com.zzq.entity.Animal;

import java.util.List;
import java.util.Map;

/**
 * @author zzq
 * @createTime 2018/4/1
 */
public interface AnimalService {
    Animal findAnimalById(Integer id);
    int insert(Animal animal);
    void update(Animal animal);
    void delete(Integer id);
    List<Animal> findAll();
    int insertByMap(Map<String, Object> map);
}
