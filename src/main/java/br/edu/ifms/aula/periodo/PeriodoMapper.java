/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.aula.periodo;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author 07180871192
 */
@Mapper
public interface PeriodoMapper {
    public static final PeriodoMapper INSTANCE = Mappers.getMapper(PeriodoMapper.class);
    
    public PeriodoDto toDto(Periodo entity);
    
    public List<PeriodoDto> map(List<Periodo> items);

    @Mapping(target = "id", ignore = true)
    public void update(PeriodoForm dto, @MappingTarget Periodo entity);

    @Mapping(target = "id", ignore = true)
    public Periodo toEntity(PeriodoForm form);
}
