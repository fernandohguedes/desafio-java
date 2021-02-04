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
@Table(name = "FATOR_CALCULO")
public class FatorCalculo implements Serializable {

    private static final long serialVersionUID = 3458028187016397558L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DIAS_ATRASO")
    private Integer diasAtraso;

    @Column(name = "MULTA")
    private BigDecimal multa;

    @Column(name = "JUROS_DIA_ATRASO")
    private BigDecimal jurosDiaAtraso;

}
