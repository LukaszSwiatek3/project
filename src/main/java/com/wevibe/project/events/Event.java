package com.wevibe.project.events;

import com.wevibe.project.addresses.Address;
import com.wevibe.project.opinions.Opinion;
import com.wevibe.project.tags.Tag;
import com.wevibe.project.users.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_event")
    private Long idEvent;

    @Column(name = "name_event", nullable = false, length = 45)
    private String nameEvent;

    @Column(name = "start_date_event", nullable = false, length = 45)
    private String startDateEvent;

    @Column(name = "end_date_event", length = 45)
    private String endDateEvent;

    @ManyToOne
    @JoinColumn(name = "event_address")
    private Address eventAddress;

    @ManyToOne
    @JoinColumn(name = "event_organisator")
    private UserDetails organisator;

    @Column(name = "limit_of_participants")
    private Integer limitOfParticipants;

    @ManyToMany
    @JoinTable(
            name = "events_users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserDetails> participants = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "events_tags",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    @Column(name = "description", length = 500)
    private String description;

    @OneToMany(mappedBy = "opinionEvent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private final List<Opinion> opinions = new ArrayList<>();

    public Event() {

    }

    public Event(Long idEvent) {
        this.idEvent = idEvent;
    }

    public Event(String nameEvent, String startDateEvent, String endDateEvent, Address eventAddress, UserDetails organisator, Integer limitOfParticipants, List<UserDetails> participants, List<Tag> tags, String description) {
        this.nameEvent = nameEvent;
        this.startDateEvent = startDateEvent;
        this.endDateEvent = endDateEvent;
        this.eventAddress = eventAddress;
        this.organisator = organisator;
        this.limitOfParticipants = limitOfParticipants;
        this.participants = participants;
        this.tags = tags;
        this.description = description;
    }

    public Event(Long idEvent, String nameEvent, String startDateEvent, String endDateEvent, Address eventAddress, UserDetails organisator, Integer limitOfParticipants, List<UserDetails> participants, List<Tag> tags, String description) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.startDateEvent = startDateEvent;
        this.endDateEvent = endDateEvent;
        this.eventAddress = eventAddress;
        this.organisator = organisator;
        this.limitOfParticipants = limitOfParticipants;
        this.participants = participants;
        this.tags = tags;
        this.description = description;
    }

    public void addParticipant(UserDetails participant){
        participants.add(participant);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }


    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getStartDateEvent() {
        return startDateEvent;
    }

    public void setStartDateEvent(String startDateEvent) {
        this.startDateEvent = startDateEvent;
    }

    public List<UserDetails> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserDetails> participants) {
        this.participants = participants;
    }

    public String getEndDateEvent() {
        return endDateEvent;
    }

    public void setEndDateEvent(String endDateEvent) {
        this.endDateEvent = endDateEvent;
    }

    public Address getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(Address eventAddress) {
        this.eventAddress = eventAddress;
    }

    public UserDetails getOrganisator() {
        return organisator;
    }

    public void setOrganisator(UserDetails organisator) {
        this.organisator = organisator;
    }

    public Integer getLimitOfParticipants() {
        return limitOfParticipants;
    }

    public void setLimitOfParticipants(Integer limitOfParticipants) {
        this.limitOfParticipants = limitOfParticipants;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
