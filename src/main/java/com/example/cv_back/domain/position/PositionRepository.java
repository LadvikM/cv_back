package com.example.cv_back.domain.position;

import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.domain.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    @Query("select p from Position p where p.company.id = ?1")
    List<Position> findPositions(Integer companyId);



}