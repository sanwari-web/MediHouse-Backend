package com.bit.mediHouse.Models;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "appointmentsTest")
public class AppointmentTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "a")
        private Integer startTime;

        @Column(name = "b")
        private Integer endTime;

        @Column(name = "c")
        private String note;

    public AppointmentTest(Integer id, Integer startTime, Integer endTime, String note) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
    }

    public AppointmentTest() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getstartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getendTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
