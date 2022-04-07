package com.project3.revtech.service;


import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;


public interface WishListItemProductService {
	
	WishListAndItemPojo getAllWishListItemProducts(int wishListId) throws ApplicationException;

	List<WishListAndItemPojo> getAllWishListItemProductsForUser(int userId)throws ApplicationException;
	
	

}
