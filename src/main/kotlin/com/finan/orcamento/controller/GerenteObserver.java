package com.finan.orcamento.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finan.orcamento.Interfaces.Observer;
import com.finan.orcamento.service.GerenteService;

@Component
public class GerenteObserver implements Observer {
    private GerenteService gerenteService;

    public GerenteObserver(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @Override
    public void ValorTotal(double bigDecimal) {
        if (bigDecimal >= 1000) {
            // Envia uma notificação ou mensagem ao gerente
            System.out.println("Alerta: Valor total de produtos igual ou maior a R$1000. Gerentes notificados.");
        }
    }
} 
