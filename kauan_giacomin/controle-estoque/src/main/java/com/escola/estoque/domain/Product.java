package com.escola.estoque.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private final String id;
    private final String name;
    private int quantity;
    private final BigDecimal price;

    public Product(String name, int initialQuantity, BigDecimal price) {
        if (name == null || name.isBlank()) throw new BusinessException("Nome inválido");
        if (initialQuantity < 0) throw new BusinessException("Quantidade inicial não pode ser negativa");
        if (price == null || price.signum() < 0) throw new BusinessException("Preço inválido");
        this.id = UUID.randomUUID().toString();
        this.name = name.strip();
        this.quantity = initialQuantity;
        this.price = price;
    }

    public void addStock(int qty) {
        if (qty <= 0) throw new BusinessException("Entrada deve ser > 0");
        this.quantity += qty;
    }

    public void removeStock(int qty) {
        if (qty <= 0) throw new BusinessException("Saída deve ser > 0");
        if (qty > this.quantity) throw new BusinessException("Estoque insuficiente");
        this.quantity -= qty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }

    @Override public String toString() {
        return "Product{id='%s', name='%s', qty=%d, price=%s}".formatted(id, name, quantity, price);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        return Objects.equals(id, ((Product) o).id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
