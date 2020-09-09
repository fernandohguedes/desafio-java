package com.desafio.app.domain.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FatorCalculoInsert", description = "Objeto Responsável por armazenar informações sobre fator de Calculo")
public class FatorCalculoInsertDTO implements Serializable {
    private static final long serialVersionUID = 8754877901345490993L;

    @NotNull
    @ApiModelProperty(value = "Dias de atraso", required = true, example = "1")
    private Integer diasAtraso;

    @NotNull
    @ApiModelProperty(value = "Percentual de multa por vencimento", required = true, example = "3.0")
    private BigDecimal multa;

    @NotNull
    @ApiModelProperty(value = "Juros por dia de atraso", required = true, example = "0.2")
    private BigDecimal jurosDiaAtraso;

}
