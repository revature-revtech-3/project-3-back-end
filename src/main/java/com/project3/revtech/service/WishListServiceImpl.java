package com.project3.revtech.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.WishListPojo;


@Service
@Transactional
public class WishListServiceImpl implements WishListService {

	@Autowired
	WishListRepository wishListRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public WishListPojo addWishList(WishListPojo wishList) throws ApplicationException {
		UserEntity user = userRepository.findById(wishList.getUserId()).get();
		
		WishListEntity wishListEntity = new WishListEntity(wishList.getWishListId(), user);
		WishListEntity returnWishList = wishListRepository.saveAndFlush(wishListEntity);
		wishList.setWishListId(returnWishList.getWishListId());
		return wishList;
	}
	
	@Override
	public WishListPojo updateWishList(WishListPojo wishListPojo) throws ApplicationException {
		UserEntity user = userRepository.findById(wishListPojo.getUserId()).get();
		
		WishListEntity wishListEntity = new WishListEntity(wishListPojo.getWishListId(), user);
		WishListEntity returnWishList = wishListRepository.saveAndFlush(wishListEntity);
		wishListPojo.setWishListId(returnWishList.getWishListId());
		return wishListPojo;
	}

	@Override
	public WishListPojo getWishList(int wishListId) throws ApplicationException {
		WishListEntity wishListEntity = wishListRepository.findByWishListId(wishListId);
		WishListPojo wishList = new WishListPojo(wishListEntity.getWishListId(), wishListEntity.getUserEntity().getUserId());
		return wishList;
	}

	@Override
	public WishListPojo getWishListByUserId(int userId) throws ApplicationException {
		
		WishListPojo newWishList = null;
		
		WishListEntity wishListEntity = wishListRepository.getWishListByUserId(userId);
		if (wishListEntity == null) {
			newWishList = new WishListPojo(1, userId);
			return addWishList(newWishList);
		}

		UserEntity user = userRepository.findById(newWishList.getUserId()).get();

		WishListPojo wishList = new WishListPojo(wishListEntity.getWishListId(), wishListEntity.getUserEntity().getUserId());
		return wishList;
	}

	@Override
	public boolean removeWishList(WishListPojo wishListPojo) throws ApplicationException {
		wishListRepository.deleteById(wishListPojo.getWishListId());
		return true;
	}

}

