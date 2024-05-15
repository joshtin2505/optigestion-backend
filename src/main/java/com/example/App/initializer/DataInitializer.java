package com.example.App.initializer;

import com.example.App.entities.*;
import com.example.App.services.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RolService rolService;
    private final EstadoService estadoService;
    private final TipoRequerimientoService tipoRequerimientoService;
    private final UsuarioService usuarioService;
    private final DepartamentoService departamentoService;

    @Override
    public void run(String... args) throws Exception {

        // Crear roles por defecto
        Rol rol1 = new Rol(0, "admin", "Rol con permisos de administrador");
        Rol rol2 = new Rol(1, "rector", "Rol con permisos de rector");
        Rol rol3 = new Rol(2, "logistico", "Rol con permisos de logistico");
        Rol rol4 = new Rol(3, "operativo", "Rol con permisos de opertaivo");

        List<Rol> roles = Arrays.asList(rol1, rol2, rol3, rol4);
        SaveRoles(roles);

        // ------ReqStates------
        Estado estado1 = new Estado(0L, "papelera");
        Estado estado2 = new Estado(1L, "borrador");
        Estado estado3 = new Estado(2L, "archivado");
        Estado estado4 = new Estado(3L, "enviado");
        Estado estado5 = new Estado(4L, "aprobado");
        Estado estado6 = new Estado(5L, "rechazado");
        Estado estado7 = new Estado(6L, "cotizado");
        Estado estado8 = new Estado(7L, "para comprar");

        List<Estado> estados = Arrays.asList(estado1, estado2, estado3, estado4, estado5, estado6, estado7, estado8);
        SaveEstados(estados);
        // ------reqTypes------

        TipoRequerimiento tipoRequerimiento1 = new TipoRequerimiento(0L, "Servicio", "Requerimiento para la compra de servicios");
        TipoRequerimiento tipoRequerimiento2 = new TipoRequerimiento(1L, "Producto", "Requerimiento para la compra de productos");
        TipoRequerimiento tipoRequerimiento3 = new TipoRequerimiento(2L, "Varios", "Requerimiento para la compra de varios productos o servicios");

        List<TipoRequerimiento> tiposRequerimiento = Arrays.asList(tipoRequerimiento1, tipoRequerimiento2, tipoRequerimiento3);
        SaveTipoRequerimientos(tiposRequerimiento);

        // ------Departamentos------

        Departamento departamento1 = new Departamento(1000L, "Reectoria", "Encargada de la rectoria del La institucion");
        Departamento departamento2 = new Departamento(1001L, "Logistica", "Encargada de la logistica de la institucion");
        Departamento departamento3 = new Departamento(1002L, "Operaciones", "Encargada de las operaciones de la institucion");
        Departamento departamento4 = new Departamento(1003L, "Tecnologia e Informacion", "Encargada de la tecnologia e informacion de la institucion");
        Departamento departamento5 = new Departamento(1004L, "Finanzas", "Encargada de las finanzas de la institucion");

        List<Departamento> departamentos = Arrays.asList(departamento1, departamento2, departamento3, departamento4, departamento5);
        SaveDepartamentos(departamentos);

        // ------Usuarios------
    /* Esto no se puede usar ya que la contraseña debe sr hasheada
            Usuario usuario1 = new Usuario(100L, "juan", "perez", "Adaministrador de Optigestion", "admin@admin.com", "admin", "admin", true, departamento4, rol1);
            Usuario usuario2 = new Usuario(101L, "pedro", "perez", "Rector de Optigestion", "pepe@pepe.com", "rector", "rector", true, departamento1, rol2);
            Usuario usuario3 = new Usuario(102L, "luis", "perez", "Logistico de Optigestion", "lupe@lupe.com", "logistico", "logistico", true, departamento2, rol3);
            Usuario usuario4 = new Usuario(103L, "maria", "perez", "Operativo de Optigestion", "mape.@mape.com", "operativo", "operativo", true, departamento3, rol4);

            List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4);
            SaveUsuarios(usuarios);
    */
    }

    /**
     * Save all the entities
     */

    // Save Roles methods
    private void existOrSaveRol(Rol rol) {
        if (rolService.existsById(rol.getId_rol())) {
            rolService.guardarRol(rol);
        }
    }

    private void SaveRoles(List<Rol> roles) {
        for (Rol rol : roles) {
            existOrSaveRol(rol);
        }
    }

    // Save Estados methods
    private void existOrSaveEstado(Estado estado) {
        if (estadoService.existsById(estado.getId())) {
            estadoService.guardarEstado(estado);
        }
    }

    private void SaveEstados(List<Estado> estados) {
        for (Estado estado : estados) {
            existOrSaveEstado(estado);
        }
    }

    // Save TipoRequerimientos methods
    private void existOrSaveTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        if (tipoRequerimientoService.existsById(tipoRequerimiento.getId_tipo_requerimiento())) {
            tipoRequerimientoService.guardarTipoRequerimiento(tipoRequerimiento);
        }
    }

    private void SaveTipoRequerimientos(List<TipoRequerimiento> tipoRequerimientos) {
        for (TipoRequerimiento tipoRequerimiento : tipoRequerimientos) {
            existOrSaveTipoRequerimiento(tipoRequerimiento);
        }
    }

    // Save Departamentos methods
    private void existOrSaveDepartamento(Departamento departamento) {
        if (departamentoService.existsById(departamento.getId())) {
            departamentoService.guardarDepartamento(departamento);
        }
    }

    private void SaveDepartamentos(List<Departamento> departamentos) {
        for (Departamento departamento : departamentos) {
            existOrSaveDepartamento(departamento);
        }
    }

    // Save Usuarios methods
    private void existOrSaveUsuario(Usuario usuario) {
        if (!usuarioService.existsById(usuario.getId_Usuario())) { // este lo invierto aqui para no hacerlo directamente en servicios
            usuarioService.create(usuario);
        }
    }

    private void SaveUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            existOrSaveUsuario(usuario);
        }
    }
}

