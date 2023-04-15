package com.example.cv_back.domain.location;

import com.example.cv_back.cv.workplace.CompanyDto;
import com.example.cv_back.domain.entity.Location;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {
    @Mapping(source = "cityName", target = "city")
    @Mapping(source = "countryName", target = "country")
    Location toEntity(CompanyDto companyDto);

//    LocationDto toDto(Location location);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Location partialUpdate(LocationDto locationDto, @MappingTarget Location location);
}