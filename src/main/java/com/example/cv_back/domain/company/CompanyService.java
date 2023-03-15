package com.example.cv_back.domain.company;

import com.example.cv_back.domain.entity.Company;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Resource
    private CompanyRepository companyRepository;
    public List<Company> findCompanies(Integer userId) {
        List<Company> company = companyRepository.findCompany(userId);
        return company;
    }
}
