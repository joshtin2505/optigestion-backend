/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.services;

import com.example.App.entities.Estado;
import com.example.App.entities.Requerimento;
import com.example.App.repositories.RequerimentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class RequerimentoService {
    private final RequerimentoRepository requerimentoRepository;
    private final EstadoService estadoService;

    @Autowired
    public RequerimentoService(RequerimentoRepository requerimentoRepository, EstadoService estadoService) {
        this.requerimentoRepository = requerimentoRepository;
        this.estadoService = estadoService;
    }

    // Método para obtener todos los requerimientos
    public List<Requerimento> obtenerTodosLosRequerimentos() {
        return requerimentoRepository.findAll();
    }

    // Método para obtener un requerimiento por su ID
    public Optional<Requerimento> obtenerRequerimentoPorId(Long id) {
        return requerimentoRepository.findById(id);
    }
    
    // Método para guardar un nuevo requerimiento
    public Requerimento guardarRequerimento(Requerimento requerimento) {
        return requerimentoRepository.save(requerimento);
    }

    // Método para actualizar un requerimiento existente
    public Requerimento actualizarRequerimento(Long id, Requerimento requerimentoActualizado) {

        Optional<Requerimento> requerimentoExistente = requerimentoRepository.findById(id);

        if (requerimentoActualizado.getOpcion_elegida() != 0) { // to fix
            requerimentoExistente.get().setOpcion_elegida(requerimentoActualizado.getOpcion_elegida());
        }

        if (requerimentoActualizado.getComentaio_rector() != null) {
            requerimentoExistente.get().setComentaio_rector(requerimentoActualizado.getComentaio_rector());
        }

        if (requerimentoActualizado.getComentario_compra() != null) {
            requerimentoExistente.get().setComentario_compra(requerimentoActualizado.getComentario_compra());
        }

        if (requerimentoActualizado.getComentario_logistico() != null) {
            requerimentoExistente.get().setComentario_logistico(requerimentoActualizado.getComentario_logistico());
        }

        if (requerimentoActualizado.getDescripcion() != null) {
            requerimentoExistente.get().setDescripcion(requerimentoActualizado.getDescripcion());
        }

        if (requerimentoActualizado.getEstado() != null) {
            Optional<Estado> estadoOptional = estadoService.obtenerEstadoPorId(requerimentoActualizado.getEstado().getId());
            if (estadoOptional.isPresent()) {
                requerimentoExistente.get().setEstado(estadoOptional.get());
            }
        }

        if (requerimentoActualizado.getTitulo() != null) {
            requerimentoExistente.get().setTitulo(requerimentoActualizado.getTitulo());
        }


        return requerimentoRepository.save(requerimentoExistente.get());
    }

    // Método para eliminar un requerimiento por su ID
    public void eliminarRequerimentoPorId(Long id) {
        requerimentoRepository.deleteById(id);
    }
}
