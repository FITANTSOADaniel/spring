package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<UserProjection>  findAllByDeleteMarkIsFalse();
    List<User> findByDeleteMarkIsFalse();
    List<User> findByDeleteMarkIsTrue();
}
