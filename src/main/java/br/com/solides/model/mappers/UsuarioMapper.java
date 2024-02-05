package br.com.solides.model.mappers;

import br.com.solides.model.dtos.UsuarioDto;
import br.com.solides.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    UsuarioDto toDto(Usuario entity);

    Usuario toEntity(UsuarioDto dto);
}
