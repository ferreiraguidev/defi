package com.example.defi.batidas.DTO;


import com.example.defi.batidas.Batidas;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiaPostReqBody {

    private List<Batidas> numeroBatidas;

}
