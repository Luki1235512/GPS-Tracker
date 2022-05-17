package com.example.gpstracker.controllers;

import com.example.gpstracker.models.Geolocation;
import com.example.gpstracker.repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GPSController {

    @Autowired
    private GeolocationRepository geoRepo;

    @GetMapping("")
    public String displayGPS(Model model) {

        List<Geolocation> listGeo = geoRepo.findAll();

        model.addAttribute("geo", new Geolocation());
        model.addAttribute("listGeo", listGeo);

        return "index";
    }

    @PostMapping("/process_location")
    public String processLocation(Geolocation geo) {

        geoRepo.save(geo);

        return "location_saved";
    }

}
