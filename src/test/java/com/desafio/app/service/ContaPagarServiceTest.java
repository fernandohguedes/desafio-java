package com.desafio.app.service;

import com.desafio.app.repositories.ContaPagarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class ContaPagarServiceTest {

	@InjectMocks
	private ContaPagarService service;

	@Mock
	private ContaPagarRepository repository;

	@Mock
	private FatorCalculoService fatorCalculoService;

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
	void converteMillissegundoParaDias() {
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