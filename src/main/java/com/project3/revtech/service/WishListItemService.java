package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.WishListItemPojo;

public interface WishListItemService {
	
    WishListItemPojo addItem(WishListItemPojo wishListItemPojo) throws ApplicationException;
    
   // WishListItemPojo updateItem(WishListItemPojo wishListItemPojo) throws ApplicationException;
    
    WishListItemPojo getWishListItem(int wishListId) throws ApplicationException;
    
    List<WishListItemPojo> getAllItemsOfWishList(WishListItemPojo wishListItemPojo) throws ApplicationException;
    
    boolean removeItem(int itemId) throws ApplicationException;
	
   // boolean checkIfExistsInWishList(int wishListId, int productId) throws ApplicationException;
    
   // boolean checkIfNoQty(int wishListId, int productId) throws ApplicationException;


}
