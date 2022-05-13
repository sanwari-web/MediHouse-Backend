package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {

    User getById(Integer id);

    void deleteUserById(Integer id);

    Optional<User> findUserById(Integer id);
}
