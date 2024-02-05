package br.com.solides.model.mappers;

import br.com.solides.model.dtos.AlbumDto;
import br.com.solides.model.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlbumMapper {
    AlbumDto toDto(Album entity);

    List<AlbumDto> toDto(List<Album> entity);

    Album toEntity(AlbumDto dto);

    List<Album> toEntity(List<AlbumDto> dto);

}
