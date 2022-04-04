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
	WishItemRepository wishItemRepository;

	@Override
	public WishListItemPojo addItem(WishListItemPojo item) throws ApplicationException {
		if(item.getWishListQty() < 1) {
			item.setWishItemId(-1);
			return item;
		}
		if(this.checkIfExistsInWishList(item.getWishListId(), item.getProductId())) {
			WishListItemEntity existingItem = wishItemRepository.findByWishListIdAndProductId(item.getWishListId(), item.getProductId());
			item.setWishItemId(existingItem.getWishItemId());
			return this.updateItem(item);
		} else {
			WishListItemEntity itemEntity = new WishListItemEntity(item.getWishListId(), item.getProductId(), item.getWishListQty());
			WishListItemEntity returningItem = wishItemRepository.saveAndFlush(itemEntity);
			item.setWishItemId(returningItem.getWishItemId());
		}
		return item;
	}


	@Override
	public WishListItemPojo updateItem(WishListItemPojo item) throws ApplicationException {
		WishListItemEntity existingItem = wishItemRepository.findByWishListIdAndProductId(item.getWishListId(), item.getProductId());
		
		if(existingItem == null) return addItem(item);
		item.setWishItemId(existingItem.getWishItemId());
		
		if(this.checkIfNoQty(item.getWishListId(), item.getProductId()) || item.getWishListQty() < 1) {
			this.removeItem(item.getWishItemId());
			item.setWishItemId(-1);
		} else {
			WishListItemEntity itemEntity = new WishListItemEntity(item.getWishItemId(), item.getWishListId(), item.getProductId(), item.getWishListQty());
			WishListItemEntity returningItem = wishItemRepository.save(itemEntity);
		}
		return item;
	}

	@Override
	public boolean removeItem(int itemId) throws ApplicationException {
		wishItemRepository.deleteById(itemId);
		return true;
	}

	@Override
	public WishListItemPojo getWishListItem(int wishItemId) throws ApplicationException {
		Optional<WishListItemEntity> optional = wishItemRepository.findById(wishItemId);
		WishListItemPojo wishListItemPojo = null;
		
		if(optional.isPresent()) {
			WishListItemEntity wishListItemEntity = optional.get();
			wishListItemPojo = new WishListItemPojo(
					wishListItemEntity.getWishListId(),
					wishListItemEntity.getWishItemId(),
					wishListItemEntity.getProductId(),
					wishListItemEntity.getWishListQty());
		}
		return wishListItemPojo;
	}


	@Override
	public List<WishListItemPojo> getAllItemsOfWishList(WishListItemPojo wishListItemPojo) throws ApplicationException {
		return null;
	}

	@Override
	public boolean checkIfExistsInWishList(int wishListId, int productId) throws ApplicationException {
		return wishItemRepository.existsByWishListIdAndProductId(wishListId, productId);
	}


	@Override
	public boolean checkIfNoQty(int wishListId, int productId) throws ApplicationException {
		return wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId(1, wishListId, productId);
	}
}
