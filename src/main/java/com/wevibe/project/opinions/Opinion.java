package com.wevibe.project.opinions;

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
    @Column(name = "id_opinion_author", nullable = false)
    private Long idOpinionAuthor;
    @Column(name = "opinion_time", nullable = false)
    private String opinionTime;
    @Column(name = "id_event", nullable = false, length = 10)
    private Long idEvent;

    public Opinion() {

    }

    public Opinion(Long idOpinion, Double rating, String description, Long idOpinionAuthor, String opinionTime, Long idEvent) {
        this.idOpinion = idOpinion;
        this.rating = rating;
        this.description = description;
        this.idOpinionAuthor = idOpinionAuthor;
        this.opinionTime = opinionTime;
        this.idEvent = idEvent;
    }

    public Opinion(Double rating, String description, Long idOpinionAuthor, String opinionTime, Long idEvent) {
        this.rating = rating;
        this.description = description;
        this.idOpinionAuthor = idOpinionAuthor;
        this.opinionTime = opinionTime;
        this.idEvent = idEvent;
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

    public Long getIdOpinionAuthor() {
        return idOpinionAuthor;
    }

    public void setIdOpinionAuthor(Long idOpinionAuthor) {
        this.idOpinionAuthor = idOpinionAuthor;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(String opinionTime) {
        this.opinionTime = opinionTime;
    }

}
