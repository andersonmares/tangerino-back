package br.com.solides.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFilterDto {
    private Long id;
    private String nome;
    private String email;
    private String password;


}
