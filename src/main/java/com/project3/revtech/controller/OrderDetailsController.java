package com.project3.revtech.controller;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.PurchasedItemPojo;
import com.project3.revtech.service.PurchasedItemService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project3.revtech.dao.CartRepository;
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
    OrderDetailsRespository orderDetailsRespository;
	
	@Autowired
	CartRepository cartRepository;
  
	
	@Autowired
    PurchasedItemService purchasedItemService;

	
	//http://localhost:7777/api/purchased-items/order/{ID}
    @GetMapping("order/{cid}")
    List<PurchasedItemProduct> findOrder(@PathVariable("cid") int cartId) {	
    	List<PurchasedItemProduct> grabOrder = purchasedItemService.getAllPurchasedProductsByCartId(cartId);
    	return grabOrder;
    }
    
  //http://localhost:7777/api/purchased-items/order/user/{ID}
    @GetMapping("order/user/{uid}")
    List<CartEntity> findUserOrder(@PathVariable("uid") int userId) {
   	List<CartEntity> userOrders = cartRepository.findUserOrder(userId);
   	return userOrders;
   }
    
    //http://localhost:7777/api/purchased-items/order/tid/5
    @GetMapping("order/tid/{cid}")
    int findTransactionId(@PathVariable("cid") int cId) {
   	return orderDetailsRespository.findTransactionId(cId);
   }
}
