package br.com.solides.controller.impl;

import br.com.solides.model.dtos.PublicacaoDto;
import br.com.solides.model.dtos.PublicacaoRetornoDto;
import br.com.solides.service.PublicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/publicacao")
public class PublicacaoController {
    private final PublicacaoService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<PublicacaoDto> salvar(@RequestPart(value = "arquivo") MultipartFile arquivo, @RequestParam("descricao") String descricao) {
        return ResponseEntity.ok(service.salvar(arquivo, descricao));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PublicacaoRetornoDto>> obterTodos() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        service.deletar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
