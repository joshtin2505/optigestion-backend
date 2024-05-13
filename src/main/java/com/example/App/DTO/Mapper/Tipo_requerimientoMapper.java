/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.DTO.Mapper;
import com.example.App.DTO.Tipo_requerimientodto;
import com.example.App.entities.TipoRequerimiento;
import com.example.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;


@Mapper(componentModel = ComponentModel.SPRING)
public interface Tipo_requerimientoMapper extends EntityToDto<TipoRequerimiento, Tipo_requerimientodto> {
}
