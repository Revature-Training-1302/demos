package com.revature.aop.service;

import com.revature.aop.entity.Candy;
import com.revature.aop.repository.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CandyService {
    @Autowired
    private CandyRepository candyRepository;

    // initialize some candy values in the database:
    public void initRepo() {
        candyRepository.save(new Candy(0l, "Reeses peanut butter cups"));
        candyRepository.save(new Candy(0l, "Snickers"));
        candyRepository.save(new Candy(0l, "Reese's"));
        candyRepository.save(new Candy(0l, "Twix"));
        candyRepository.save(new Candy(0l, "Gold doubloons of a candy horde"));
        candyRepository.save(new Candy(0l, "Butter Finger"));
    }

    public int getCandyCount() {
        return candyRepository.getCount();
    }

    // return a random treat from the repo:
    public Candy treat() {
        // get a list of the candy in the repository:
        List<Candy> candyList = candyRepository.findAll();
        // return a random candy from the candy list, make sure we have candies in the database

        return candyList.get(new Random().nextInt(getCandyCount()));
    }

    // raise an exception because tricks aren't allowed:
    // specify that this method throws an exception:
    public String trick() throws Exception{
        // throw an exception:
        throw new Exception("No tricks allowed!");
    }
}
