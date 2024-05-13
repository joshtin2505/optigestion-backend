package com.example.App.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tipo_requerimiento")
public class TipoRequerimiento {
    @Id
    @Column(name = "id_tipo_requerimiento")
    private Long id_tipo_requerimiento;
    private String Titulo;
    private String Descripcion;

    public TipoRequerimiento(int  id_tipo_requerimiento){
        this.id_tipo_requerimiento = (long) id_tipo_requerimiento;
    }

}
