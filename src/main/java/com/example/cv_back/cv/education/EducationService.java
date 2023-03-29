package com.example.cv_back.cv.education;

import com.example.cv_back.domain.entity.School;
import com.example.cv_back.domain.entity.Subject;
import com.example.cv_back.domain.school.SchoolMapper;
import com.example.cv_back.domain.school.SchoolService;
import com.example.cv_back.domain.subject.SubjectMapper;
import com.example.cv_back.domain.subject.SubjectService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Resource
    private SchoolMapper schoolMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private SchoolService schoolService;
    @Resource
    private SubjectService subjectService;

    public List<SchoolDto> getEducation(Integer userId) {
        List<School> schools = schoolService.getSchools(userId);
        List<SchoolDto> schoolDtos = schoolMapper.toDtos(schools);
        for (SchoolDto schoolDto : schoolDtos) {
            List<Subject> subjects = subjectService.findSubjects(schoolDto.getSchoolId());
            List<SubjectsDto> toDtos = subjectMapper.toDtos(subjects);
            schoolDto.setSubjects(toDtos);
        }
        return schoolDtos;

    }
}
