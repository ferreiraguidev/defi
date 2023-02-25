package com.example.defi.service;


import com.example.defi.batidas.Dia;
import com.example.defi.repository.DiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaService {

    private final DiaRepository diaRepository;

    public DiaService(DiaRepository diaRepository) {
        this.diaRepository = diaRepository;
    }

    public List<Dia> pontosDoDia() {
        return diaRepository.findAll();
    }
}
