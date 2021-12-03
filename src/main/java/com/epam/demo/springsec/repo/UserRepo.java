package com.epam.demo.springsec.repo;

import com.epam.demo.springsec.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);
}
