package com.desafio.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTA_PAGAR")
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = -3516598427487444860L;

    @Id
    @SequenceGenerator(name = "CONTA_SEQUENCE", sequenceName = "CONTA_SEQUENCE",  initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "CONTA_SEQUENCE", strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALOR_ORIGINAL", nullable = false)
    private BigDecimal valorOriginal;

    @Column(name = "VALOR_CORRIGIDO")
    private BigDecimal valorCorrigido;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "DIAS_ATRASO")
    private Integer diasAtraso;

    @OneToOne
    @JoinColumn(name = "ID_FATOR_CALCULO")
    private FatorCalculo fatorCalculo;

}
