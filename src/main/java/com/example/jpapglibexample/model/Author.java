package com.example.jpapglibexample.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "family_name")
    private String family_name;

    @Column(name = "date_of_birth")
    private LocalDateTime date_of_birth;

    @Column(name = "date_of_death")
    private LocalDateTime date_of_death;

    public Author() {}

    public Author(String first_name, String family_name, LocalDateTime date_of_birth, LocalDateTime date_of_death) {
        this.first_name = first_name;
        this.family_name = family_name;
        this.date_of_birth = date_of_birth;
        this.date_of_death = date_of_death;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public LocalDateTime getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDateTime date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public LocalDateTime getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_death(LocalDateTime date_of_death) {
        this.date_of_death = date_of_death;
    }
}
