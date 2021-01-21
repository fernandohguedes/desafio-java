package com.desafio.app.controllers;

import com.desafio.app.domain.dtos.FatorCalculoDTO;
import com.desafio.app.domain.dtos.FatorCalculoInsertDTO;
import com.desafio.app.service.FatorCalculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fator-calculo")
@Api(tags = "Fator Calculo")
public class FatorCalculoController {

    @Autowired
    private FatorCalculoService service;

    @ApiOperation(value = "Serviço Responsável por inserir a Dados de um fator de calculo")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Retorna de sucesso padrão")
    })
    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody @Valid FatorCalculoInsertDTO fatorCalculoInsert) {
        Long id = service.inserir(fatorCalculoInsert);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Serviço Responsável por a Dados de um fator de calculo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna de sucesso padrão"),
            @ApiResponse(code = 404, message = "Retorno de Not Founde caso algum dado informado não for encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FatorCalculoDTO> buscarPeloId(@PathVariable Long id) {
        FatorCalculoDTO conta = service.buscarPeloId(id);
        return ResponseEntity.ok().body(conta);
    }

    @ApiOperation(value = "Serviço Responsável por listar fatores de calculo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna de sucesso padrão"),
            @ApiResponse(code = 404, message = "Retorno de Not Founde caso algum dado informado não for encontrado")
    })
    @GetMapping()
    public ResponseEntity<List<FatorCalculoDTO>> buscarTodos() {
        List<FatorCalculoDTO> contas = service.buscarTodos();
        return ResponseEntity.ok().body(contas);
    }
}
