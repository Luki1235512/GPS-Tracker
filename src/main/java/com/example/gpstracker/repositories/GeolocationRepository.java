package com.example.gpstracker.repositories;

import com.example.gpstracker.models.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {
}
