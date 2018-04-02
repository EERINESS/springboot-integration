package com.zzq.service.impl;

import com.zzq.entity.Animal;
import com.zzq.mapper.AnimalMapper;
import com.zzq.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author zzq
 * @createTime 2018/4/1
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalMapper animalMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Animal findAnimalById(Integer id) {
        return animalMapper.findAnimalById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Animal animal) {
        return animalMapper.insert(animal);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Animal animal) {
        animalMapper.update(animal);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        animalMapper.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Animal> findAll() {
        return animalMapper.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertByMap(Map<String, Object> map) {
        return animalMapper.insertByMap(map);
    }


}
