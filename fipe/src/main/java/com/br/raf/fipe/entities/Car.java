package com.br.raf.fipe.entities;

import com.br.raf.fipe.DTO.CarDTORequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car {

    @Id
    private String placa;

    @Column(name = "preco_anuncio")
    private double announcePrice;

    @Column(name = "ano")
    private int year;

    @Column(name = "modelo_id")
    private UUID idModelo;

    @Column(name = "preco_fipe")
    private double precoFipe;

    @Column(name = "data_do_cadastro")
    private LocalDate dataDoCadastro;

    public Car(String placa, double announcePrice, int year, UUID idModelo, double precoFipe, LocalDate dataDoCadastro) {
        this.placa = placa;
        this.announcePrice = announcePrice;
        this.year = year;
        this.idModelo = idModelo;
        this.precoFipe = precoFipe;
        this.dataDoCadastro = dataDoCadastro;
    }

}
