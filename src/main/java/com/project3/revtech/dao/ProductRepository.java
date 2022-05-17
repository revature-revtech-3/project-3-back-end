package com.project3.revtech.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.pojo.ProductPojo;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //----- Product Custom JPA Queries ----------//
    ProductEntity findByProductId(int productId);
    @Query(value="select product_id, product_name, product_cost, product_category, product_description, product_sku,product_qty, image_url, product_removed from product_details order by product_cost asc", nativeQuery=true)
	List<ProductPojo> getAllProducts();
	//List<ProductPojo> getEveryProduct();
}
