package com.example.cv_back.domain.subject;

import com.example.cv_back.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("select s from Subject s where s.school.id = ?1")
    List<Subject> findSubjects(Integer schoolId);



}