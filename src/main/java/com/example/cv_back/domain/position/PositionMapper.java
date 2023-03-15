package com.example.cv_back.domain.position;

import com.example.cv_back.cv.workplace.PositionDto;
import com.example.cv_back.domain.entity.Position;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PositionMapper {
    Position toEntity(PositionDto positionDto);
    @Mapping(source = "name", target = "positionName")
    @Mapping(source = "start", target = "positionStartDate")
    @Mapping(source = "end", target = "positionEndDate")
    @Mapping(source = "description", target = "positionDescription")
    PositionDto toDto(Position position);
    List<PositionDto> toDtos(List<Position> positions);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Position partialUpdate(PositionDto positionDto, @MappingTarget Position position);
}