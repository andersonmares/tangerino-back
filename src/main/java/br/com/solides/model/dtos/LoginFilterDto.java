package br.com.solides.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginFilterDto {
    private String email;
    private String password;
}
