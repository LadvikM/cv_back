package com.example.cv_back.domain.hobby;

import com.example.cv_back.domain.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
    @Query("select h from Hobby h where h.user.id = ?1")
    List<Hobby> findHobbies(Integer userId);

}