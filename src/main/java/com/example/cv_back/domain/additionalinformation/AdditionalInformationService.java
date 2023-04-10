package com.example.cv_back.domain.additionalinformation;

import com.example.cv_back.domain.entity.AdditionalInformation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalInformationService {

    @Resource
    private AdditionalInformationRepository additionalInformationRepository;
    public List<AdditionalInformation> getAdditionalInfo(Integer userId) {
        List<AdditionalInformation> additionalInformation = additionalInformationRepository.findAdditionalInformation(userId);
        return additionalInformation;
    }
}
