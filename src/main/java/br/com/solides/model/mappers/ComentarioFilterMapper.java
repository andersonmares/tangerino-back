package br.com.solides.model.mappers;

import br.com.solides.model.dtos.ComentarioFilterDto;
import br.com.solides.model.entity.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComentarioFilterMapper {
    ComentarioFilterDto toDto(Comentario entity);

    List<ComentarioFilterDto> toDto(List<Comentario> entity);

    Comentario toEntity(ComentarioFilterDto dto);

    List<Comentario> toEntity(List<ComentarioFilterDto> dto);
}
