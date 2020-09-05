package com.desafio.app.service;

import com.desafio.app.domain.dtos.ContaPagarDTO;
import com.desafio.app.domain.dtos.ContaPagarInsertDTO;
import com.desafio.app.domain.entities.ContaPagar;
import com.desafio.app.repositories.ContaPagarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaPagarService {

    @Autowired
    private ContaPagarRepository repository;

    public Long inserir(ContaPagarInsertDTO dto) {
        ContaPagar contaPagar = new ContaPagar();
        contaPagar.setNome(dto.getNome());
        contaPagar.setValorOriginal(dto.getValorOriginal());
        contaPagar.setDataPagamento(Date.from(dto.getDataPagamento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        contaPagar.setDataVencimento(Date.from(dto.getDataPagamento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        contaPagar.setDiasAtraso(1);
        contaPagar.setValorCorrigido(new BigDecimal(100.0));
        contaPagar = repository.save(contaPagar);

        return contaPagar.getId();
    }

    public ContaPagarDTO buscarPeloId(Long id) {
        ContaPagar contaPagar = repository.findById(id).orElseThrow(() -> new RuntimeException());
        return new ModelMapper().map(contaPagar, ContaPagarDTO.class);
    }

    public List<ContaPagarDTO> buscarTodos() {
        List<ContaPagar> contas = repository.findAll();
        return contas.stream().map(contaPagar -> new ModelMapper().map(contaPagar, ContaPagarDTO.class))
                .collect(Collectors.toList());
    }
}
