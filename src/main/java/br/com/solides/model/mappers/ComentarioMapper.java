package br.com.solides.model.mappers;

import br.com.solides.model.dtos.ComentarioDto;
import br.com.solides.model.entity.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComentarioMapper {
    ComentarioDto toDto(Comentario entity);

    List<ComentarioDto> toDto(List<Comentario> entity);

    Comentario toEntity(ComentarioDto dto);

    List<Comentario> toEntity(List<ComentarioDto> dto);
}
