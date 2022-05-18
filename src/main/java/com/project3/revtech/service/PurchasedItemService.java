package com.project3.revtech.service;

import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.PurchasedItemPojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface PurchasedItemService {
    PurchasedItemPojo addItem(PurchasedItemPojo item);
    PurchasedItemPojo getItem(int itemId);
    boolean addMultipleItems(ArrayList<PurchasedItemPojo> itemList);
    List<PurchasedItemProduct> getAllPurchasedProductsByTransactionId(int transactionId);
    List<PurchasedItemProduct> getAllPurchasedProductsByUserId(int userId);
    List<PurchasedItemProduct> findByMostPurchasedItems();
    List<PurchasedItemProduct> getAllPurchasedProductsByCartId(int cartId);
}
