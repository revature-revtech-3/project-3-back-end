package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishListPojo;

public interface WishListService {
  
  	WishListPojo addWishList(WishListPojo wishList) throws ApplicationException;

	WishListPojo getListByUserId(int userId) throws ApplicationException;

	boolean removeWishList(WishListPojo wishList) throws ApplicationException;

}
