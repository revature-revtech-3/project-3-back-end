package com.project3.revtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.WishListPojo;

import com.project3.revtech.service.WishListServiceImpl;

@RestController
@RequestMapping("api/wishList")
@CrossOrigin
public class WishListController {
	
	  @Autowired
	    WishListServiceImpl wishListService;

	    @PostMapping("add/wishLists")
	    ResponseEntity<WishListPojo> addWishList(@RequestBody WishListPojo wishList) throws ApplicationException {
	        return ResponseEntity.ok()
	                .header("Content-type", "application/json")
	                .body(wishListService.addWishList(wishList));

	    }

	    @PutMapping("update/wishLists")
	    ResponseEntity<WishListPojo> updateWishList(@RequestBody WishListPojo wishList) throws ApplicationException {
	        return ResponseEntity.ok()
	                .header("Content-type", "application/json")
	                .body(wishListService.updateWishList(wishList));

	    }

	
	
	
	
	
	

}
