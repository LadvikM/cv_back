package com.example.cv_back.cv.workplace;

import com.example.cv_back.domain.company.CompanyMapper;
import com.example.cv_back.domain.company.CompanyService;
import com.example.cv_back.domain.entity.Company;
import com.example.cv_back.domain.entity.Location;
import com.example.cv_back.domain.entity.Position;
import com.example.cv_back.domain.entity.User;
import com.example.cv_back.domain.location.LocationMapper;
import com.example.cv_back.domain.location.LocationService;
import com.example.cv_back.domain.position.PositionMapper;
import com.example.cv_back.domain.position.PositionService;
import com.example.cv_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private LocationService locationService;
    @Resource
    private UserService userService;

    public void addWorkplaces(CompanyDto companyDto, Integer userId) {
        Location location = locationMapper.toEntity(companyDto);
        Optional<Location> companyLocation = locationService.findLocation(companyDto.getCityName(), companyDto.getCountryName());
        Company company = companyMapper.toEntity(companyDto);
        setLocation(location, companyLocation, company);
        setUser(userId, company);
        companyService.saveCompany(company);
        setPositions(companyDto, company);


    }

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

    private void setUser(Integer userId, Company company) {
        User user = userService.findUserById(userId);
        company.setUser(user);
    }

    private void setLocation(Location location, Optional<Location> companyLocation, Company company) {
        if (companyLocation.isPresent()) {
            company.setLocation(companyLocation.get());


        } else if (companyLocation.isEmpty()) {
            locationService.saveLocation(location);
            company.setLocation(location);
        }
    }

    private void setPositions(CompanyDto companyDto, Company company) {
        List<Position> positions = positionMapper.toEntities(companyDto.getPositions());
        for (Position position : positions) {
            position.setCompany(company);
            positionService.savePosition(position);
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
