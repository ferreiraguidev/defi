package com.example.defi.batidas.DTO;


import com.example.defi.batidas.Batidas;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BatidasPostReqBody {

    // delete it?! seems to not working properly.
    private LocalDate dia;


    private LocalDateTime dataHora;
    private List<Batidas> batidas;
}
