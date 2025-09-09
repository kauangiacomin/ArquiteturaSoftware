package com.escola.estoque.persistence;

import com.escola.estoque.domain.Product;
import java.util.*;

public interface ProductRepository {
    Product save(Product p);
    Optional<Product> findById(String id);
    List<Product> findAll();
}
