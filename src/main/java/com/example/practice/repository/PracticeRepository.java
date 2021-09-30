package com.example.practice.repository;

import com.example.practice.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer> {

//    @Modifying
//    @Query("update Practice set hit = hit + 1 where id = id")
//    int practiceHit(Integer id);
}
