package com.desafio.app.service;

import com.desafio.app.repositories.ContaPagarRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContaPagarServiceTest {

	@InjectMocks
	private ContaPagarService service;

	@Mock
	private ContaPagarRepository repository;

	@Mock
	private FatorCalculoService fatorCalculoService;



}