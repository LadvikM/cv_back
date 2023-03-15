package com.example.cv_back.cv.workplace;

import com.example.cv_back.domain.company.CompanyMapper;
import com.example.cv_back.domain.company.CompanyService;
import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.domain.entity.Position;
import com.example.cv_back.domain.position.PositionMapper;
import com.example.cv_back.domain.position.PositionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {

    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    PositionMapper positionMapper;
    @Resource
    PositionService positionService;
    public List<CompanyDto> getWorkplaces(Integer userId) {
        List<Company> company = companyService.findCompanies(userId);
        List<CompanyDto> companyDtos = companyMapper.toDtos(company);
        for (CompanyDto companyDto : companyDtos) {
            List<Position> positions = positionService.findPositions(companyDto.getCompanyId());
            List<PositionDto> positionDtos = positionMapper.toDtos(positions);
            companyDto.setPositions(positionDtos);
        }
        return companyDtos;
    }
}
