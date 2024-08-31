package com.hosptal.Healthcare.Management.System.service;


import com.hosptal.Healthcare.Management.System.model.User;
import com.hosptal.Healthcare.Management.System.model.UserPrincipal;
import com.hosptal.Healthcare.Management.System.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);

    }
}
