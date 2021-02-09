package com.desafio.app.service;

import com.desafio.app.domain.dtos.FatorCalculoDTO;
import com.desafio.app.domain.entities.FatorCalculo;
import com.desafio.app.repositories.FatorCalculoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FatorCalculoServiceTest {

	@InjectMocks
	private FatorCalculoService service;

	@Mock
	private FatorCalculoRepository repository;

	@Test
	@DisplayName("Buscar fator de calculo pelo ID (sucesso)")
	public void buscarPeloId_sucesso() {
		// Arrange
		Long id = 1l;
		FatorCalculo fatorCalculo = FatorCalculo.builder()
				.id(1l)
				.diasAtraso(1)
				.jurosDiaAtraso(new BigDecimal(0.10).setScale(2, RoundingMode.CEILING))
				.multa(new BigDecimal(2.00).setScale(2))
				.build();

		when(repository.findById(id)).thenReturn(Optional.of(fatorCalculo));

		// ACT
		FatorCalculoDTO dto = service.buscarPeloId(id);

		// Assert
		verify(repository, times(1)).findById(anyLong());
		assertNotNull(dto);
		assertEquals(1l, dto.getId());
		assertEquals(1, dto.getDiasAtraso());
		assertEquals(new BigDecimal(0.10).setScale(2, RoundingMode.CEILING), dto.getJurosDiaAtraso());
		assertEquals(new BigDecimal(2.00).setScale(2), dto.getMulta());
	}

	@Test
	@DisplayName("Buscar todos registros (sucesso)")
	public void buscarTodos_sucesso(){
		// Arrange
		FatorCalculo fatorCalculo = FatorCalculo.builder()
				.id(1l)
				.diasAtraso(1)
				.jurosDiaAtraso(new BigDecimal(0.10).setScale(2, RoundingMode.CEILING))
				.multa(new BigDecimal(2.00).setScale(2))
				.build();

		List<FatorCalculo> fatores = Arrays.asList(fatorCalculo);

		when(repository.findAll()).thenReturn(fatores);

		// ACT
		List<FatorCalculoDTO> dtos = service.buscarTodos();

		// Assert
		verify(repository, times(1)).findAll();
		assertNotNull(dtos);
		assertEquals(1, dtos.size());
	}
}