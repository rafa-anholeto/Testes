package com.br.raf.fipe.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Modelo {
    @Id
    private UUID id;
    private String name;

    @Column(name = "fipe_id")
    private long fipeId;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

}
