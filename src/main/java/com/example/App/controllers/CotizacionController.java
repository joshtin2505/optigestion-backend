/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.controllers;



import com.example.App.entities.Requerimento;
import com.example.App.services.ArchivoService;
import com.example.App.services.CotizacionService;
import com.example.App.services.EstadoService;
import com.example.App.services.RequerimentoService;
import com.example.app.entities.Cotizacion;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("api/cotizacion")
public class CotizacionController {
    @Autowired
    private CotizacionService cotizacionService;

    @Autowired
    private ArchivoService archivoService;

    @Autowired
    private RequerimentoService requerimientoService;

    @Autowired
    private EstadoService estadoService;


    @PutMapping(value = "/send-cotizacion/{idRequerimiento}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public List<?> pdftest(@RequestPart("file") MultipartFile[] file, @PathVariable int idRequerimiento) {
        Optional<Requerimento> requerimento = requerimientoService.obtenerRequerimentoPorId((long) idRequerimiento);
        if (requerimento.isEmpty()) {
            return List.of("Requerimiento no encontrado");
        }
        List<Cotizacion> nuevasCotizaciones = Arrays.stream(file).map(files -> {
            Cotizacion cotizacion = new Cotizacion();

            String pdfPath =  archivoService.savePdf(files);

            cotizacion.setPdfPath(pdfPath);
            cotizacion.setRequerimiento(requerimento.get());
            Cotizacion nuevaCotizacion = cotizacionService.create(cotizacion);

            Requerimento requerimentoActualizado = requerimento.get();
            requerimentoActualizado.setEstado(estadoService.obtenerEstadoPorId(6L).get());
            requerimientoService.actualizarRequerimento(requerimento.get().getId_requerimeinto(), requerimentoActualizado );
            return nuevaCotizacion;
        }).toList();
        System.out.println(nuevasCotizaciones);
        return nuevasCotizaciones;
    }


    // Endpoint para obtener todos las cotizaciones
    @GetMapping
    private ResponseEntity<List<Cotizacion>> obtenerTodosLasCotizaciones() {
        List<Cotizacion> cotizacion = cotizacionService.obtenerTodosLasCotizaciones();
        return new ResponseEntity<>(cotizacion, HttpStatus.OK);
    }
    
    // Endpoint para obtener un cliente por su código
    @GetMapping("/{id_cotizacion}")
    private ResponseEntity<Cotizacion> obtenerCotizacionPorCodigo(@PathVariable int id_cotizacion) {
        return cotizacionService.obtenerCotizacionPorCodigo(id_cotizacion)
                .map(cotizacion -> new ResponseEntity<>(cotizacion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    private ResponseEntity<Cotizacion> guardar (@RequestBody Cotizacion cotizacion){
        Cotizacion temporal = cotizacionService.create(cotizacion);
        
        try {
            return ResponseEntity.created(new URI("api/cotizacion/" + temporal.getId_cotizacion())).body(temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    // Endpoint para actualizar un cliente existente
    @PutMapping("/{id_cotizacion}")
    private ResponseEntity<Cotizacion> actualizarCotizacion(@PathVariable int id_cotizacion, @RequestBody Cotizacion cotizacion) {
        Cotizacion cotizacionActualizado = cotizacionService.actualizarCotizacion(id_cotizacion, cotizacion);
        return new ResponseEntity<>(cotizacionActualizado, HttpStatus.OK);
    }
    // Endpoint para eliminar un cliente por su código
    @DeleteMapping("/{id_cotizacion}")
    public ResponseEntity<Void> eliminarCotizacionPorCodigo(@PathVariable int id_cotizacion) {
        cotizacionService.deleteByCodigo(id_cotizacion);
        return ResponseEntity.ok().build();
    
    }

    
}
