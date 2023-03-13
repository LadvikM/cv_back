package com.example.cv_back.domain.cvs;

import com.example.cv_back.domain.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CvRepository extends JpaRepository<Cv, Integer> {
    @Query("select c from Cv c where c.user.id = ?1")
    Optional<Cv> findCv(Integer userId);


}