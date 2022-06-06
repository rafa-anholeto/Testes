package com.br.raf.fipe.repository;


import com.br.raf.fipe.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, UUID> {
}
