package com.example.cv_back.cv.workplace;

import com.example.cv_back.domain.company.CompanyMapper;
import com.example.cv_back.domain.company.CompanyService;
import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.domain.entity.Position;
import com.example.cv_back.domain.position.PositionMapper;
import com.example.cv_back.domain.position.PositionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WorkplaceService {

    @Resource
    PositionMapper positionMapper;
    @Resource
    PositionService positionService;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private CompanyService companyService;

    public List<CompanyDto> getWorkplaces(Integer userId) {
        List<Company> company = companyService.findCompanies(userId);
        List<CompanyDto> companyDtos = companyMapper.toDtos(company);

        for (CompanyDto companyDto : companyDtos) {
            List<Position> positions = positionService.findPositions(companyDto.getCompanyId());
            List<PositionDto> positionDtos = positionMapper.toDtos(positions);
            formatDates(positionDtos);
            companyDto.setPositions(positionDtos);
        }
        return companyDtos;
    }


    public void deleteAllWorkplaces(Integer userId) {
        List<Company> company = companyService.findCompanies(userId);
        List<CompanyDto> companyDtos = companyMapper.toDtos(company);
        for (CompanyDto companyDto : companyDtos) {
            List<Position> positions = positionService.findPositions(companyDto.getCompanyId());
            List<PositionDto> positionDtos = positionMapper.toDtos(positions);
            for (PositionDto positionDto : positionDtos) {
                positionService.deletePosition(positionDto.getPositionId());
            }
            companyService.deleteCompanies(companyDto.getCompanyId());
        }
    }


    private static void formatDates(List<PositionDto> positionDtos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (PositionDto positionDto : positionDtos) {
            if (positionDto.getPositionEndDate() == null) {
                positionDto.setPositionEndDate("Present");
                LocalDate startDate = LocalDate.parse(positionDto.getPositionStartDate());
                positionDto.setPositionStartDate(startDate.format(formatter));
            } else {
                LocalDate startDate = LocalDate.parse(positionDto.getPositionStartDate());
                positionDto.setPositionStartDate(startDate.format(formatter));
                LocalDate endDate = LocalDate.parse(positionDto.getPositionEndDate());
                positionDto.setPositionEndDate(endDate.format(formatter));
            }
        }
    }

}
