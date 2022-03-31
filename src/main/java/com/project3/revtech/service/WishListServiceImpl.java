package com.project3.revtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;

import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishListPojo;

public class WishListServiceImpl implements WishListService {

	@Autowired
	WishListRepository wishListRepository;
	
//	@Override
//	public WishListAndItemPojo getWishListByUserId(int userId) {
//		WishListEntity wishListEntity =  wishListRepository.findByUserId(userId);
//        if(wishListEntity == null) {
//            WishListAndItemPojo newWishList = new WishListAndItemPojo(wishListEntity.getWishlistId(), wishListEntity.getUserId(), wishListEntity.getWishListItems());
//            return addCart(newCart);
//        }
//        CartPojo cart = new CartPojo(WishListEntity.getCartId(), cartEntity.getUserId(), cartEntity.getCartTotal(), cartEntity.isCartPaid(), cartEntity.isCartRemoved());
//        return cart;
//	}

//	@Override
//	public WishlistPojo updateWishList(WishlistPojo wishlistPojo) throws ApplicationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ProductPojo getWishListItem(int productId) throws ApplicationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean removeProduct(int productId) throws ApplicationException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void createWishList(WishlistPojo wishlistPojo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<WishlistPojo> readWishList(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
