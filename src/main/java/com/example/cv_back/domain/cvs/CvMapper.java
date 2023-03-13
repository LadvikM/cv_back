package com.example.cv_back.domain.cvs;

import com.example.cv_back.cv.CV.CvDto;
import com.example.cv_back.domain.Cv;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CvMapper {

    @Mapping(source = "workplace.name", target = "workplaceName")
    @Mapping(source = "workplace.position.name", target = "positionName")
    @Mapping(source = "workplace.position.start", target = "startDate")
    @Mapping(source = "workplace.position.end", target = "endDate")
    @Mapping(source = "workplace.position.description", target = "workDescription")
    @Mapping(source = "workplace.location.country", target = "country")
    @Mapping(source = "workplace.location.city", target = "city")


    CvDto toDto(Cv cv);

}