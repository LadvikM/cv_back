package com.example.cv_back.domain;

import com.example.cv_back.cv.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toDto(User user);

}