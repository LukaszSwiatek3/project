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

    @GetMapping("/map")
    public List<Double> mapboxGeocoding() throws IOException, InterruptedException {
        GeocoderMapbox geocoder = new GeocoderMapbox();
        String query = "łazienkowska 6A/ Warszawa Polska";
        return geocoder.getGeolocation(query);
    }

    @GetMapping("/map2")
    public List<Double> mapbox() throws IOException, InterruptedException {
        CoordinatesFromMapbox coordinates = new CoordinatesFromMapbox();

        String query = "łazienkowska 6A/ Warszawa Polska";
        return coordinates.getCoordinates();
    }

}
