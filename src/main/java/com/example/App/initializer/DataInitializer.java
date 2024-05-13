package com.example.App.initializer;

import com.example.App.entities.Estado;
import com.example.App.entities.Rol;
import com.example.App.entities.TipoRequerimiento;
import com.example.App.services.EstadoService;
import com.example.App.services.RolService;
import com.example.App.services.TipoRequerimientoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RolService rolService;
    private final EstadoService estadoService;
    private final TipoRequerimientoService tipoRequerimientoService;

    @Override
    public void run(String... args) throws Exception {

        // Crear roles por defecto
        Rol rol1 = new Rol(0, "admin", "Rol con permisos de administrador");
        Rol rol2 = new Rol(1, "rector", "Rol con permisos de rector");
        Rol rol3 = new Rol(2, "logistico", "Rol con permisos de logistico");
        Rol rol4 = new Rol(3, "operativo", "Rol con permisos de opertaivo");

        // Guardar los roles
        existOrSaveRol(rol1);
        existOrSaveRol(rol2);
        existOrSaveRol(rol3);
        existOrSaveRol(rol4);

        // ------ReqStates------

        Estado estado1 = new Estado(0L, "papelera");
        Estado estado2 = new Estado(1L,"borrador");
        Estado estado3 = new Estado(2L, "archivado");
        Estado estado4 = new Estado(3L, "enviado");
        Estado estado5 = new Estado(4L, "aprobado");
        Estado estado6 = new Estado(5L, "rechazado");
        Estado estado7 = new Estado(6L, "cotizado");
        Estado estado8 = new Estado(7L, "para comprar");

        existOrSaveEstado(estado1);
        existOrSaveEstado(estado2);
        existOrSaveEstado(estado3);
        existOrSaveEstado(estado4);
        existOrSaveEstado(estado5);
        existOrSaveEstado(estado6);
        existOrSaveEstado(estado7);
        existOrSaveEstado(estado8);
        // ------reqTypes------

        TipoRequerimiento tipoRequerimiento1 = new TipoRequerimiento(0L, "Servicio", "Requerimiento para la compra de servicios") ;
        TipoRequerimiento tipoRequerimiento2 = new TipoRequerimiento(1L, "Producto", "Requerimiento para la compra de productos");
        TipoRequerimiento tipoRequerimiento3 = new TipoRequerimiento(2L, "Varios", "Requerimiento para la compra de varios productos o servicios");

        existOrSaveTipoRequerimiento(tipoRequerimiento1);
        existOrSaveTipoRequerimiento(tipoRequerimiento2);
        existOrSaveTipoRequerimiento(tipoRequerimiento3);
    }


    private void existOrSaveRol(Rol rol){
        if(rolService.existsById(rol.getId_rol())){
            rolService.guardarRol(rol);
        }
    }
    private void existOrSaveEstado(Estado estado){
        if(estadoService.existsById(estado.getId())){
            estadoService.guardarEstado(estado);
        }
    }
    private void existOrSaveTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        if (tipoRequerimientoService.existsById(tipoRequerimiento.getId_tipo_requerimiento())) {
            tipoRequerimientoService.guardarTipoRequerimiento(tipoRequerimiento);
        }
    }
}

