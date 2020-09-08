package com.desafio.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "FATOR_CALCULO_SEQUENCE")
@Table(name = "FATOR_CALCULO")
public class FatorCalculo implements Serializable {

    @Id
    @GeneratedValue(generator = "FATOR_CALCULO_SEQUENCE", strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DIAS_ATRASO")
    private Integer diasAtraso;

    @Column(name = "MULTA")
    private BigDecimal multa;

    @Column(name = "JUROS_DIA_ATRASO")
    private BigDecimal jurosDiaAtraso;

}
