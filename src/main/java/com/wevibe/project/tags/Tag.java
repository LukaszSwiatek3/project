package com.wevibe.project.tags;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tag")
    private Long idTag;
    @Column(name = "name_tag", nullable = false, length = 45)
    private String nameTag;
    @Column(name = "comment", nullable = false, length = 100)
    private String comment;

    public Tag() {

    }

    public Tag(Long idTag, String nameTag, String comment) {
        this.idTag = idTag;
        this.nameTag = nameTag;
        this.comment = comment;
    }

    public Tag(String nameTag, String comment) {
        this.nameTag = nameTag;
        this.comment = comment;
    }

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
