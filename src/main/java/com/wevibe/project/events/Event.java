package com.wevibe.project.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "idEvent")
    private Long idEvent;
    @Column(name = "name")
    private String nameEvent;
    @Column(name = "startDate")
    private String startDateEvent;

    public Event() {

    }

    public Event(Long idEvent, String nameEvent, String startDateEvent) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.startDateEvent = startDateEvent;
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
}
