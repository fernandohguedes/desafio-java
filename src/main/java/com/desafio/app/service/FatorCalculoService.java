package com.desafio.app.service;

import com.desafio.app.repositories.FatorCalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatorCalculoService {

    @Autowired
    private FatorCalculoRepository repository;


}
