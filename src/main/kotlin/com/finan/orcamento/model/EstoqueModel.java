package com.finan.orcamento.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estoque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto", nullable = false, length = 50)
    private String produto;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "desconto", nullable = false, length = 50)
    private BigDecimal desconto;


}
