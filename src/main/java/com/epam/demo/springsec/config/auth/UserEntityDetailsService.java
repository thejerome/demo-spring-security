package com.epam.demo.springsec.config.auth;

import com.epam.demo.springsec.entity.UserEntity;
import com.epam.demo.springsec.repo.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserEntityDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserEntityDetailsService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        try {
            UserEntity candidate = userRepo.findByUsername(username);

            if (candidate != null) {
                return User.withUsername(candidate.getUsername())
                        .password(candidate.getPassword())
                        .roles("USER")
                        .build();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }
}
