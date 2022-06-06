package com.br.raf.fipe.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Marca {

    @Id
    private String id;

    private String name;

    @Column(name = "fipe_id", unique = true)
    private long fipeId;
}
