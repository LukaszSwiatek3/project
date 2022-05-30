package com.wevibe.project.geolocation;

import com.wevibe.project.geolocation.models.Example;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CoordinatesFromMapbox {

    private final String url = "src\\main\\resources\\static\\json2.json";

    JsonInput jsonInput = new JsonInput();

    public List<Double> getCoordinates() throws IOException {
        Example example = jsonInput.parseFromJson(url);
        return example.getFeatures().get(0).getGeometry().getCoordinates();
    }

}
