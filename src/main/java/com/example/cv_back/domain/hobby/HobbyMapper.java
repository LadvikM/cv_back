package com.example.cv_back.domain.hobby;

import com.example.cv_back.cv.hobbies.HobbiesDto;
import com.example.cv_back.domain.entity.Hobby;
import com.example.cv_back.util.PictureUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface HobbyMapper {
//    Hobby toEntity(HobbiesDto hobbiesDto);

    @Mapping(source = "name", target = "hobbyName")
    @Mapping(source = "description", target = "hobbyDescription")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(hobby.getPicture()))", target = "picture")
    HobbiesDto toDto(Hobby hobby);
    List<HobbiesDto> toDtos(List<Hobby> hobby);


//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Hobby partialUpdate(HobbiesDto hobbiesDto, @MappingTarget Hobby hobby);
}