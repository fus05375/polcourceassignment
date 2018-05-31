package com.example.polcourceassignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tag_id", nullable=false)
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @ManyToMany
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Set<Note> notes;


    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
