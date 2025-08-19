package com.escola.estoque.persistence;

import com.escola.estoque.domain.Product;
import java.util.*;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> db = new ArrayList<>();

    @Override public Product save(Product p) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId().equals(p.getId())) { db.set(i, p); return p; }
        }
        db.add(p);
        return p;
    }

    @Override public Optional<Product> findById(String id) {
        return db.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override public List<Product> findAll() {
        return new ArrayList<>(db);
    }
}
