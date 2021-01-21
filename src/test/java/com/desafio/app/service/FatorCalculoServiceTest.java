package com.desafio.app.service;

import com.desafio.app.repositories.FatorCalculoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FatorCalculoServiceTest {

	@InjectMocks
	private FatorCalculoService service;

	@Mock
	private FatorCalculoRepository repository;

//	@Captor
//	private ArgumentCaptor<Definir> captor;

	@Test
	void buscarFatorCalculo() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(anyString());
		assertEquals(true, true);
		verify(null);
	}

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
	void buscarPeloId() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(anyString());
		assertEquals(true, true);
		verify(null);
	}

	@Test
	void buscarTodos() {
		// Arrange
		when(null);

		// Act

		// Asser
		assertNotNull(anyString());
		assertEquals(true, true);
		verify(null);
	}
}