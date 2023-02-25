package com.example.defi.controller;


import com.example.defi.batidas.Dia;
import com.example.defi.service.DiaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("")
public class DiaController {

    private final DiaService diaService;


    public DiaController(DiaService diaService) {
        this.diaService = diaService;
    }

    @ResponseStatus(OK)
    @GetMapping("/registrados")
    public List<Dia> registradosNoDia() {
        return diaService.pontosDoDia();
    }
}
