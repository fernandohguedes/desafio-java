package com.desafio.app.repositories;

import com.desafio.app.domain.entities.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository  extends JpaRepository<ContaPagar, Long> {
}
