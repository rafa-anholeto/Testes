package com.br.raf.fipe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fipe {

    private String id;
    private double tabelaFipe;

    public Fipe(String id, double tabelaFipe) {
        this.id = id;
        this.tabelaFipe = tabelaFipe;
    }
}
