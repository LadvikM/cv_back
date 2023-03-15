package com.example.cv_back.domain.company;

import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Resource
    private CompanyRepository companyRepository;
    public List<Company> findCompanies(Integer userId) {
        List<Company> company = companyRepository.findCompany(userId);
        Validator.checkEntries(company);
        return company;
    }
}
