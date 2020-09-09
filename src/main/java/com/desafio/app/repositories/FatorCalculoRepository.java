package com.desafio.app.repositories;

import com.desafio.app.domain.entities.FatorCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FatorCalculoRepository extends JpaRepository<FatorCalculo, Long> {

    @Transactional(readOnly = true)
    @Query(value = "select f from FatorCalculo f " +
            " where f.diasAtraso = ( select max(e.diasAtraso) from FatorCalculo e " +
            " where e.diasAtraso <= :diasAtraso) ")
    Optional<FatorCalculo> buscarFatorCalculo(Integer diasAtraso);

}
