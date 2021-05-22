package com.kevdev.ecomplatform.Domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtypeRepository extends JpaRepository<Subtype, Long> {
    Subtype findBySubTypeName(String subTypeName);
}
