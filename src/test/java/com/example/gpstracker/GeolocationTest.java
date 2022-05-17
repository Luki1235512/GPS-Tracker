package com.example.gpstracker;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.gpstracker.models.Geolocation;
import com.example.gpstracker.repositories.GeolocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class GeolocationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GeolocationRepository geolocationRepo;

    @Test
    void addValidLocation() {

        Geolocation geolocation = new Geolocation();
        geolocation.setLatitude("12.5");
        geolocation.setLongitude("52.1");
        geolocation.setDeviceID("1234");

        Geolocation savedLocation = geolocationRepo.save(geolocation);
        Geolocation existGeolocation = entityManager.find(Geolocation.class, savedLocation.getId());

        assertThat(geolocation.getDeviceID()).isEqualTo(existGeolocation.getDeviceID());
        assertThat(geolocation.getLatitude()).isEqualTo(existGeolocation.getLatitude());
        assertThat(geolocation.getLongitude()).isEqualTo(existGeolocation.getLongitude());

    }

}
