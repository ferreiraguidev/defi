package com.example.defi.controller;


import com.example.defi.batidas.Batidas;
import com.example.defi.batidas.DTO.BatidasPostReqBody;
import com.example.defi.batidas.DTO.BatidasRespBody;
import com.example.defi.service.BatidasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/batidas")
public class BatidasController {

    private final BatidasService batidasService;

    public BatidasController(BatidasService batidasService) {
        this.batidasService = batidasService;
    }


    @ResponseStatus(OK)
    @PostMapping("/registrar")
    public BatidasRespBody registrar(@RequestBody final BatidasPostReqBody reqBody) {
        return batidasService.registrarHorario(reqBody);
    }

    @ResponseStatus(ACCEPTED)
    @GetMapping("/listar")
    public List<Batidas> listar() {
        return batidasService.batidas();
    }
}
