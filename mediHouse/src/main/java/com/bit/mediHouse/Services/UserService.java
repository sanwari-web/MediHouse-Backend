package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Repository.UserRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Slf4j
public class UserService implements UserDetailsService {



    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
       if (user== null){
           log.error("User not found");
           throw new UsernameNotFoundException("User not found");
       }else {
           log.info("Login Success! User found :{}",email);

       }
        Collection <SimpleGrantedAuthority>authorities = new ArrayList<>();

       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    public User addUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encrypt the user's password
        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        // Set the encrypted password back to the user object
        user.setPassword(encryptedPassword);

        // Save the user using the userRepository
        return userRepository.save(user);

    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }


    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by id " + email + " was not found"));
    }

    public void deleteUser(Integer id){
        userRepository.deleteUserById(id);
    }

    public User getuserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User getuserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public List<User> getusercountbygender() {
        return userRepository.getusercountbygender();
    }

    public List<User> getpatient() {
        return userRepository.getpatient();
    }

    public List<User> getdoctor() {
        return userRepository.getdoctor();
    }

    public User changePassword(Map<String,Object> user) {
        Map<String,Object> responseDTO = new HashMap<>();
        User userToSave = new User();
        Optional<User> dbUser = userRepository.findUserByEmail(user.get("email").toString());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       if(encoder.matches(user.get("currentPassword").toString(), dbUser.get().getPassword())){

             userToSave = setUserObj(user);
            userToSave.setPassword(encoder.encode(user.get("password").toString()));
           userRepository.save(userToSave);
           return userToSave;
        }else{
          return null;
        }

    }

    private User setUserObj(Map<String, Object> user) {
        User user1 = new User();
        user1.setGender(user.get("gender").toString());
        user1.setId(Integer.valueOf(user.get("id").toString()));
        user1.setFirst_name(user.get("first_name").toString());
        user1.setLast_name(user.get("last_name").toString());
        user1.setNic(user.get("nic").toString());
        user1.setEmail(user.get("email").toString());
        user1.setRole(user.get("role").toString());
        user1.setCity(user.get("city").toString());
        user1.setDistrict(user.get("district").toString());
        user1.setMobile(user.get("mobile").toString());
        user1.setDob(user.get("dob").toString());
        return user1;
    }
}
