package br.com.solides.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioFilterDto {
    private PublicacaoDto publicacao;
    private String comentario;
}
