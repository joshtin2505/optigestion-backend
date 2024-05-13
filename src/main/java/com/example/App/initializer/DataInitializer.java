package com.example.App.initializer;

import com.example.App.entities.Estado;
import com.example.App.entities.Rol;
import com.example.App.services.EstadoService;
import com.example.App.services.RolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolService rolService;
    private EstadoService estadoService;

    public DataInitializer(RolService rolService) {
        this.rolService = rolService;
    }

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

        Estado estado1 = new Estado(0, "papelera");
        Estado estado2 = new Estado(1,"borrador");
        Estado estado3 = new Estado(2, "archivado");
        Estado estado4 = new Estado(3, "enviado");
        Estado estado5 = new Estado(4, "aprobado");
        Estado estado6 = new Estado(5, "rechazado");
        Estado estado7 = new Estado(6, "cotizado");
        Estado estado8 = new Estado(7, "para comprar");

        existOrSaveEstado(estado1);
        existOrSaveEstado(estado2);
        existOrSaveEstado(estado3);
        existOrSaveEstado(estado4);
        existOrSaveEstado(estado5);
        existOrSaveEstado(estado6);
        existOrSaveEstado(estado7);
        existOrSaveEstado(estado8);
    }

    public void existOrSaveRol(Rol rol){
        if(rolService.existsById(rol.getId_rol())){
            rolService.guardarRol(rol);
        }
    }
    public void existOrSaveEstado(Estado estado){
        if(estadoService.existsById(estado.getId_estado())){
            estadoService.guardarEstado(estado);
        }
    }
}

