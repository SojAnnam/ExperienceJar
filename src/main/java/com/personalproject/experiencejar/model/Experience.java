package com.personalproject.experiencejar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String xpStory;

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @ManyToOne
    public Jar jar;

    public Experience() {
    }

    public Experience(String title, String xpStory, Date updateDate, Jar jar) {
        this.title = title;
        this.xpStory = xpStory;
        this.updateDate = updateDate;
        this.jar = jar;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getXpStory() { return xpStory; }

    public void setXpStory(String xpStory) { this.xpStory = xpStory; }

    public Date getUpdateDate() { return updateDate; }

    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }

    public Jar getJar() { return jar; }

    public void setJar(Jar jar) { this.jar = jar; }
}
