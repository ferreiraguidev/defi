package com.example.defi.repository;

import com.example.defi.batidas.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}
