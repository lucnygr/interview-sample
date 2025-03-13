package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to persist {@link ProductEntity}s.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
