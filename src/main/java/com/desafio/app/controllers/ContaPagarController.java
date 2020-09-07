package com.desafio.app.controllers;

import com.desafio.app.domain.dtos.ContaPagarDTO;
import com.desafio.app.domain.dtos.ContaPagarInsertDTO;
import com.desafio.app.service.ContaPagarService;
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
@RequestMapping("/contas-pagar")
@Api(tags = "Conta Pagar")
public class ContaPagarController {

    @Autowired
    private ContaPagarService service;

    @ApiOperation(value = "Serviço Responsável por inserir a Dados de uma Conta a pagar")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Retorna de sucesso padrão"),
            @ApiResponse(code = 404, message = "Retorno de Not Founde caso algum dado informado não for encontrado"),
            @ApiResponse(code = 422, message = "Retorno de Bad Request caso algo estiver errado com a requisição")
    })
    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody @Valid ContaPagarInsertDTO contaPagarInsert) {
        Long id = service.inserir(contaPagarInsert);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Serviço Responsável por a Dados de uma Conta a pagar")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna de sucesso padrão"),
            @ApiResponse(code = 404, message = "Retorno de Not Founde caso algum dado informado não for encontrado"),
            @ApiResponse(code = 422, message = "Retorno de Unprocessable Entity caso algo estiver errado com o objeto da requisição")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ContaPagarDTO> buscarPeloId(@PathVariable Long id) {
        ContaPagarDTO conta = service.buscarPeloId(id);
        return ResponseEntity.ok().body(conta);
    }

    @ApiOperation(value = "Serviço Responsável por listar as Contas a pagar")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna de sucesso padrão"),
            @ApiResponse(code = 404, message = "Retorno de Not Founde caso algum dado informado não for encontrado")
    })
    @GetMapping()
    public ResponseEntity<List<ContaPagarDTO>> buscarTodos() {
        List<ContaPagarDTO> contas = service.buscarTodos();
        return ResponseEntity.ok().body(contas);
    }
}
