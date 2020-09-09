package com.desafio.app.service;

import com.desafio.app.repositories.FatorCalculoRepository;
import org.assertj.core.api.ErrorCollector;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
class FatorCalculoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @InjectMocks
    private FatorCalculoService service = new FatorCalculoService();

    @Mock
    private FatorCalculoRepository repository;

    @Test
    void buscarFatorCalculo() {
    }

    @Test
    void inserir() {
    }

    @Test
    void buscarPeloId() {
    }

    @Test
    void buscarTodos() {
    }
}