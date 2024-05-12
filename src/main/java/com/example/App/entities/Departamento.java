package com.example.App.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    @Id
    @Column(name = "id_Departamento")
    private Long id;
    private String titulo;
    private String descripcion;
    public Departamento(int id) {
        this.id = (long) id;
    }
}
