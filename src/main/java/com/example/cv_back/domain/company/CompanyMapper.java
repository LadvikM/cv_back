package com.example.cv_back.domain.company;

import com.example.cv_back.cv.workplace.CompanyDto;
import com.example.cv_back.domain.entity.Company;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyDto companyDto);
    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "id", target = "companyId")
    @Mapping(source = "location.city", target = "cityName")
    @Mapping(source = "location.country", target = "countryName")
    CompanyDto toDto(Company company);
    List<CompanyDto> toDtos(List<Company> company);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company partialUpdate(CompanyDto companyDto, @MappingTarget Company company);
}