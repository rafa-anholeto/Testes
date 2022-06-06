package com.br.raf.fipe.DTO;

import com.br.raf.fipe.entities.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class CarDTORequest {
    public CarDTORequest() {
    }

    public Car toCar(UUID modelId, double precoFipe ) {
        return new Car(placa,announcePrice, year, modelId, precoFipe, LocalDate.now());
    }

    public CarDTORequest(String placa, int idModelo, int idMarca, double announcePrice, int year) {
        this.placa = placa;
        this.idModelo = idModelo;
        this.idMarca = idMarca;
        this.announcePrice = announcePrice;
        this.year = year;
    }

    public CarDTORequest(String placa, int idModelo, double announcePrice, int year) {
        this(placa, idModelo,0,announcePrice,year);
    }

    private String placa;
    @JsonProperty("modelo")
    private int idModelo;
    @JsonProperty("marca")
    private int idMarca;
    @JsonProperty("preco_anuncio")
    private double announcePrice;
    @JsonProperty("ano")
    private int year;
}
