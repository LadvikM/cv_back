package com.example.cv_back.domain.school;

import com.example.cv_back.domain.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    @Query("select s from School s where s.user.id = ?1")
    List<School> findBySchools(Integer id);

}