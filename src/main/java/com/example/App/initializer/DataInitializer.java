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
        rolService.guardarRol(rol1);
        rolService.guardarRol(rol2);
        rolService.guardarRol(rol3);
        rolService.guardarRol(rol4);
    }
}

