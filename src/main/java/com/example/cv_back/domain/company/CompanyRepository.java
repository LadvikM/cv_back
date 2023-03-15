package com.example.cv_back.domain.company;

import com.example.cv_back.domain.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}