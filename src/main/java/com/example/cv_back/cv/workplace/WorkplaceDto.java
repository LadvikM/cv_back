package com.example.cv_back.cv.workplace;

import lombok.Data;

import java.util.List;

@Data
public class WorkplaceDto {
    private String workplaceName;
    private String countryName;
    private String cityName;
    private String positionId;
    private List<PositionDto> positions;

}
