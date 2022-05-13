package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> findAllSession() {
        return sessionRepository.findAll();
    }

    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }


//    public List<Session> findSessionBySession_id(Integer session_id) {
//        return sessionRepository.findSessionBySession_id(session_id);
//    }

//    public void deletePatient(Integer id){
//        patientRepository.deletePatientById(id);
//    }

}
