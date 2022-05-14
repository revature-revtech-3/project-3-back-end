package com.project3.revtech.dao;

import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.pojo.PurchasedItemPojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItemEntity, Integer> {
    List<PurchasedItemEntity> findAllByTransactionId(int transactionId);
    List<PurchasedItemEntity> findAllByUserId(int userId);
	@Query(value="select item_id, product_id,user_id, cart_id, transaction_id, purchase_date, item_qty, purchase_cost from purchased_items where item_qty > 3 order by item_qty desc", nativeQuery=true)
    List<PurchasedItemEntity> findByMostPurchasedItems();

}
