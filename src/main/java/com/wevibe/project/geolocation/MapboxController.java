package com.wevibe.project.geolocation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MapboxController {

    @GetMapping("/mapbox")
    public List<Double> coordinates() throws IOException {
        CoordinatesFromMapbox coordinatesFromMapbox = new CoordinatesFromMapbox();
        return coordinatesFromMapbox.getCoordinates();
    }

}
