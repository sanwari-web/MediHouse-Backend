package com.bit.mediHouse.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "date")
    private LocalDate date;

//    @Column(name = "endTime")
//    private LocalDateTime endTime;

    @Column(name = "note")
    private String note;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "patient_id", nullable = false)
    private User patient;

    @ManyToOne( optional = false, targetEntity = User.class)
    @JoinColumn(name = "consult_id", nullable = false)
    private User user;
    // getters and setters

    public Appointment(LocalTime time, User user, User patient, LocalDate date, String note) {


        this.patient  =  patient;
        this.user  =  user;
        this.time = time;
        this.date = date;
        this.note = note;
    }

    public Appointment() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User  getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", user ='" + user + '\'' +
                ", patient='" + patient + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

