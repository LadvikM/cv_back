package com.example.cv_back.domain.company;

import com.example.cv_back.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.user.id = ?1")
    List<Company> findCompany(Integer userId);



}