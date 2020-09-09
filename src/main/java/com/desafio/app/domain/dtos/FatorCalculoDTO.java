package com.desafio.app.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "FatorCalculo", description = "Objeto Responsável por armazenar informações do fator de Calculo")
public class FatorCalculoDTO implements Serializable {
    private static final long serialVersionUID = -1199896766612858433L;

    private Long id;
    private Integer diasAtraso;
    private BigDecimal multa;
    private BigDecimal jurosDiaAtraso;

}
