package com.example.cv_back.domain.additionalinformation;

import com.example.cv_back.domain.entity.AdditionalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalInformationRepository extends JpaRepository<AdditionalInformation, Integer> {
    @Query("select a from AdditionalInformation a where a.user.id = ?1")
    List<AdditionalInformation> findAdditionalInformation(Integer userId);

}