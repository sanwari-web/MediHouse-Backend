package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping("/session/find")
    public ResponseEntity<List<Session>> getAllSession() {
        List<Session> session = sessionService.findAllSession();
        return new ResponseEntity <>(session, HttpStatus.OK);
    }

//    @GetMapping("/session/find/{session_id}")
//    public ResponseEntity <Session> findSessionBySession_id(@PathVariable("session_id") Integer session_id){
//        Session session = (Session) sessionService.findSessionBySession_id(session_id);
//        return new ResponseEntity <>(session, HttpStatus.OK);
//    }

    @PostMapping("/session/add")
    public ResponseEntity <Session> addSession(@RequestBody Session session){
        Session newSession = sessionService.addSession(session);
        return new ResponseEntity <>(newSession, HttpStatus.CREATED);
    }

    @PostMapping("/session/update")
    public ResponseEntity <Session> updateSession(@RequestBody Session session){
        Session updateSession = sessionService.updateSession (session);
        return new ResponseEntity <>(updateSession, HttpStatus.CREATED);
    }

//    @Transactional
//    @DeleteMapping("/user/delete/{id}")
//    public ResponseEntity <?> deleteUser(@PathVariable("id") Integer id){
//        userService.deleteUser(id);
//        return new ResponseEntity <>(HttpStatus.OK);
//    }
}
