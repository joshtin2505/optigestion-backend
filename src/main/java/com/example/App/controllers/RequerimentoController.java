package com.example.App.controllers;

import com.example.App.entities.Estado;
import com.example.App.entities.Requerimento;
import com.example.App.entities.TipoRequerimiento;
import com.example.App.entities.Usuario;
import com.example.App.services.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requerimentos")
public class RequerimentoController {
    private final RequerimentoService requerimentoService;
    private final EstadoService estadoService;
    private final UsuarioService usuarioService;
    private final TipoRequerimientoService tipoRequerimientoService;

    @Autowired
    public RequerimentoController(RequerimentoService requerimentoService, EstadoService estadoService, UsuarioService usuarioService, TipoRequerimientoService tipoRequerimientoService) {
        this.requerimentoService = requerimentoService;
        this.estadoService = estadoService;
        this.usuarioService = usuarioService;
        this.tipoRequerimientoService = tipoRequerimientoService;
    }

    // Endpoint para obtener todos los requerimentos
    @GetMapping
    private ResponseEntity<List<Requerimento>> obtenerTodosLosRequerimentos() {
        List<Requerimento> requerimentos = requerimentoService.obtenerTodosLosRequerimentos();
        if (requerimentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(requerimentos, HttpStatus.OK);
    }

    // Endpoint para obtener un requerimento por su ID
    @GetMapping("/{id}")
    private ResponseEntity<Requerimento> obtenerRequerimentoPorId(@PathVariable Long id) {
        return requerimentoService.obtenerRequerimentoPorId(id)
                .map(requerimento -> new ResponseEntity<>(requerimento, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para guardar un nuevo requerimento
    @PostMapping
    private ResponseEntity<Requerimento> guardarRequerimento(@RequestBody Requerimento requerimento) {
        // Obtener el estado por su ID
        Optional<Estado> estadoOptional = estadoService.obtenerEstadoPorId(requerimento.getEstado().getId());
        Optional<Usuario> usuarioOptional = usuarioService.findByid_Usuario(requerimento.getUsuario().getId_Usuario());
        Optional<TipoRequerimiento> tipoRequerimientoOptional = tipoRequerimientoService.obtenerTipoRequerimientoPorId(requerimento.getTipoRequerimiento().getId_tipo_requerimiento());

        if (estadoOptional.isPresent() && usuarioOptional.isPresent() && tipoRequerimientoOptional.isPresent()) {
            requerimento.setEstado(estadoOptional.get());
            requerimento.setUsuario(usuarioOptional.get());
            requerimento.setTipoRequerimiento(tipoRequerimientoOptional.get());

            Requerimento nuevoRequerimento = requerimentoService.guardarRequerimento(requerimento);

            try {
                return ResponseEntity.created(new URI("/api/requerimentos/" + nuevoRequerimento.getId_requerimeinto())).body(nuevoRequerimento);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Manejar el caso donde el estado no existe
        }
    }

    // Endpoint para actualizar un requerimento existente
    @PutMapping("/{id}")
    private ResponseEntity<Requerimento> actualizarRequerimento(@PathVariable Long id, @RequestBody Requerimento requerimento) {
        Requerimento requerimentoActualizado = requerimentoService.actualizarRequerimento(id, requerimento);
        return ResponseEntity.ok(requerimentoActualizado);
    }

    // Endpoint para eliminar un requerimento por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRequerimentoPorId(@PathVariable Long id) {
        requerimentoService.eliminarRequerimentoPorId(id);
        return ResponseEntity.ok().build();
    }

}
