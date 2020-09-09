package com.desafio.app.service;

import com.desafio.app.repositories.ContaPagarRepository;
import org.assertj.core.api.ErrorCollector;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
class ContaPagarServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @InjectMocks
    private ContaPagarService service = new ContaPagarService();

    @Mock
    private ContaPagarRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void inserir() {
    }

    @Test
    void calculaValor() {
    }

    @Test
    void calculaDiasAtraso() {
    }

    @Test
    void converteMillessegundoParaDias() {
    }

    @Test
    void calculaCorrecaoValor() {
    }

    @Test
    void buscarPeloId() {
    }

    @Test
    void buscarTodos() {
    }
}