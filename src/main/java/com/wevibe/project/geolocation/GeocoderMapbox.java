package com.wevibe.project.geolocation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wevibe.project.geolocation.models.Example;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.util.List;

public class GeocoderMapbox {

    private static final String GEOCODING_RESOURCE = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    private static final String API_KEY = "pk.eyJ1IjoibHN3aWF0ZWsiLCJhIjoiY2wyenk4aHRuMGVtODNpbXVqYmNzd3l6MSJ9.6l7_jA9lDF-OdqwLShqCQw";

    public List<Double> getGeolocation(String query) throws IOException {
        HttpClient httpClient = HttpClient.newHttpClient();

        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        String requestUrl = GEOCODING_RESOURCE + encodedQuery + ".json?proximity=ip&types=address%2Cpostcode%2Ccountry&language=pl&access_token=" + API_KEY;
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Example example = mapper.readValue(responseStream, Example.class);
        List<Double> coordinates = example.getFeatures().get(0).getGeometry().getCoordinates();
        return coordinates;
    }
}
