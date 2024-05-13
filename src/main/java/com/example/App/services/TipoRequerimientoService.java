/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.services;

/**
 *
 * @author PC
 */
import com.example.App.entities.TipoRequerimiento;
import com.example.App.repositories.TiporequerimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoRequerimientoService {
    private final TiporequerimientoRepository tipoRequerimientoRepository;

    @Autowired
    public TipoRequerimientoService(TiporequerimientoRepository tipoRequerimientoRepository) {
        this.tipoRequerimientoRepository = tipoRequerimientoRepository;
    }

    // Método para obtener todos los tipos de requerimiento
    public List<TipoRequerimiento> obtenerTodosLosTiposRequerimiento() {
        return tipoRequerimientoRepository.findAll();
    }

    // Método para obtener un tipo de requerimiento por su ID
    public Optional<TipoRequerimiento> obtenerTipoRequerimientoPorId(Long id) {
        return tipoRequerimientoRepository.findById(id);
    }
    
    // Método para guardar un nuevo tipo de requerimiento
    public TipoRequerimiento guardarTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        return tipoRequerimientoRepository.save(tipoRequerimiento);
    }

    // Método para actualizar un tipo de requerimiento existente
    public TipoRequerimiento actualizarTipoRequerimiento(Long id, TipoRequerimiento tipoRequerimiento) {
        tipoRequerimiento.setId_tipo_requerimiento(id); // Asegurar que el ID del tipo de requerimiento coincida con el proporcionado
        return tipoRequerimientoRepository.save(tipoRequerimiento);
    }

    // Método para eliminar un tipo de requerimiento por su ID
    public void eliminarTipoRequerimientoPorId(Long id) {
        tipoRequerimientoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return !tipoRequerimientoRepository.existsById(id);
    }
}
