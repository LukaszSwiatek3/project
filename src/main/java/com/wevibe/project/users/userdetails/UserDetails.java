package com.wevibe.project.users.userdetails;

import com.wevibe.project.addresses.Address;
import com.wevibe.project.events.Event;
import com.wevibe.project.opinions.Opinion;
import com.wevibe.project.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDetails extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_user")
    public Address userAddress;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "gender")
    private Boolean gender;
    @OneToMany(mappedBy = "organisator")
    private List<Event> organisedEvents = new ArrayList<>();
    @ManyToMany(mappedBy = "participants")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "opinionAuthor", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Opinion> opinions = new ArrayList<>();


    public UserDetails() {

    }

    public UserDetails(Long idUser) {
        super(idUser);
    }

    public UserDetails(String username, String email, String password, String roles, boolean active, String firstName, String lastName, Address userAddress, Integer phoneNumber, Boolean gender, List<Event> events, List<Event> organisedEvents, List<Opinion> opinions) {
        super(username, email, password, roles, active);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.events = events;
        this.organisedEvents = organisedEvents;
        this.opinions = opinions;
    }

    public UserDetails(Long idUser, String username, String email, String password, String roles, boolean active, String firstName, String lastName, Address userAddress, Integer phoneNumber, Boolean gender, List<Event> organisedEvents, List<Event> events, List<Opinion> opinions) {
        super(idUser, username, email, password, roles, active);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.organisedEvents = organisedEvents;
        this.events = events;
        this.opinions = opinions;
    }

    public UserDetails(String firstName, String lastName, Address userAddress, Integer phoneNumber, Boolean gender, List<Event> events, List<Event> organisedEvents, List<Opinion> opinions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.events = events;
        this.organisedEvents = organisedEvents;
        this.opinions = opinions;
    }

    public UserDetails(Long idUser, String firstName, String lastName, Address userAddress, Integer phoneNumber, Boolean gender, List<Event> organisedEvents, List<Event> events, List<Opinion> opinions) {
        super(idUser);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.organisedEvents = organisedEvents;
        this.events = events;
        this.opinions = opinions;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addOrganisedEvent(Event event) {organisedEvents.add(event);}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getOrganisedEvents() {
        return organisedEvents;
    }

    public void setOrganisedEvents(List<Event> organisedEvents) {
        this.organisedEvents = organisedEvents;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}