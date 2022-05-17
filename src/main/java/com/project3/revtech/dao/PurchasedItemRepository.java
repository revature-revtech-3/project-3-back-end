package com.project3.revtech.dao;

import com.project3.revtech.entity.PurchasedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItemEntity, Integer> {
    List<PurchasedItemEntity> findAllByTransactionId(int transactionId);
    List<PurchasedItemEntity> findAllByUserId(int userId);
    
    @Query(value="select *"
    		+ "from product_details\r\n"
    		+ "left join  purchased_items on product_details.product_id = purchased_items.product_id;", nativeQuery=true)
    List<PurchasedItemEntity> findAllByPurchase();
}
