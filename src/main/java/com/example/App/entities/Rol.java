package com.example.App.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    private int id_rol;
    private String rol;
    private String descripcion;
    public Rol(int id) {
        this.id_rol = id;
    }
}
