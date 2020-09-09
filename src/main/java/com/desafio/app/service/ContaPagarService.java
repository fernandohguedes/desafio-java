package com.desafio.app.service;

import com.desafio.app.domain.dtos.ContaPagarDTO;
import com.desafio.app.domain.dtos.ContaPagarInsertDTO;
import com.desafio.app.domain.entities.ContaPagar;
import com.desafio.app.domain.entities.FatorCalculo;
import com.desafio.app.errors.exceptions.ObjectNotFoundException;
import com.desafio.app.repositories.ContaPagarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaPagarService {

    @Autowired
    private ContaPagarRepository repository;

    @Autowired
    private FatorCalculoService fatorCalculoService;

    public Long inserir(ContaPagarInsertDTO dto) {
        ContaPagar contaPagar = new ContaPagar();
        contaPagar.setNome(dto.getNome());
        contaPagar.setValorOriginal(dto.getValorOriginal());
        contaPagar.setDataPagamento(dto.getDataPagamento());
        contaPagar.setDataVencimento(dto.getDataPagamento());

        boolean vencido = dto.getDataPagamento().isAfter(dto.getDataVencimento());
        if (vencido) {
            contaPagar = calculaValor(dto, contaPagar);
        }

        contaPagar = repository.save(contaPagar);
        return contaPagar.getId();
    }

    public ContaPagar calculaValor(ContaPagarInsertDTO dto, ContaPagar contaPagar) {
        Integer diasAtraso = calculaDiasAtraso(dto.getDataVencimento(), dto.getDataPagamento());
        FatorCalculo fator = fatorCalculoService.buscarFatorCalculo(diasAtraso);
        contaPagar = calculaCorrecaoValor(fator, diasAtraso, contaPagar);
        contaPagar.setFatorCalculo(fator);
        return contaPagar;
    }

    public Integer calculaDiasAtraso(LocalDate dataVencimento, LocalDate dataPagamento) {
        Date vencimento = Date.from(dataVencimento.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date pagamento = Date.from(dataPagamento.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return converteMillessegundoParaDias(vencimento, pagamento);
    }

    public Integer converteMillessegundoParaDias(Date vencimento, Date pagamento) {
        Long diasAtraso = (pagamento.getTime() - vencimento.getTime()) / (1000 * 60 * 60 * 24);
        return Integer.valueOf(diasAtraso.toString());
    }

    public ContaPagar calculaCorrecaoValor(FatorCalculo fator, Integer diasAtraso, ContaPagar contaPagar) {
        BigDecimal valorMulta = contaPagar.getValorOriginal().multiply(fator.getMulta()).divide(new BigDecimal(100));
        BigDecimal valorJuros = fator.getJurosDiaAtraso().multiply(new BigDecimal(diasAtraso));
        BigDecimal valorCorrigido = valorMulta.add(valorJuros).add(contaPagar.getValorOriginal());

        contaPagar.setValorCorrigido(valorCorrigido);
        contaPagar.setDiasAtraso(diasAtraso);
        return contaPagar;
    }

    public ContaPagarDTO buscarPeloId(Long id) {
        ContaPagar contaPagar = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(ObjectNotFoundException.CONTA_NAO_ENCONTRADA));
        return new ModelMapper().map(contaPagar, ContaPagarDTO.class);
    }

    public List<ContaPagarDTO> buscarTodos() {
        List<ContaPagar> contas = repository.findAll();

        if (contas.isEmpty()) {
            throw new ObjectNotFoundException(ObjectNotFoundException.CONTAS_NAO_ENCONTRADAS);
        }

        return contas.stream().map(contaPagar -> new ModelMapper().map(contaPagar, ContaPagarDTO.class))
                .collect(Collectors.toList());
    }
}
