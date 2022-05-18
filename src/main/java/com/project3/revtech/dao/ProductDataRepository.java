package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.ProductDataEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.pojo.ProductDataPojo;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductDataEntity, Integer> {
	
	  @Query(value="select purchasedproduct.product_name, sum( purchasedproduct.item_qty) from purchasedproduct group by purchasedproduct.product_name;", nativeQuery=true)
	  List<ProductDataEntity> findAllByPurchase();
	  
	  @Query(value="select purchasedproduct.product_name,sum( purchasedproduct.product_cost) from purchasedproduct group by purchasedproduct.product_name;", nativeQuery=true)
	  List<ProductDataEntity> findAllBySales();
	  
	  @Query(value="SELECT SUM(purchasedproduct.product_cost) FROM purchasedproduct", nativeQuery=true)
	  int findSum();
	  
	  

}
