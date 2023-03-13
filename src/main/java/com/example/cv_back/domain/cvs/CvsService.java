package com.example.cv_back.domain.cvs;

import com.example.cv_back.domain.Cv;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvsService {
    @Resource
    private CvRepository cvRepository;
    public Cv findCv(Integer userId) {
        Optional<Cv> optionalCv = cvRepository.findCv(userId);
        Cv cv = optionalCv.get();
        return cv;

    }
}
