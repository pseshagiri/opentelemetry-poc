package com.seshagiri.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seshagiri.ps.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //List<ProductEntity> findProductByName(String name);
}
