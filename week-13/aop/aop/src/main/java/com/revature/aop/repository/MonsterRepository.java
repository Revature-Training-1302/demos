package com.revature.aop.repository;

import com.revature.aop.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// 1. Tells us that this interface is a repository, it will include CRUD methods (stereotype)
// 2. Because it is a stereotype derived from the @Component annotation, it tells Spring that this interface should be a bean, allowing us to inject into
// the other classes
@Repository
// when we extend the JPARepository, we get access to all of the CRUD methods that are defined in the parent interfaces:
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    // https://www.baeldung.com/spring-data-derived-queries, Using derived queries
    // by adhering to the proper naming conventions, we can write methods like this without having to explicitly write out
    // the SQL query
    List<Monster> findByNameOrderByName(String name);



    @Query(value = "SELECT * FROM monsters WHERE monster_name = ?1 ORDER BY monster_name, description", nativeQuery = true)
//    HQL: SELECT m from Monster m...
    List<Monster> getMonsters();
}
