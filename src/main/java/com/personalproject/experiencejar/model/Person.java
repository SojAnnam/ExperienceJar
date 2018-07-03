package com.personalproject.experiencejar.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;


    @ManyToMany
    public  List<Jar> joinedJarList;


    public Person() {
    }

    public Person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    public List<Jar> getJoinedJarList() {
        return joinedJarList;
    }

    public void setJoinedJarList(List<Jar> joinedJarList) {
        this.joinedJarList = joinedJarList;
    }
}
