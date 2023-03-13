package com.example.cv_back.cv.CV;

import com.example.cv_back.domain.Cv;
import com.example.cv_back.domain.cvs.CvMapper;
import com.example.cv_back.domain.cvs.CvsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CvService {

    @Resource
    private CvsService cvsService;
    @Resource
    private CvMapper cvMapper;
    public CvDto cv(Integer userId) {
        Cv cv = cvsService.findCv(userId);
        CvDto cvDto = cvMapper.toDto(cv);
        return cvDto;
    }
}
