package com.example.cv_back.domain.user;

import com.example.cv_back.cv.AvailableCv.CvDto;
import com.example.cv_back.cv.login.UserDto;
import com.example.cv_back.cv.sidepanelinfo.SidepanelDto;
import com.example.cv_back.domain.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    UserDto toDto(User user);
    @Mapping(source = "email", target = "email")
    @Mapping(source = "github", target = "github")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "telephone", target = "telephone")
    @Mapping(source = "linkedin", target = "linkedin")
    SidepanelDto userInfoDto(User userInfo);

    @Mapping(source = "id", target = "userId")
    CvDto cvDto(User activeCv);
    List<CvDto> cvDtos(List<User> activeCv);


}