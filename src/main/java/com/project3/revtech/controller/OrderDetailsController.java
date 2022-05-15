package com.project3.revtech.controller;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.PurchasedItemPojo;
import com.project3.revtech.service.PurchasedItemService;
import com.project3.revtech.dao.OrderDetailsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="api/purchased-items")
public class OrderDetailsController {

	@Autowired
    PurchasedItemService purchasedItemService;

    /*@PostMapping("many/post")
    boolean addManyItems(@RequestBody ArrayList<PurchasedItemPojo> items) {
        return purchasedItemService.addMultipleItems(items);
    }*/

    /*@GetMapping("transaction/{bid}/get")
    List<PurchasedItemProduct> getItemsByTransactionId(@PathVariable("bid") int transactionId) {
        return purchasedItemService.getAllPurchasedProductsByTransactionId(transactionId);
    }*/

    /*@GetMapping("user/{bid}/get")
    List<PurchasedItemProduct> getItemsByUserId(@PathVariable("bid") int userId) {
        return purchasedItemService.getAllPurchasedProductsByUserId(userId);
    }*/
    
    @GetMapping("user/order/{cid}")
    public ArrayList<PurchasedItemEntity> findOrder(@PathVariable("cid") int cartId) {
    	CartEntity order = OrderDetailsRespository.findCart(cartId);
    	
    	ArrayList<PurchasedItemEntity> returnOrder = new ArrayList<>();
    	boolean orderChecker = order.isCartPaid();
    	if (orderChecker = true)
    	{
    		PurchasedItemEntity grabOrder = OrderDetailsRespository.findOrder(cartId);
    		returnOrder.add(grabOrder);
    	}
    	
    	return returnOrder;
    }
}
