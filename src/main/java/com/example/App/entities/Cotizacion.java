package com.example.app.entities;

import com.example.App.entities.Requerimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cotizacion;
    @Column(name = "pdf_path")
    private String pdfPath;
    @ManyToOne
    @JoinColumn(name = "id_requerimiento")
    private Requerimento requerimiento;
 
}
