package com.escola.estoque.application;

import com.escola.estoque.domain.BusinessException;
import com.escola.estoque.domain.Product;
import com.escola.estoque.persistence.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class InventoryService {
    private final ProductRepository repo;

    public InventoryService(ProductRepository repo) { this.repo = repo; }

    public Product createProduct(String name, int initialQty, BigDecimal price) {
        var p = new Product(name, initialQty, price);
        return repo.save(p);
    }

    public void registerIn(String productId, int qty) {
        var p = repo.findById(productId)
                .orElseThrow(() -> new BusinessException("Produto não encontrado"));
        p.addStock(qty);
        repo.save(p);
    }

    public void registerOut(String productId, int qty) {
        var p = repo.findById(productId)
                .orElseThrow(() -> new BusinessException("Produto não encontrado"));
        p.removeStock(qty);
        repo.save(p);
    }

    public List<Product> listAll() { return repo.findAll(); }
}
