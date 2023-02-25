package com.example.defi.service;


import com.example.defi.batidas.Batidas;
import com.example.defi.batidas.DTO.BatidasPostReqBody;
import com.example.defi.batidas.DTO.BatidasRespBody;
import com.example.defi.repository.BatidasRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatidasService {

    private final BatidasRepository batidasRepository;

    public BatidasService(BatidasRepository batidasRepository) {
        this.batidasRepository = batidasRepository;
    }


    public List<Batidas> batidas() {
        return batidasRepository.findAll();
    }

    public BatidasRespBody registrarHorario(final BatidasPostReqBody reqBody) {

        var batidasEncontradas = batidasRepository.findById(LocalDate.now())
                .orElse(null);

        if (batidasEncontradas == null) {
            return converte(batidasRepository.save(Batidas.builder()
                    .dia(LocalDate.now())
                    .hora1(reqBody.getDataHora())
                    .build()));
        }

        if (batidasEncontradas.getHora2() == null) {
            batidasEncontradas.setHora2(reqBody.getDataHora());
            return converte(batidasRepository.save(batidasEncontradas));
        }

        if (batidasEncontradas.getHora3() == null) {
            batidasEncontradas.setHora3(reqBody.getDataHora());
            return converte(batidasRepository.save(batidasEncontradas));
        }

        if (batidasEncontradas.getHora4() == reqBody.getDataHora()) {
            batidasEncontradas.setHora4(reqBody.getDataHora());
            return converte(batidasRepository.save(batidasEncontradas));
        }

        if (batidasEncontradas.getHora1().equals(reqBody.getDataHora())) {
            throw new IllegalArgumentException("Apenas 4 horários podem ser registrados por dia");
        }

        if (batidasEncontradas.getHora2().equals(reqBody.getDataHora())) {
            throw new IllegalArgumentException("Apenas 4 horários podem ser registrados por dia");
        }

        if (batidasEncontradas.getHora3().equals(reqBody.getDataHora())) {
            throw new IllegalArgumentException("Apenas 4 horários podem ser registrados por dia");
        }

        if (batidasEncontradas.getHora4().equals(reqBody.getDataHora())) {
            throw new IllegalArgumentException("Apenas 4 horários podem ser registrados por dia");
        }

        return null;
    }

    public BatidasRespBody converte(final Batidas batidas) {

        var listaDeHoras = new ArrayList<LocalTime>();

        listaDeHoras.add(batidas.getHora1() != null ? batidas.getHora1().toLocalTime() : null);
        listaDeHoras.add(batidas.getHora2() != null ? batidas.getHora2().toLocalTime() : null);
        listaDeHoras.add(batidas.getHora3() != null ? batidas.getHora3().toLocalTime() : null);
        listaDeHoras.add(batidas.getHora4() != null ? batidas.getHora4().toLocalTime() : null);

        return BatidasRespBody.builder()
                .dia(batidas.getDia())
                .batidas(listaDeHoras)
                .build();
    }

    public BatidasRespBody jaRegistrado(final BatidasPostReqBody batidas) {

        var batidasEncontradas = batidasRepository.findById(LocalDate.now())
                .orElse(null);

        assert batidasEncontradas != null;
        if (batidasEncontradas.getHora4() == batidas.getDataHora()) {

            if (batidasEncontradas.getHora4() == null) {
                batidasEncontradas.setHora4(batidas.getDataHora());

                return converte(batidasRepository.save(batidasEncontradas));
            }
            throw new IllegalArgumentException("MASDIOPSAJKDOPIAJIODPJOIAD");
        }

        return null;

    }
}

