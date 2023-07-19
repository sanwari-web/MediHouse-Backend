package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.Appointment;
import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.AppointmentService;
import com.bit.mediHouse.Services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointment/find")
    public ResponseEntity<List<Appointment>> getAllAppoinments() {
        List<Appointment> appointments = appointmentService.findAllAppointment();
        return new ResponseEntity <>(appointments, HttpStatus.OK);
    }


    @PostMapping("/appointment/add")
    public ResponseEntity <Appointment> addAppointment(@RequestBody Appointment appointment){
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        return new ResponseEntity <>(newAppointment, HttpStatus.CREATED);
    }

    @PostMapping("/appointment/update")
    public ResponseEntity <Appointment> updateAppointment(@RequestBody Appointment appointment){
        Appointment updateAppointment = appointmentService.updateAppointment (appointment);
        return new ResponseEntity <>(updateAppointment, HttpStatus.CREATED);
    }


    @GetMapping("/appointment/find/user/patient/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(@PathVariable("date")LocalDate date) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);
        return new ResponseEntity <>(appointments, HttpStatus.OK);
    }

    @GetMapping("/appointment/find/patient/{email}")
    public ResponseEntity<List<Appointment>> findAppointmentByPatientEmail(@PathVariable("email")String email) {
        List<Appointment> appointments = appointmentService.findAppointmentByPatientEmail(email);
        return new ResponseEntity <>(appointments, HttpStatus.OK);
    }

    @GetMapping("/appointment/find/user/{email}")
    public ResponseEntity<List<Appointment>> findAppointmentByUser_Email(@PathVariable("email")String email) {
        List<Appointment> appointments = appointmentService.findAppointmentsByUserEmail(email);
        return new ResponseEntity <>(appointments, HttpStatus.OK);
    }


    @Transactional
    @DeleteMapping("/appointment/delete/{id}")
    public ResponseEntity <?> deleteAppointmentById(@PathVariable("id")Integer id){
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }
//    @GetMapping("/appoinment/find/{app_id}/{start}/{end}")
//    public List getAppointmentsByUserAndDateRange(@PathVariable Integer app_id, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
//        User user = new User();
//        user.setId(Math.toIntExact(app_id));
//        return appointmentService.getAppointmentsByUserAndDateRange(user, start, end);
//    }


}
