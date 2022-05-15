package com.project3.revtech.controller;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.PurchasedItemPojo;
import com.project3.revtech.service.PurchasedItemService;
import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.dao.OrderDetailsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="api/order-details")
public class OrderDetailsController {

	@Autowired
    OrderDetailsRespository orderDetailsRespository;
	@Autowired
	CartRepository cartRepository;
    
    @GetMapping("order/{cid}")
    List<PurchasedItemEntity> findOrder(@PathVariable("cid") int cartId) {	
    	List<PurchasedItemEntity> grabOrder = orderDetailsRespository.findOrder(cartId);
    	return grabOrder;
    }
    
    @GetMapping("order/{uid}")
    List<CartEntity> findUserOrder(@PathVariable("uid") int userId) {
    	List<CartEntity> userOrders = cartRepository.findUserOrder(userId);
    	return userOrders;
    }
}
