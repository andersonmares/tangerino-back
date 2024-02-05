package br.com.solides.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AlbumRetornoDto {
    private Long id;
    private String extensaoArquivo;
    private Date dtCriacao;
    private UsuarioDto usuario;
    private byte[] imagem;
}
