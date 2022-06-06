package com.br.raf.fipe.service;

import com.br.raf.fipe.DTO.CarDTORequest;
import com.br.raf.fipe.DTO.CarDTOResponse;
import com.br.raf.fipe.entities.Car;
import com.br.raf.fipe.entities.Modelo;
import com.br.raf.fipe.exceptions.ConflictException;
import com.br.raf.fipe.exceptions.NotFoundException;
import com.br.raf.fipe.model.Fipe;
import com.br.raf.fipe.repository.CarRepository;
import com.br.raf.fipe.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    private static Map<String,Fipe> mockapi;

    final CarRepository carRepository;
    final ModeloRepository modeloRepository;

    public CarService(CarRepository carRepository, ModeloRepository modeloRepository) {
        this.carRepository = carRepository;
        this.modeloRepository = modeloRepository;
    }

    static{
        // Key of mock = modelo_marca
        mockapi = Map.of("7027_21", new Fipe("e16e9ed4-43c6-4882-9f2f-12ca5aad6e7e", 30000),
                         "1027_22", new Fipe("b1c9a613-29ee-4171-a5ff-e7d98a0fdaac",45000));
    }

    public CarDTOResponse createCar(CarDTORequest carDTORequest){
        Optional<Car> optionalCar = carRepository.findById(carDTORequest.getPlaca());
        if(optionalCar.isPresent())
            throw new ConflictException("Já existe carro cadastrado com essa placa.");

        //chamada que deveria ser da api
        Fipe fipe = callApi(carDTORequest.getIdModelo(), carDTORequest.getIdMarca());
        if(fipe == null)
            throw new NotFoundException("Modelo ou marca não encontrado {marca =" + carDTORequest.getIdMarca() + ", modelo =" + carDTORequest.getIdModelo() +"}");

        Car car = carDTORequest.toCar(UUID.fromString(fipe.getId()), fipe.getTabelaFipe());

        Optional<Modelo> findById = modeloRepository.findById(car.getIdModelo());
        if(findById.isEmpty())
            throw new NotFoundException("Modelo não encontrado na base de dados {modelo =" + carDTORequest.getIdModelo() +"}");
        Modelo modelo = findById.get();
        car = carRepository.save(car);
        return new CarDTOResponse(car.getPlaca(), modelo.getName(),car.getPrecoFipe(), car.getAnnouncePrice(), car.getYear(), car.getDataDoCadastro(), modelo.getMarca().getName());
    }

    private Fipe callApi(int idModelo, int idMarca) {
        var key = idModelo + "_" + idMarca;
        return mockapi.get(key);
    }

    public CarDTOResponse find(String placa) {
        Optional<Car> optionalCar = carRepository.findById(placa);
        if(optionalCar.isEmpty())
            throw new NotFoundException("Carro não encontrado, PLACA: " + placa );
        Car car = optionalCar.get();
        Optional<Modelo> findById = modeloRepository.findById(car.getIdModelo());
        if(findById.isEmpty())
            throw new NotFoundException("Modelo não encontrado na base de dados {modelo =" + car.getIdModelo() +"}");
        Modelo modelo = findById.get();
        return new CarDTOResponse(car.getPlaca(), modelo.getName(),car.getPrecoFipe(), car.getAnnouncePrice(), car.getYear(), car.getDataDoCadastro(), modelo.getMarca().getName());
    }
}
