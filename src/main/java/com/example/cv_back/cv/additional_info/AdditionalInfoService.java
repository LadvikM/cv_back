package com.example.cv_back.cv.additional_info;

import com.example.cv_back.domain.additionalinformation.AdditionalInformationMapper;
import com.example.cv_back.domain.additionalinformation.AdditionalInformationService;
import com.example.cv_back.domain.entity.AdditionalInformation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalInfoService {

    @Resource
    private AdditionalInformationService additionalInformationService;
    @Resource
    private AdditionalInformationMapper additionalInformationMapper;

    public List<AdditionalInfoDto> getAdditionalInfo(Integer userId) {
        List<AdditionalInformation> additionalInformation = additionalInformationService.getAdditionalInfo(userId);
        List<AdditionalInfoDto> additionalInfoDto = additionalInformationMapper.toDtos(additionalInformation);
        return additionalInfoDto;
    }
}
