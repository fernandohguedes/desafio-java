package com.desafio.app.service;

import com.desafio.app.repositories.ContaPagarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ContaPagarServiceTest {

	@InjectMocks
	private ContaPagarService service;

	@Mock
	private ContaPagarRepository repository;

	@Mock
	private FatorCalculoService fatorCalculoService;

//	@Captor
//	private ArgumentCaptor<Definir> captor;

	@Test
	void inserir() {

		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(anyString());
		assertEquals(true, true);
		verify(null);

	}

	@Test
	void calculaValor() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void calculaDiasAtraso() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void converteMillissegundoParaDias() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void calculaCorrecaoValor() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void buscarPeloId() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void buscarTodos() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(null);
		assertEquals(true, true);
		verify(null);
	}
}