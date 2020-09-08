package com.desafio.app.service;

import com.desafio.app.domain.entities.FatorCalculo;
import com.desafio.app.repositories.FatorCalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FatorCalculoService {

    @Autowired
    private FatorCalculoRepository repository;

    public FatorCalculo consultaFator(Integer diasAtraso){
        if (diasAtraso > 6) {
            diasAtraso = 6;
        }

        Optional<FatorCalculo> fator = repository.findByDiasAtraso(diasAtraso);
        return fator.get();
    }
}
