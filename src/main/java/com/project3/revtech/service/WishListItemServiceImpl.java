package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.dao.DiscountRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartPojo;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishListItemPojo;
import com.project3.revtech.pojo.WishListPojo;
@Service
@Transactional
public class WishListItemServiceImpl implements WishListItemService {
	
	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	DiscountRepository discountRepository;
	
	@Autowired
	WishItemRepository wishItemRepository;

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
	public List<WishListEntity> getAllItemsOfWishList() throws ApplicationException {
		
		 return wishListRepository.findAll();
}

	@Override
	public WishListItemPojo updateItem(WishListItemPojo wishListItemPojo) throws ApplicationException {
	       WishListItemEntity existingItem = wishListRepository.findByWishListIdAndProductId(wishListItemPojo.getWishListId(), wishListItemPojo.getProductId());
	        if(existingItem == null) return addItem(wishListItemPojo);
	        wishListItemPojo.setWishItemId(existingItem.getWishItemId());
	        if(this.checkIfNoQty(wishListItemPojo.getWishListId(), wishListItemPojo.getProductId()) || wishListItemPojo.getWishListQty() < 1) {
	            this.removeItem(wishListItemPojo.getWishItemId());
	            wishListItemPojo.setWishItemId(-1);
	        } else {
	            WishListItemEntity itemEntity = new WishListItemEntity(wishListItemPojo.getWishItemId(), wishListItemPojo.getWishListId(), wishListItemPojo.getProductId(), wishListItemPojo.getWishListQty());
//	            CartItem returningItem = cartItemRepository.
	            WishListItemEntity returningItem = wishListRepository.save(itemEntity);
	        }

	        return wishListItemPojo;
	    }
	
	 @Override
	    public boolean checkIfNoQty(int wishListId, int productId) throws ApplicationException {
	        return wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId();
	    }



	@Override
	public boolean checkIfExistsInWishList(int wishListId, int productId) throws ApplicationException {
		// TODO Auto-generated method stub
		return wishItemRepository.existsByWishListIdAndProductId(wishListId, productId);
	}





}







