package br.com.solides.model.mappers;

import br.com.solides.model.dtos.PublicacaoDto;
import br.com.solides.model.entity.Publicacao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PublicacaoMapper {
    PublicacaoDto toDto(Publicacao entity);

    List<PublicacaoDto> toDto(List<Publicacao> entity);

    Publicacao toEntity(PublicacaoDto dto);

    List<Publicacao> toEntity(List<PublicacaoDto> dto);

}
