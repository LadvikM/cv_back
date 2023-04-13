package com.example.cv_back.domain.hobby;

import com.example.cv_back.domain.entity.Hobby;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    @Resource
    private HobbyRepository hobbyRepository;

    public List<Hobby> getHobbies(Integer userId) {
        List<Hobby> hobbies = hobbyRepository.findHobbies(userId);
        return hobbies;
    }
}
