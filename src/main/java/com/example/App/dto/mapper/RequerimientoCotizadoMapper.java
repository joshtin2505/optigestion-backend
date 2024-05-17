package com.example.App.dto.mapper;

import com.example.App.dto.Cotizaciondto;
import com.example.App.dto.RequerimientoCotizadoDTO;
import com.example.App.entities.Requerimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.app.entities.Cotizacion;

import java.util.List;

@Mapper
public interface RequerimientoCotizadoMapper {
    RequerimientoCotizadoMapper INSTANCE = Mappers.getMapper(RequerimientoCotizadoMapper.class);
    /*
    @Mapping(source = "id_requerimeinto", target = "idRequerimiento")
    @Mapping(source = "estado.nombre", target = "estado")
    @Mapping(source = "usuario.nombre", target = "usuario")
    @Mapping(source = "tipoRequerimiento.nombre", target = "tipoRequerimiento")
    RequerimientoCotizadoDTO requerimentoToDto(Requerimento requerimento, List<Cotizaciondto> cotizaciones);

    @Mapping(source = "id_cotizacion", target = "idCotizacion")
    Cotizaciondto cotizacionToCotizacionDTO(Cotizacion cotizacion);

    List<Cotizaciondto> cotizacionListToCotizacionDTOList(List<Cotizacion> cotizaciones);
    */

}
