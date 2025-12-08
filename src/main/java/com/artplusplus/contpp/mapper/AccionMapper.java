package com.artplusplus.contpp.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.artplusplus.contpp.dto.AccionDto;
import com.artplusplus.contpp.model.Accion;

@Mapper(componentModel = "spring")
public interface AccionMapper extends BaseMapper<Accion, AccionDto> {
    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateEntityFromDto(AccionDto dto, @MappingTarget Accion entity);
}