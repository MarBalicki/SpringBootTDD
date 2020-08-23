package org.sda.repository;

import org.sda.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findProductById(Long id);
}
