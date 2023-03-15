package com.example.cv_back.domain.position;

import com.example.cv_back.domain.entity.Position;
import com.example.cv_back.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Resource
    private PositionRepository positionRepository;


    public List<Position> findPositions(Integer companyId) {
        List<Position> positions = positionRepository.findPositions(companyId);
        Validator.checkPositionEntries(positions);
        return positions;
    }
}
