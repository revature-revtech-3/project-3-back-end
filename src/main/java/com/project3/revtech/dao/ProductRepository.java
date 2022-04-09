package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //----- Product Custom JPA Queries ----------//
    ProductEntity findByProductId(int productId);

}
