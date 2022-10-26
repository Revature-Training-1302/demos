package com.revature.aop.service;

import com.revature.aop.entity.Monster;
import com.revature.aop.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Stereotype annotation, we know this class is a bean and it is a service class
@Service
public class MonsterService {
    // automatically inject the monsterRepository:
    @Autowired
    MonsterRepository monsterRepository;

    // either if we're updating or inserting:
    public Monster upsert(Monster monster) {
        return monsterRepository.save(monster);
    }

    public Monster getById(Long id) {
        return monsterRepository.findById(id).get();
    }

    public List<Monster> getAll() {
        return monsterRepository.findAll();
    }

    public void delete(Long id) {
        monsterRepository.deleteById(id);
    }
}
