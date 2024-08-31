package com.hosptal.Healthcare.Management.System.service;


import com.hosptal.Healthcare.Management.System.model.User;
import com.hosptal.Healthcare.Management.System.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);

    }
}
