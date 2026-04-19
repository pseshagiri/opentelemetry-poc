package com.seshagiri.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seshagiri.ps.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    
}
