package com.desafio.app.service;

import com.desafio.app.repositories.FatorCalculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FatorCalculoServiceTest {

	@InjectMocks
	private FatorCalculoService service;

	@Mock
	private FatorCalculoRepository repository;

	@Test
	public void buscarPeloId() {

	}
}