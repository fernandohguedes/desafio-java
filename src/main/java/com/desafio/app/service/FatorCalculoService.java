package com.desafio.app.service;

import com.desafio.app.domain.dtos.FatorCalculoDTO;
import com.desafio.app.domain.dtos.FatorCalculoInsertDTO;
import com.desafio.app.domain.entities.FatorCalculo;
import com.desafio.app.errors.exceptions.ObjectNotFoundException;
import com.desafio.app.repositories.FatorCalculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FatorCalculoService {

    @Autowired
    private FatorCalculoRepository repository;

    public FatorCalculo buscarFatorCalculo(Integer diasAtraso) {
        return repository.buscarFatorCalculo(diasAtraso)
                .orElseThrow(() -> new ObjectNotFoundException(ObjectNotFoundException.FATOR_CALCULO_NAO_ENCONTRADO));
    }

    public Long inserir(FatorCalculoInsertDTO fatorCalculoInsert) {
        FatorCalculo fatorCalculo = new ModelMapper().map(fatorCalculoInsert, FatorCalculo.class);
        fatorCalculo = repository.save(fatorCalculo);
        return fatorCalculo.getId();
    }

    public FatorCalculoDTO buscarPeloId(Long id) {
        FatorCalculo fatorCalculo = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(ObjectNotFoundException.FATOR_CALCULO_NAO_ENCONTRADO));
        return new ModelMapper().map(fatorCalculo, FatorCalculoDTO.class);
    }

    public List<FatorCalculoDTO> buscarTodos() {
        List<FatorCalculo> fatores = repository.findAll();

        if (fatores.isEmpty()) {
            throw new ObjectNotFoundException(ObjectNotFoundException.CONTAS_NAO_ENCONTRADAS);
        }

        return fatores.stream().map(fator -> new ModelMapper().map(fator, FatorCalculoDTO.class))
                .collect(Collectors.toList());
    }
}
