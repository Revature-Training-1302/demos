package com.revature.service;

import com.revature.dao.CostumeDao;
import com.revature.entity.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class CostumeService {
    @Autowired
    CostumeDao costumeDao;

    // create a transaction for the database operation
    @Transactional
    public void add(Costume costume) {
        costumeDao.persist(costume);
    }

    // Make this transactional to make sure the transaction is atomic (all or nothing)
    // if one insert fails, we want to cancel the rest
    @Transactional
    public void addAll(Collection<Costume> costumes) {
        // iterate through our costume collection and persist each costume
        for(Costume costume: costumes) {
            costumeDao.persist(costume);
        }
    }

    // not changing the data, so we can set readOnly to true:
    @Transactional(readOnly = true)
    public List<Costume> findAll() {
        return costumeDao.findAll();
    }
}
