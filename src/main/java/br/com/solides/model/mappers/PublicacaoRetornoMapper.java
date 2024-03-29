package br.com.solides.model.mappers;

import br.com.solides.model.dtos.PublicacaoRetornoDto;
import br.com.solides.model.entity.Publicacao;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PublicacaoRetornoMapper {
    PublicacaoRetornoDto toDto(Publicacao entity);

    List<PublicacaoRetornoDto> toDto(List<Publicacao> entities);

    Publicacao toEntity(PublicacaoRetornoDto dto);

    List<Publicacao> toEntity(List<PublicacaoRetornoDto> dtos);

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(PublicacaoRetornoDto dto, @MappingTarget Publicacao entity);
}
