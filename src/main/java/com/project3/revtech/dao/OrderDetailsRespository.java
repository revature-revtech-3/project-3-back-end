package com.project3.revtech.dao;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRespository extends JpaRepository<PurchasedItemEntity, Integer> {
	//List<PurchasedItemEntity> findAllByTransactionId(int transactionId);
    //List<PurchasedItemEntity> findAllByUserId(int userId);
    
//    @Query(value = "SELECT * FROM cart_details WHERE cart_id = :cartId", nativeQuery = true)
//    CartEntity findCart(@Param("cartId") int cartId);
    
    @Query(value = "SELECT * FROM purchased_items WHERE cart_id = :cartId", nativeQuery = true)
    List<PurchasedItemEntity> findOrder(@Param("cartId") int grabCartId);
    
    @Query(value = "SELECT transaction_id FROM transaction_details WHERE cart_id = :cId", nativeQuery = true)
    int findTransactionId(@Param("cId") int cId);
 }
