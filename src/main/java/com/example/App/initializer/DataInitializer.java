package com.example.App.initializer;

import com.example.App.entities.Rol;
import com.example.App.services.RolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolService rolService;

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
        if (rolService.existsById(rol1.getId_rol())) {
            rolService.guardarRol(rol1);
        }
        if (rolService.existsById(rol2.getId_rol())) {
            rolService.guardarRol(rol2);
        }
        if (rolService.existsById(rol3.getId_rol())) {
            rolService.guardarRol(rol3);
        }
        if (rolService.existsById(rol4.getId_rol())) {
            rolService.guardarRol(rol4);
        }
    }
}

