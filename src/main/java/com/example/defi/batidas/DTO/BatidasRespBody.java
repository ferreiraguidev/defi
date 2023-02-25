package com.example.defi.batidas.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Builder
@Getter
@Setter
public class BatidasRespBody {
    private LocalDate dia;
    private List<LocalTime> batidas;




}
