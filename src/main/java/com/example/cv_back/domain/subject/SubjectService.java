package com.example.cv_back.domain.subject;

import com.example.cv_back.domain.entity.School;
import com.example.cv_back.domain.entity.Subject;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Resource
    private SubjectRepository subjectRepository;


    public List<Subject> findSubjects(Integer schoolId) {
        List<Subject> subjects = subjectRepository.findSubjects(schoolId);
        Validator.checkSubjectsEntries(subjects);
        return subjects;
    }
}
