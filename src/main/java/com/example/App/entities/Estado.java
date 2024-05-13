package com.example.App.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estado {
    @Id
    @Column(name = "id_estado")
    private Long id;
    private String descripcion;

    public Estado(int id) {
        this.id = (long) id;
    }
}
