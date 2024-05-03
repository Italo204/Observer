package com.finan.orcamento.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finan.orcamento.Interfaces.Observer;
import com.finan.orcamento.controller.GerenteObserver;
import com.finan.orcamento.model.EstoqueModel;
import com.finan.orcamento.repositories.EstoqueRepository;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private GerenteObserver gerenteObserver;

    private List<Observer> observers = new ArrayList<>();

    // Adiciona um novo produto ao estoque
    public EstoqueModel addProduto(EstoqueModel produto) {
        EstoqueModel savedProduto = estoqueRepository.save(produto);
        // Notificar somente se o valor do produto específico for maior que 1000
        if (produto.getValor().compareTo(new BigDecimal("1000")) > 0) {
            double valor = produto.getValor().doubleValue();
            gerenteObserver.ValorTotal(valor);
        }
        return savedProduto;
    }

    // Atualiza um produto existente no estoque
    public EstoqueModel updateProduto(Long id, EstoqueModel produtoDetails) {
        EstoqueModel produto = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
        produto.setProduto(produtoDetails.getProduto());
        produto.setValor(produtoDetails.getValor());
        produto.setDesconto(produtoDetails.getDesconto());
        final EstoqueModel updatedProduto = estoqueRepository.save(produto);
        if (updatedProduto.getValor().compareTo(new BigDecimal("1000")) > 0) {
            Double valor = produto.getValor().doubleValue();
            gerenteObserver.ValorTotal(valor);
        }
        return updatedProduto;
    }

    // Recupera um produto pelo ID
    public Optional<EstoqueModel> getProdutoById(Long id) {
        return estoqueRepository.findById(id);
    }

    // Retorna todos os produtos no estoque
    public List<EstoqueModel> getAllProdutos() {
        return estoqueRepository.findAll();
    }

    // Deleta um produto do estoque
    public void deleteProduto(Long id) {
        estoqueRepository.deleteById(id);
    }

    // Registra um observer para receber notificações
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Notifica todos os observers registrados
    private void notifyObservers(BigDecimal valor) {
        observers.forEach(observer -> observer.ValorTotal(valor.doubleValue()));
    }
}
