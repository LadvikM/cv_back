package com.example.cv_back.domain.additionalinformation;

import com.example.cv_back.cv.additional_info.AdditionalInfoDto;
import com.example.cv_back.domain.entity.AdditionalInformation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdditionalInformationMapper {
    AdditionalInformation toEntity(AdditionalInfoDto additionalInfoDto);

    @Mapping(source = "informationName", target = "informationName")
    @Mapping(source = "informationDescription", target = "informationDescription")
    AdditionalInfoDto toDto(AdditionalInformation additionalInformation);
    List<AdditionalInfoDto> toDtos(List<AdditionalInformation> additionalInformation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AdditionalInformation partialUpdate(AdditionalInfoDto additionalInfoDto, @MappingTarget AdditionalInformation additionalInformation);
}