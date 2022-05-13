package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Repository.PatientRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        // user.setId();
        return patientRepository.save(patient);
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Integer id) {
        return patientRepository.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public Patient findPatientBynic(String nic) {
        return patientRepository.findPatientBynic(nic).orElseThrow(() -> new UserNotFoundException("User by nic " + nic + " was not found"));
    }

    public void deletePatient(Integer id){
        patientRepository.deletePatientById(id);
    }

}
