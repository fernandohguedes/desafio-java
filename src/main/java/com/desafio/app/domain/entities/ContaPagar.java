package com.desafio.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = -3516598427487444860L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALOR_ORIGINAL", nullable = false)
    private BigDecimal valorOriginal;

    @Column(name = "VALOR_CORRIGIDO", nullable = false)
    private BigDecimal valorCorrigido;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private Date dataVencimento;

    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private Date dataPagamento;

    @Column(name = "DIAS_ATRASO", nullable = false)
    private Integer diasAtraso;

}
