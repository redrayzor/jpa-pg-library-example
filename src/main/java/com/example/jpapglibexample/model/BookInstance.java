package com.example.jpapglibexample.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookinstances")
public class BookInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book")
    private String book;

    @Column(name = "imprint")
    private String imprint;

    @Column(name = "status")
    private String status;

    @Column(name = "due_back")
    private LocalDateTime due_back;

    public BookInstance() {}

    public BookInstance(String book, String imprint, String status, LocalDateTime due_back) {
        this.book = book;
        this.imprint = imprint;
        this.status = status;
        this.due_back = due_back;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDue_back() {
        return due_back;
    }

    public void setDue_back(LocalDateTime due_back) {
        this.due_back = due_back;
    }
}
