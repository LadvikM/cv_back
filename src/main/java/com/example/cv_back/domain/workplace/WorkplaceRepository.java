package com.example.cv_back.domain.workplace;

import com.example.cv_back.domain.Entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
}