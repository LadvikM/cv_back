package com.example.cv_back.domain.school;

import com.example.cv_back.cv.education.SchoolDto;
import com.example.cv_back.domain.entity.School;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SchoolMapper {
    School toEntity(SchoolDto schoolDto);

    @Mapping(source = "name", target = "schoolName")
    @Mapping(source = "id", target = "schoolId")
    @Mapping(source = "location.city", target = "cityName")
    @Mapping(source = "location.country", target = "countryName")

    SchoolDto toDto(School school);
    List<SchoolDto> toDtos(List<School> school);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    School partialUpdate(SchoolDto schoolDto, @MappingTarget School school);
}