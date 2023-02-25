package com.example.defi.repository;

import com.example.defi.batidas.Batidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BatidasRepository extends JpaRepository<Batidas, LocalDate> {
    
}
