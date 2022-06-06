package com.br.raf.fipe;

import com.br.raf.fipe.controller.CarController;
import com.br.raf.fipe.repository.CarRepository;
import com.br.raf.fipe.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.br.raf.fipe.controller", "com.br.raf.fipe.service", "com.br.raf.fipe.repository"})
public class FipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}



}
