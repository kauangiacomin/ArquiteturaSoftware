package com.escola.estoque.presentation;

import com.escola.estoque.application.InventoryService;
import com.escola.estoque.domain.BusinessException;
import com.escola.estoque.persistence.InMemoryProductRepository;

import java.math.BigDecimal;

public class CliApp {
    public static void main(String[] args) {
        var repo = new InMemoryProductRepository();
        var service = new InventoryService(repo);

        try {
            var p1 = service.createProduct("Caneta Azul", 100, new BigDecimal("1.99"));
            var p2 = service.createProduct("Caderno A4", 50, new BigDecimal("12.50"));

            service.registerIn(p1.getId(), 25);
            service.registerOut(p2.getId(), 10);

            try { service.registerOut(p2.getId(), 1000); }
            catch (BusinessException be) { System.out.println("[ERRO ESPERADO] " + be.getMessage()); }

            System.out.println("\n=== PRODUTOS ===");
            service.listAll().forEach(System.out::println);

        } catch (BusinessException be) {
            System.out.println("[ERRO] " + be.getMessage());
        } catch (Exception e) {
            System.out.println("[ERRO TÉCNICO] " + e.getMessage());
            e.printStackTrace();
        }
    }
}
