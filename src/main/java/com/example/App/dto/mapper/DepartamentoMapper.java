package com.example.App.dto.mapper;

import com.example.App.dto.Departamentodto;
import com.example.App.entities.Departamento;
import com.example.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface DepartamentoMapper extends EntityToDto<Departamento, Departamentodto> {
}