package com.example.cv_back.cv.workplace;

import lombok.Data;

@Data
public class PositionDto {
    private  Integer positionId;
    private String positionName;
    private String positionStartDate;
    private String positionEndDate;
    private String positionDescription;

}
