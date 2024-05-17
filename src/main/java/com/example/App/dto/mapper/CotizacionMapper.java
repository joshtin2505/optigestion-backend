package com.example.App.dto.mapper;

import com.example.App.dto.Cotizaciondto;
import com.example.app.entities.Cotizacion;
import com.example.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CotizacionMapper extends EntityToDto<Cotizacion, Cotizaciondto> {

}
