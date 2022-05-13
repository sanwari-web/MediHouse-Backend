package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/find")
    public ResponseEntity <List<User>> getAllUser() {
        List<User> user = userService.findAllUser();
        return new ResponseEntity <>(user, HttpStatus.OK);
    }

    @GetMapping("/user/find/{id}")
    public ResponseEntity <User> getUserById(@PathVariable("id") Integer id){
        User user = userService.findUserById(id);
        return new ResponseEntity <>(user, HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity <User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity <>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/user/update")
    public ResponseEntity <User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity <>(updateUser, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity <?> deleteUser(@PathVariable("id") Integer id){
       userService.deleteUser(id);
        return new ResponseEntity <>(HttpStatus.OK);
    }


}
