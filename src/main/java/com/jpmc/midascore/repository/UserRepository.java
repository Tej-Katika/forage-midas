package com.jpmc.midascore.repository;

import com.jpmc.midascore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA automatically implements these methods:
    // - findById(Long id): Optional<User>
    // - save(User user): User
    // - findAll(): List<User>
    // - deleteById(Long id): void
    // - count(): long
    // - existsById(Long id): boolean

    // Custom query method (Spring generates implementation):
    Optional<User> findByUsername(String username);
}