package com.example.cv_back.cv.workplace;

import com.example.cv_back.domain.company.CompanyMapper;
import com.example.cv_back.domain.company.CompanyService;
import com.example.cv_back.domain.entity.Company;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {

    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyMapper companyMapper;
    public List<CompanyDto> getWorkplaces(Integer userId) {
        List<Company> company = companyService.findCompanies(userId);
        List<CompanyDto> companyDtos = companyMapper.toDtos(company);
        return companyDtos;
    }
}
