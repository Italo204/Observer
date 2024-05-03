package com.finan.orcamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finan.orcamento.model.EstoqueModel;
import com.finan.orcamento.service.EstoqueService;

public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    // Endpoint para adicionar um novo produto ao estoque
    @PostMapping("/")
    public EstoqueModel addProduto(@RequestBody EstoqueModel produto) {
        return estoqueService.addProduto(produto);
    }

    // Endpoint para atualizar um produto existente no estoque
    @PutMapping("/{id}")
    public ResponseEntity<EstoqueModel> updateProduto(@PathVariable Long id, @RequestBody EstoqueModel produtoDetails) {
        EstoqueModel updatedProduto = estoqueService.updateProduto(id, produtoDetails);
        return ResponseEntity.ok(updatedProduto);
    }

    // Endpoint para obter um produto específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> getProdutoById(@PathVariable Long id) {
        EstoqueModel produto = estoqueService.getProdutoById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
        return ResponseEntity.ok(produto);
    }

    // Endpoint para obter todos os produtos no estoque
    @GetMapping("/")
    public List<EstoqueModel> getAllProdutos() {
        return estoqueService.getAllProdutos();
    }

    // Endpoint para deletar um produto do estoque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        estoqueService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
}

