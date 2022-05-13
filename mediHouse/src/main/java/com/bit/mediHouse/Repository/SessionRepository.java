package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SessionRepository  extends JpaRepository<Session,Integer> {


    Session getById(Integer session_id);
    // void deleteById(Integer id);
//
   // Optional<Session> findSessionById(Integer session_id);
}
