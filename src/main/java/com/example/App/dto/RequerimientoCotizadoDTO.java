package com.example.App.dto;

import com.example.App.entities.Estado;
import com.example.App.entities.TipoRequerimiento;
import com.example.App.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequerimientoCotizadoDTO {

    private Long id_requerimeinto;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private Usuario usuario;
    private TipoRequerimiento tipoRequerimiento;
    private List<Cotizaciondto> cotizacion;
    private LocalDateTime fecha_creacion;
    private String comentaio_rector;
    private String comentario_logistico;
    private String comentario_compra;
}
