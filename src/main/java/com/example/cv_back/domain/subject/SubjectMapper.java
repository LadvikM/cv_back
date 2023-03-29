package com.example.cv_back.domain.subject;

import com.example.cv_back.cv.education.SubjectsDto;
import com.example.cv_back.domain.entity.Subject;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubjectMapper {
    Subject toEntity(SubjectsDto subjectsDto);
    @Mapping(source = "name", target = "subjectName")
    @Mapping(source = "start", target = "subjectStartDate")
    @Mapping(source = "end", target = "subjectEndDate")
    @Mapping(source = "description", target = "subjectDescription")
    SubjectsDto toDto(Subject subject);

    List<SubjectsDto> toDtos(List<Subject> subject);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Subject partialUpdate(SubjectsDto subjectsDto, @MappingTarget Subject subject);
}