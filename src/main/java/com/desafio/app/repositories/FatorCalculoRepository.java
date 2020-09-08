package com.desafio.app.repositories;

import com.desafio.app.domain.entities.FatorCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatorCalculoRepository extends JpaRepository<FatorCalculo, Long> {
}
