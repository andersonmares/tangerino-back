package br.com.solides.controller.impl;

import br.com.solides.model.dtos.UsuarioDto;
import br.com.solides.model.dtos.UsuarioFilterDto;
import br.com.solides.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/usuario")
public class UsuarioController {
    private final UsuarioService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto obterPorId(@PathVariable("id") Long id) {
        return service.obterPorId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UsuarioDto> salvar(@Valid @RequestBody UsuarioFilterDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }


}
