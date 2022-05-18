package com.project3.revtech.dao;

import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.PurchasedItemPojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItemEntity, Integer> {
    List<PurchasedItemEntity> findAllByTransactionId(int transactionId);
    List<PurchasedItemEntity> findAllByUserId(int userId);
    @Query(value="select product_id, item_id, user_id, cart_id, transaction_id, purchase_date,item_qty, purchase_cost, product_name from purchased_items where item_qty > 11 order by item_qty desc", nativeQuery=true)
    //@Query(value="SELECT product_id, item_id, user_id, cart_id, transaction_id, purchase_date,item_qty, purchase_cost, product_name, SUM(item_qty) FROM purchased_items GROUP BY product_id", nativeQuery=true)
    List<PurchasedItemEntity> findByMostPurchasedItems();

}

//@Query(value="SELECT pui.item_id, pui.transaction_id, pui.user_id, pui.product_name, pui.item_qty, pui.purchase_cost, pui.cart_id, pd.product_id, pd.product_name, pd.image_url, pui.purchase_cost, pui.purchase_date, pui.item_qty, pui.images_url FROM product_details pd INNER JOIN purchased_items pui ON pd.product_id = pui.product_id", nativeQuery=true)