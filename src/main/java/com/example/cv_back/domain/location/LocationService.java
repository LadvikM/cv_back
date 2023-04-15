package com.example.cv_back.domain.location;

import com.example.cv_back.domain.entity.Location;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;


    public void saveLocation(Location location) {
        locationRepository.save(location);

    }

    public Optional<Location> findLocation(String cityName, String countryName) {
        Optional<Location> location = locationRepository.findLocation(cityName, countryName);

        return location;
    }
}
