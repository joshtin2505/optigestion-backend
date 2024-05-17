package com.example.App.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Requerimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_requerimeinto;
    private String titulo;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fecha_creacion;
    private String comentaio_rector;
    private String comentario_logistico;
    private String comentario_compra;
    private int opcion_elegida;
    @OneToOne
    @JoinColumn(name = "id_pdf")
    private PDF pdf;
    //private int id_usuario; // <- Esto esta mal debias haber hecho una relacion con la tabla usuario no establese una simple propiedad...
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    //private String tipo_requerimiento; // <--------Esta es la misma historia que la de arriba. Joa... Se supone que ya estaba completo el back
    @ManyToOne
    @JoinColumn(name = "id_tipo_requerimiento")
    private TipoRequerimiento tipoRequerimiento;
}
