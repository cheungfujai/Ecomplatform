package com.kevdev.ecomplatform.Domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintypeRepository extends JpaRepository<Maintype, Long> {
    Maintype findByMainTypeName(String mainTypeName);
}
