package com.example.defi.batidas;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Batidas {

    @Id
    private LocalDate dia;

    private LocalDateTime hora1;
    private LocalDateTime hora2;
    private LocalDateTime hora3;
    private LocalDateTime hora4;


}
