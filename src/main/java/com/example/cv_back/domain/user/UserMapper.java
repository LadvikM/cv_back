package com.example.cv_back.domain.user;

import com.example.cv_back.cv.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    UserDto toDto(User user);

}