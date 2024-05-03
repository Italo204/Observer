package com.finan.orcamento.repositories;

import com.finan.orcamento.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {

}