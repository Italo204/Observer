package com.finan.orcamento;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.finan.orcamento.controller.GerenteObserver;
import com.finan.orcamento.model.EstoqueModel;
import com.finan.orcamento.model.GerenteModel;
import com.finan.orcamento.service.EstoqueService;
import com.finan.orcamento.service.GerenteService;

@SpringBootApplication(scanBasePackages = {"com.finan.orcamento"})
public class OrcamentoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrcamentoApplication.class, args);
        GerenteObserver gerenteObserver = context.getBean(GerenteObserver.class);
        performTests(context);
    }

    private static void performTests(ConfigurableApplicationContext context) {
        // Acesso aos serviços
        GerenteService gerenteService = context.getBean(GerenteService.class);
        EstoqueService estoqueService = context.getBean(EstoqueService.class);

        // Teste: Adicionar e recuperar um gerente
        GerenteModel gerente = new GerenteModel(null, "Carlos");
        gerente = gerenteService.saveGerente(gerente);
        System.out.println("Gerente adicionado: " + gerente);
        // Teste: Adicionar e recuperar um produto no estoque
        EstoqueModel produto = new EstoqueModel(null, "Produto X", new BigDecimal("1200.00"), new BigDecimal("200.00"));
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------");
        produto = estoqueService.addProduto(produto);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Valor acima de 1000");
        System.out.println("");

        EstoqueModel produto1 = new EstoqueModel(null, "Produto X", new BigDecimal("800.00"), new BigDecimal("200.00"));
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------");
        produto = estoqueService.addProduto(produto1);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Valor abaixo de 1000");
        System.out.println("");
        // Suponha que você quer deletar ou atualizar, apenas chame os métodos relevantes aqui

        // Finaliza a aplicação após os testes
    }
}
