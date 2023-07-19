package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Appointment;
import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Appointment getById(Integer app_id);

    void deleteAppointmentById(Integer id);

    List<Appointment> findAppointmentByPatientEmail(String email);
    List<Appointment> findAppointmentsByUserEmail(String email);

    List<Appointment> findByDate(LocalDate date);
//    List<Appointment> findByUserAndStartTimeBetween(User user, LocalDate date, LocalTime time);

}