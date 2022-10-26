package com.revature.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.revature.entity.Costume;
import org.springframework.stereotype.Component;

import java.util.List;

// make this class visible to be registered as a bean
@Component
public class CostumeDao {

    // manages our entities, persists to database as well as retrieve values from our database
    // https://www.baeldung.com/jpa-hibernate-persistence-context
    @PersistenceContext
    private EntityManager em;

    public void persist(Costume costume) {
        // save/persist the costume to the database:
        em.persist(costume);
    }

    public List<Costume> findAll() {
        // Use Hibernate Query Language:
        // https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
        return em.createQuery("SELECT c FROM Costume c").getResultList();
    }




}
