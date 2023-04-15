package com.example.cv_back.domain.location;

import com.example.cv_back.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.city = ?1 and l.country = ?2")
    Optional<Location> findLocation(String city, String country);



}