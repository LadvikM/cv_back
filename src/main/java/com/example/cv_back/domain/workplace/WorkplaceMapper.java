package com.example.cv_back.domain.workplace;

import com.example.cv_back.cv.workplace.WorkplaceDto;
import com.example.cv_back.domain.Entity.Workplace;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WorkplaceMapper {

    @Mapping(source = "name", target = "workplaceName")
    @Mapping(source = "location.country", target = "countryName")
    @Mapping(source = "location.city", target = "cityName")

    WorkplaceDto toDto(Workplace workplace);
    List<WorkplaceDto> toDtos(List<Workplace> workplace);



}