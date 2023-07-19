package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Appointment;
import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Repository.AppointmentRepository;
import com.bit.mediHouse.Repository.SessionRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllAppointment() {
        return appointmentRepository.findAll();
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAppointmentByPatientEmail(String email) {
        return appointmentRepository.findAppointmentByPatientEmail(email);
    }

    public List<Appointment> findAppointmentsByUserEmail(String email) {
        return appointmentRepository.findAppointmentsByUserEmail(email);
    }


    public void deleteAppointmentById(Integer id){
        appointmentRepository.deleteAppointmentById(id);
    }
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByDate(date);
    }

//    public List<Appointment> getAppointmentsByUserAndDateRange(User user, LocalDate date, LocalTime time) {
//        return appointmentRepository.findByUserAndStartTimeBetween(user, date, time);
//    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
