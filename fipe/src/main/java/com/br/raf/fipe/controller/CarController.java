package com.br.raf.fipe.controller;

import com.br.raf.fipe.DTO.CarDTORequest;
import com.br.raf.fipe.DTO.CarDTOResponse;
import com.br.raf.fipe.entities.Car;
import com.br.raf.fipe.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{placa}")
    public ResponseEntity<CarDTOResponse> find(@PathVariable(value = "placa") String placa){
        CarDTOResponse carDTOResponse =  carService.find(placa);
        return new ResponseEntity<CarDTOResponse>(carDTOResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDTOResponse> createCar(@RequestBody CarDTORequest carDTORequest){
        CarDTOResponse carDTOResponse =  carService.createCar(carDTORequest);
        return new ResponseEntity<CarDTOResponse>(carDTOResponse, HttpStatus.CREATED);
    }
}
