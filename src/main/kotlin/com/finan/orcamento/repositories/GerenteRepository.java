package com.finan.orcamento.repositories;

import com.finan.orcamento.model.GerenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<GerenteModel, Long> {

}
