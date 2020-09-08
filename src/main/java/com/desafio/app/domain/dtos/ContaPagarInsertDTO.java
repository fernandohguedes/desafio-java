package com.desafio.app.domain.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ContaPagarInsert", description = "Objeto Responsável por armazenar informações de conta a pagar")
public class ContaPagarInsertDTO implements Serializable {

    private static final long serialVersionUID = -4244464740938084691L;

    @NotEmpty
    @ApiModelProperty(value = "nome da conta a ser paga", required = true)
    private String nome;

    @NotNull
    @ApiModelProperty(value = "valor original da conta", required = true, example = "100.50")
    private BigDecimal valorOriginal;

    @NotNull
    @ApiModelProperty(value = "data de vencimento da conta", required = true, example = "2020-09-05")
    private LocalDate dataVencimento;

    @NotNull
    @ApiModelProperty(value = "data do pagamento da conta", required = true, example = "2020-09-05")
    private LocalDate dataPagamento;

}
