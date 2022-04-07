package com.project3.revtech.service;


import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;


public interface WishListItemProductService {
	
	WishListAndItemPojo getAllWishListItemProducts(int wishListId) throws ApplicationException;

	WishListAndItemPojo getAllWishListItemProductsForUser(int userId)throws ApplicationException;
	
	

}
