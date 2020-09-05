package com.desafio.app.domain.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ContaPagar", description = "Objeto Responsável por armazenar informações de conta a pagar")
public class ContaPagarDTO implements Serializable {

    private static final long serialVersionUID = -5265113261343324046L;

    @ApiModelProperty(value = "Código identificador", example = "1")
    private Long id;

    @ApiModelProperty(value = "nome da conta a ser paga", example = "Conta de Agua")
    private String nome;

    @ApiModelProperty(value = "valor original da conta", example = "100.50")
    private BigDecimal valorOriginal;

    @ApiModelProperty(value = "valor corrigido da conta", example = "100.50")
    private BigDecimal valorCorrigido;

    @ApiModelProperty(value = "data de vencimento da conta", example = "2020-09-05")
    private LocalDate dataVencimento;

    @ApiModelProperty(value = "data do pagamento da conta", example = "2020-09-05")
    private LocalDate dataPagamento;

    @ApiModelProperty(value = "dias em atraso da conta", example = "3")
    private Integer diasAtraso;

}
