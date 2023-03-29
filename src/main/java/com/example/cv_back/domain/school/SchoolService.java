package com.example.cv_back.domain.school;

import com.example.cv_back.domain.entity.School;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Resource
    private SchoolRepository schoolRepository;
    public List<School> getSchools(Integer userId) {
        List<School> schools = schoolRepository.findBySchools(userId);
        Validator.checkSchoolEntries(schools);
        return schools;
    }
}
