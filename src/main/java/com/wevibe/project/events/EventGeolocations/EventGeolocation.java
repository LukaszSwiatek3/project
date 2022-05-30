package com.wevibe.project.events.EventGeolocations;

import com.wevibe.project.addresses.Address;
import com.wevibe.project.events.Event;
import com.wevibe.project.geolocation.GeocoderMapbox;
import com.wevibe.project.tags.Tag;
import com.wevibe.project.users.userdetails.UserDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventGeolocation extends Event {

    public List<Double> coordinates = new ArrayList<>();

    public EventGeolocation() {
        this.coordinates = coordinates;
    }

    public EventGeolocation(Long idEvent, List<Double> coordinates) {
        super(idEvent);
        this.coordinates = coordinates;
    }

    public EventGeolocation(String nameEvent, String startDateEvent, String endDateEvent, Address eventAddress, UserDetails organisator, Integer limitOfParticipants, List<UserDetails> participants, List<Tag> tags, String description, List<Double> coordinates) {
        super(nameEvent, startDateEvent, endDateEvent, eventAddress, organisator, limitOfParticipants, participants, tags, description);
        this.coordinates = coordinates;
    }

    public EventGeolocation(Long idEvent, String nameEvent, String startDateEvent, String endDateEvent, Address eventAddress, UserDetails organisator, Integer limitOfParticipants, List<UserDetails> participants, List<Tag> tags, String description, List<Double> coordinates) {
        super(idEvent, nameEvent, startDateEvent, endDateEvent, eventAddress, organisator, limitOfParticipants, participants, tags, description);
        this.coordinates = coordinates;
    }

    public List<Double> getCoordinates(Event event) throws IOException {
        String address = event.getEventAddress().toString();
        GeocoderMapbox geocoderMapbox = new GeocoderMapbox();
        return geocoderMapbox.getGeolocation(address);
    }

    public String getAddress(Event event) throws IOException {
        String address = event.getEventAddress().toString();
        return address;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }


}
