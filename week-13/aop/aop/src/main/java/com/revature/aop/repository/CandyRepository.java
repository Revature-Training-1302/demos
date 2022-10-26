package com.revature.aop.repository;

import com.revature.aop.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Long> {
    // return how much candy is in the repo:
    @Query(value = "SELECT COUNT(*) FROM candy", nativeQuery = true)
    public int getCount();
}
