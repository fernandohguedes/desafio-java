package com.desafio.configuration;

import com.desafio.app.domain.entities.FatorCalculo;
import com.desafio.app.repositories.FatorCalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private FatorCalculoRepository fatorCalculoRepository;

    public void instantiateTestDatabase() {
        // fator até 3 dias de atraso
        FatorCalculo fator1 = new FatorCalculo(null, 1, new BigDecimal(2.0), new BigDecimal(0.1));
        FatorCalculo fator2 = new FatorCalculo(null, 2, new BigDecimal(2.0), new BigDecimal(0.1));
        FatorCalculo fator3 = new FatorCalculo(null, 3, new BigDecimal(2.0), new BigDecimal(0.1));

        // fator de 4 a 5 dias de atraso
        FatorCalculo fator4 = new FatorCalculo(null, 4, new BigDecimal(3.0), new BigDecimal(0.2));
        FatorCalculo fator5 = new FatorCalculo(null, 5, new BigDecimal(3.0), new BigDecimal(0.2));

        // fator 6 dias ou mais de vencimento
        FatorCalculo fator6 = new FatorCalculo(null, 6, new BigDecimal(5.0), new BigDecimal(0.3));

        fatorCalculoRepository.saveAll(Arrays.asList(fator1, fator2, fator3, fator4, fator5, fator6));
    }
}
