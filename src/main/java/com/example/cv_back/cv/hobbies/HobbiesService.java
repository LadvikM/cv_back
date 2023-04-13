package com.example.cv_back.cv.hobbies;

import com.example.cv_back.domain.entity.Hobby;
import com.example.cv_back.domain.hobby.HobbyMapper;
import com.example.cv_back.domain.hobby.HobbyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbiesService {
@Resource
private HobbyService hobbyService;

@Resource
private HobbyMapper hobbyMapper;

    public List<HobbiesDto> getHobbies(Integer userId) {
        List<Hobby> hobbies = hobbyService.getHobbies(userId);
        List<HobbiesDto> hobbiesDtos = hobbyMapper.toDtos(hobbies);
        return hobbiesDtos;
    }
}
