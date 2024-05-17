package com.example.App.dto.mapper;

import com.example.App.dto.Detalle_cotizaciondto;
import com.example.App.entities.Detalle_cotizacion;
import com.example.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface Detalle_cotizacionMapper extends EntityToDto<Detalle_cotizacion, Detalle_cotizaciondto> {
}