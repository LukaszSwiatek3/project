package com.wevibe.project.addresses;

import com.wevibe.project.events.Event;
import com.wevibe.project.users.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Long idAddress;
    @Column(name = "name_address", length = 45)
    private String nameAddress;
    @Column(name = "country", nullable = false, length = 45)
    private String country;
    @Column(name = "city", nullable = false, length = 45)
    private String city;
    @Column(name = "postal_code", nullable = false, length = 6)
    private String postalCode;
    @Column(name = "street", nullable = false, length = 45)
    private String street;
    @Column(name = "street_number", nullable = false)
    private String streetNumber;
    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @OneToMany(mappedBy = "eventAddress")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "userAddress")
    private List<UserDetails> users = new ArrayList<>();

    public Address() {
    }

    public Address(Long idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Long idAddress, String nameAddress, String country, String city, String postalCode, String street, String streetNumber, Integer apartmentNumber) {
        this.idAddress = idAddress;
        this.nameAddress = nameAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(Long idAddress, String nameAddress, String country, String city, String postalCode, String street, String streetNumber, Integer apartmentNumber, List<Event> events, List<UserDetails> users) {
        this.idAddress = idAddress;
        this.nameAddress = nameAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.events = events;
        this.users = users;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<UserDetails> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return street + " " + streetNumber + "/" + apartmentNumber + " " + city + " " + country;
    }
}

