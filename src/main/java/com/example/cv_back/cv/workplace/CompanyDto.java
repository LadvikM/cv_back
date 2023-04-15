package com.example.cv_back.cv.workplace;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {

    private String companyName;
    private Integer companyId;
    private String cityName;
    private String countryName;
    private List<PositionDto> positions;
}
