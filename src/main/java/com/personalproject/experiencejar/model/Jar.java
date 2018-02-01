package com.personalproject.experiencejar.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Jar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;


    @Temporal(TemporalType.DATE)
    private Date startDate;

    @ManyToOne
    public Person ownerPerson;

    @ManyToMany
    public List<Person> joinedPerson;

    @OneToMany(mappedBy = "jar")
    public List<Experience> experienceList;

    public Jar() {
    }

    public Jar(String title, Date startDate, Person ownerPerson) {
        this.title = title;
        this.startDate = startDate;
        this.ownerPerson = ownerPerson;
    }

    public long getId() { return id;}

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Person getOwnerPerson() {
        return ownerPerson;
    }

    public void setOwnerPerson(Person ownerPerson) {
        this.ownerPerson = ownerPerson;
    }

    public List<Person> getJoinedPerson() {
        return joinedPerson;
    }

    public void setJoinedPerson(List<Person> joinedPerson) {
        this.joinedPerson = joinedPerson;
    }

    public List<Experience> getExperienceList() { return experienceList; }

    public void setExperienceList(List<Experience> experienceList) { this.experienceList = experienceList; }
}
