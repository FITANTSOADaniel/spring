package com.example.demo.banque;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
//import java.util.Optional;

public interface BanqueRepository extends JpaRepository<Banque, Long> {
    // List<Banque> findByDeletedIsTrue();
    // Optional<Banque> findTopByOrderByIdDesc();
}
