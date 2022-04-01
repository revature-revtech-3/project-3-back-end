package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.DiscountRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishListItemPojo;
@Service
@Transactional
public class WishListItemServiceImpl implements WishListItemService {
	
	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	DiscountRepository discountRepository;

	@Override
	public WishListItemPojo addItem(WishListItemPojo item) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean removeItem(int itemId) throws ApplicationException {
		wishListRepository.deleteById(itemId);
		return true;
	}

	@Override
	public WishListItemPojo getWishListItem(int item) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public WishListItemPojo updateItem(WishListItemPojo wishListItemPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<WishListItemPojo> getAllItemsOfWishList(WishListItemPojo wishListItemPojo) throws ApplicationException {
		return null;
	
}



	@Override
	public WishListItemPojo updateItem(int wishListId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}}
