package com.wevibe.project.events;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_event")
    private Long idEvent;

    @Column(name = "name_event", nullable = false, unique = false, length = 45)
    private String nameEvent;

    @Column(name = "start_date_event", nullable = false, unique = false, length = 45)
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
