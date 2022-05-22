package com.wevibe.project.opinions;

import com.wevibe.project.events.Event;
import com.wevibe.project.users.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_opinion")
    private Long idOpinion;
    @Column(name = "rating", nullable = false, length = 10)
    private Double rating;
    @Column(name = "description", length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "opinion_author", nullable = false)
    private UserDetails opinionAuthor;
    @Column(name = "opinion_time", nullable = false)
    private String opinionTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "opinion_event", nullable = false)
    private Event opinionEvent;

    public Opinion() {

    }

    public Opinion(Long idOpinion, Double rating, String description, UserDetails opinionAuthor, String opinionTime, Event opinionEvent) {
        this.idOpinion = idOpinion;
        this.rating = rating;
        this.description = description;
        this.opinionAuthor = opinionAuthor;
        this.opinionTime = opinionTime;
        this.opinionEvent = opinionEvent;
    }

    public Opinion(Double rating, String description, UserDetails opinionAuthor, String opinionTime, Event opinionEvent) {
        this.rating = rating;
        this.description = description;
        this.opinionAuthor = opinionAuthor;
        this.opinionTime = opinionTime;
        this.opinionEvent = opinionEvent;
    }

    public Long getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Long idOpinion) {
        this.idOpinion = idOpinion;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDetails getOpinionAuthor() {
        return opinionAuthor;
    }

    public void setOpinionAuthor(UserDetails opinionAuthor) {
        this.opinionAuthor = opinionAuthor;
    }

    public Event getOpinionEvent() {
        return opinionEvent;
    }

    public void setOpinionEvent(Event opinionEvent) {
        this.opinionEvent = opinionEvent;
    }

    public String getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(String opinionTime) {
        this.opinionTime = opinionTime;
    }

}
