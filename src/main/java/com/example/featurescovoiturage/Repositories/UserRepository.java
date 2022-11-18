package com.example.featurescovoiturage.Repositories;

import com.example.featurescovoiturage.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

}
