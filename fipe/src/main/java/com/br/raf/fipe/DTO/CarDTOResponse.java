package com.br.raf.fipe.DTO;

import com.br.raf.fipe.entities.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class CarDTOResponse {
    public CarDTOResponse() {
    }

    public Car toCar(UUID id, double precoFipe ) {
        return new Car(placa,announcePrice, year, id, precoFipe, LocalDate.now());
    }


    public CarDTOResponse(String placa, String modelo, double precoFipe, double announcePrice, int year, LocalDate dataCadastro, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.precoFipe = precoFipe;
        this.announcePrice = announcePrice;
        this.year = year;
        this.dataCadastro = dataCadastro;
        this.marca = marca;
    }

    private String placa;
    private String modelo;
    @JsonProperty("preco_fipe")
    private double precoFipe;
    @JsonProperty("preco_anuncio")
    private double announcePrice;
    @JsonProperty("ano")
    private int year;
    @JsonProperty("data_cadastro")
    private LocalDate dataCadastro;
    private String marca;



}
