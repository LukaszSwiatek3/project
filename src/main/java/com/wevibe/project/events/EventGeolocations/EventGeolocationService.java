package com.wevibe.project.events.EventGeolocations;

import com.wevibe.project.addresses.Address;
import com.wevibe.project.addresses.AddressRepository;
import com.wevibe.project.events.Event;
import com.wevibe.project.events.EventRepository;
import com.wevibe.project.geolocation.GeocoderMapbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/geolocation")
public class EventGeolocationService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/address")
    public List<List<Double>> getAll() throws IOException {
        GeocoderMapbox geocoderMapbox = new GeocoderMapbox();
        List<Address> addresses = addressRepository.getAddressesForEvent();
        List<List<Double>> coordinates = new ArrayList<>();
        for(Address address : addresses){

            coordinates.add(geocoderMapbox.getGeolocation(address.toString()));

        }
        return coordinates;
    }

//    @GetMapping("/address")
//    public List<EventGeolocation> getAllCoordinates() throws IOException {
//        GeocoderMapbox geocoderMapbox = new GeocoderMapbox();
//        List<Address> addresses = addressRepository.getAddressesForEvent();
//        List<EventGeolocation> eventGeolocations = new ArrayList<>();
//        List<Event> events = eventRepository.getAllNotNull();
//        for(Event event : events){
//            eventGeolocations.add(
//                    new EventGeolocation(event.getIdEvent(),
//                    geocoderMapbox.getGeolocation(addressRepository.getAddressesForEvent().toString())));
//        }
//        return eventGeolocations;
//    }

//    @GetMapping("/address")
//    public List<EventGeolocation> getAllCoordinates() throws IOException {
//        return eventRepository.getAllNotNull();
//    }

    @GetMapping("address/{id}")
    public EventGeolocation getCoordinates(@PathVariable("id") Long id)  throws IOException {
        GeocoderMapbox geocoderMapbox = new GeocoderMapbox();
        EventGeolocation eventGeolocation = new EventGeolocation(eventRepository.getEventById(id).getIdEvent(),
                geocoderMapbox.getGeolocation(addressRepository.getAddressForEvent(id).toString()));
        return eventGeolocation;

    }


}
