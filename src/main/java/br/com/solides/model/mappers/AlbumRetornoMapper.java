package br.com.solides.model.mappers;

import br.com.solides.model.dtos.AlbumRetornoDto;
import br.com.solides.model.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlbumRetornoMapper {
    AlbumRetornoDto toDto(Album entity);

    List<AlbumRetornoDto> toDto(List<Album> entity);

    Album toEntity(AlbumRetornoDto dto);

    List<Album> toEntity(List<AlbumRetornoDto> dto);

}
