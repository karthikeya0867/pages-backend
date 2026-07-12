package com.karthikeya.pages.repository;

import com.karthikeya.pages.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);
}
