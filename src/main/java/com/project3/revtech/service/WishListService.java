package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishlistPojo;

public interface WishListService {
	
	 
	   WishlistPojo updateWishList(WishlistPojo wishlistPojo) throws ApplicationException;
	   
	   ProductPojo getWishListItem(int productId) throws ApplicationException;
	     
	   boolean removeProduct(int productId) throws ApplicationException;
	   
	   void createWishList(WishlistPojo wishlistPojo);
	   
	   public List<WishlistPojo> readWishList(int userId);
	   
	  //If problems occur, change type to Integer
	   
	   
	    

}
