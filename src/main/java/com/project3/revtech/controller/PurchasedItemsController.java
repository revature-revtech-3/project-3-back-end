package com.project3.revtech.controller;

import com.project3.revtech.dao.ProductDataRepository;
import com.project3.revtech.entity.ProductDataEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.ProductDataPojo;
import com.project3.revtech.pojo.PurchasedItemPojo;
import com.project3.revtech.service.PurchasedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="api/purchased-items")
public class PurchasedItemsController {

    @Autowired
    PurchasedItemService purchasedItemService;
    
    @Autowired
    ProductDataRepository productDataRepository;

    @PostMapping("many/post")
    boolean addManyItems(@RequestBody ArrayList<PurchasedItemPojo> items) {
        return purchasedItemService.addMultipleItems(items);
    }

    @GetMapping("transaction/{bid}/get")
    List<PurchasedItemProduct> getItemsByTransactionId(@PathVariable("bid") int transactionId) {
        return purchasedItemService.getAllPurchasedProductsByTransactionId(transactionId);
    }

    @GetMapping("user/{bid}/get")
    List<PurchasedItemProduct> getItemsByUserId(@PathVariable("bid") int userId) {
        return purchasedItemService.getAllPurchasedProductsByUserId(userId);
    }
    
    @GetMapping("admin/trackpurchase")
    List<ProductDataEntity> getPurchases(){return productDataRepository.findAllByPurchase();};
    
    @GetMapping("admin/tracksales")
    List<ProductDataEntity> getSales(){return productDataRepository.findAllBySales();};

    @GetMapping("admin/sum")
    int getsum(){return productDataRepository.findSum();};

//    @PostMapping("user/{bid}/get")
//    List<PurchasedItemProduct> getItemsByUserId1(@PathVariable("bid") int userId) {
//        return purchasedItemService.getAllPurchasedProductsByUserId(userId);
//    }
//    
    	@GetMapping("purchasedItems")
    	List<PurchasedItemProduct>findByMostPurchasedItems(){
    	return purchasedItemService.findByMostPurchasedItems();
   }
}
