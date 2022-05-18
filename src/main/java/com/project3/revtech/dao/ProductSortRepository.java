package com.project3.revtech.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.PurchasedItemEntity;

import software.amazon.ion.Decimal;

public interface ProductSortRepository extends JpaRepository <PurchasedItemEntity, Integer> {

	//@Query(value="select product_id,product_name, product_cost, product_category,product_description, product_sku,product_qty, image_url, product_removed from product_details order by product_cost asc", nativeQuery=true)
    //List<PurchasedItemEntity> findProductByAscOrder(int itemQTY);
	  //List<ProductEntity> findByOrderByProductCostAsc();
}
