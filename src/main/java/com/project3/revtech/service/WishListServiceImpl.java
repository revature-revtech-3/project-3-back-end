package com.project3.revtech.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project3.revtech.dao.WishListRepository;

import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.exception.ApplicationException;


import com.project3.revtech.pojo.WishListPojo;

public class WishListServiceImpl implements WishListService {

	@Autowired
	WishListRepository wishListRepository;

	@Override
	public WishListPojo addWishList(WishListPojo wishList) throws ApplicationException {
		WishListEntity wishListEntity = new WishListEntity(wishList.getWishListId(), wishList.getUserId());
		WishListEntity returnWishList = wishListRepository.saveAndFlush(wishListEntity);
		wishList.setWishListId(returnWishList.getWishListId());
		return wishList;
	}

	@Override
	public WishListPojo getWishList(int wishListId)throws ApplicationException {
		WishListEntity wishListEntity = wishListRepository.findByWishListId(wishListId);
		WishListPojo wishList = new WishListPojo(wishListEntity.getWishListId(), wishListEntity.getUserId());
		return wishList;
	}

	@Override
	public WishListPojo getWishListByUserId(int userId) throws ApplicationException {
		WishListEntity wishListEntity = wishListRepository.findByUserId(userId);
		if (wishListEntity == null) {
			WishListPojo newWishList = new WishListPojo(11, userId);
			return addWishList(newWishList);
		
		}
		WishListPojo wishList = new WishListPojo(wishListEntity.getWishListId(), wishListEntity.getUserId());
		return wishList;
	}

	@Override
	public boolean removeWishList(WishListPojo wishListPojo) throws ApplicationException {
		wishListRepository.deleteById(wishListPojo.getWishListId());
		return true;
	}

	@Override
	public WishListPojo updateWishList(WishListPojo wishListPojo) throws ApplicationException {
		WishListEntity wishListEntity = new WishListEntity(wishListPojo.getWishListId(), wishListPojo.getUserId());
		WishListEntity returnWishList = wishListRepository.saveAndFlush(wishListEntity);
		wishListPojo.setWishListId(returnWishList.getWishListId());
		return wishListPojo;
	}
}


	




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





	


