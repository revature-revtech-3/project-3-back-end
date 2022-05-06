package com.project3.revtech.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.pojo.ProductPojo;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //----- Product Custom JPA Queries ----------//
    ProductEntity findByProductId(int productId);
	
   @Query(value="select * from product_details where product_name like %:name% ", nativeQuery = true )
    //@Query("select p from ProductEntity p where p.product_name like %:?% ")
    List<ProductEntity> getSecondaryProducts(@Param("name") String productName);
    		//productEntity
}
