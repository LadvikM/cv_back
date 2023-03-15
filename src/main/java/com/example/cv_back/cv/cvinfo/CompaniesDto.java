package com.example.cv_back.cv.cvinfo;

import lombok.Data;

import java.util.List;

@Data
public class CompaniesDto {
private String companyName;
private List<PositionsDto> positions;

private String cityName;

private String countryName;
}
