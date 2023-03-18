package com.example.cv_back.domain.user;

import com.example.cv_back.cv.AvailableCv.CvDto;
import com.example.cv_back.cv.users.dtos.UserInfoDto;
import com.example.cv_back.cv.users.dtos.UserDto;
import com.example.cv_back.cv.sidepanelinfo.SidepanelDto;
import com.example.cv_back.domain.entity.User;
import com.example.cv_back.util.PictureUtil;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface UserMapper {

    @Mapping(constant = "2", target = "role.id")
    @Mapping(source = "userDescription", target = "description")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    @Mapping(source = "cvStatus", target = "cvstatus")
    User toEntity(UserInfoDto newUserDto);

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
    @Mapping(expression = "java(PictureUtil.byteArrayToString(userInfo.getPicture()))", target = "picture")
    SidepanelDto userInfoDto(User userInfo);

    @Mapping(source = "id", target = "userId")
    CvDto cvDto(User activeCv);

    List<CvDto> cvDtos(List<User> activeCv);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    User editUser(@MappingTarget User user, UserInfoDto userInfoDto);


    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        return picture.getBytes(StandardCharsets.UTF_8);
    }


}